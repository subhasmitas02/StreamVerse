/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoProcessingServiceImpl.java
 *
 */

package com.subhasmita.streamverse.media.services.impl;

import com.subhasmita.streamverse.media.dto.ResolutionDto;
import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.dto.VideoFileMetadataDto;
import com.subhasmita.streamverse.media.kafka.KafkaVideoProcessingProducer;
import com.subhasmita.streamverse.media.kafka.messages.StartConvertingMessage;
import com.subhasmita.streamverse.media.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoProcessingServiceImpl implements VideoProcessingService {

    private final VideoService videoService;
    private final KafkaVideoProcessingProducer kafkaVideoProcessingProducer;
    private final VideoUploadStatusService videoUploadStatusService;
    private final VideoStorageService videoStorage;
    private final VideoCompressingService videoCompressingService;
    private final VideoFileMetadataService videoFileMetadataService;
    private final ResolutionService resolutionService;
    private final PlaylistService playlistService;

    @Override
    public void processMediaFile(StartConvertingMessage message) {
        VideoDto videoDto = this.videoService.getVideoById(message.videoId());

        String playlist = this.videoCompressingService.compressVideoAndUploadToStorage(message.resolution(), message.videoId());

        videoFileMetadataService.updateMetadata(message.metadataId(), true, playlist);

        if (isVideoProcessingFinished(videoDto)) {
            finalizeVideoProcessing(videoDto);
        }
    }

    @Override
    public void startVideoProcessing(UUID id) {
        VideoDto video = this.videoService.getVideoById(id);
        List<ResolutionDto> resolutions = resolutionService.getAllResolutions();

        for (ResolutionDto resolution : resolutions) {
            VideoFileMetadataDto metadata = videoFileMetadataService.createMetadata(video, resolution);
            StartConvertingMessage message = new StartConvertingMessage(metadata.id(), video.id(), resolution);
            kafkaVideoProcessingProducer.sendTaskToQueue(message);
        }
    }

    private boolean isVideoProcessingFinished(VideoDto videoDto) {
        VideoDto video = videoService.getVideoById(videoDto.id());
        return video.files().stream().allMatch(VideoFileMetadataDto::isProcessed);
    }

    private void finalizeVideoProcessing(VideoDto videoDto) {
        playlistService.createMasterPlaylist(videoDto.id());
        videoStorage.deleteVideo(videoDto.id());
    }
}
