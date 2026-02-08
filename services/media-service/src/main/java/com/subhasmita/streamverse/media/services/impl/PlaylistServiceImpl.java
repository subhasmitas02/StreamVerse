/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: PlaylistServiceImpl.java
 *
 */

package com.subhasmita.streamverse.media.services.impl;

import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.entity.Video;
import com.subhasmita.streamverse.media.services.PlaylistService;
import com.subhasmita.streamverse.media.services.VideoService;
import com.subhasmita.streamverse.media.services.VideoStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.subhasmita.streamverse.media.services.VideoStorageService.PATH_CHUNK_TEMPLATE;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final VideoStorageService videoStorage;
    private final VideoService videoService;

    @Override
    public void createMasterPlaylist(UUID videoId) {
        VideoDto video = videoService.getVideoById(videoId);

        String content = video.files().stream()
                .map(file -> String.format("#EXT-X-STREAM-INF:BANDWIDTH=%d,RESOLUTION=%dx%d\n%s\n",
                        file.resolution().bitrate(),
                        file.resolution().width(),
                        file.resolution().height(),
                        file.playlistPath()))
                .collect(Collectors.joining("", "#EXTM3U\n", ""));

        String link = String.format("video/hls/%s/master.m3u8", video.id());

        try {
            this.videoStorage.uploadFile(link, new ByteArrayInputStream(content.getBytes()), content.length(),
                    "application/vnd.apple.mpegurl");
            this.videoService.updateMasterPlaylistUrl(link, video.id());
        } catch (Exception e) {
            throw new RuntimeException("Failed to save master playlist", e);
        }
    }

    @Override
    public Resource getMasterPlaylistResource(UUID videoId) {
        String masterPlaylistPath = this.videoService.getVideoById(videoId).masterPlaylistPath();
        return new InputStreamResource(videoStorage.getFileInputStream(masterPlaylistPath));
    }

    @Override
    public Resource getVideoSegmentResource(UUID videoId, int resolution, int chunkIndex) {
        String segmentPath = String.format(PATH_CHUNK_TEMPLATE, resolution, videoId, chunkIndex);
        return new InputStreamResource(videoStorage.getFileInputStream(segmentPath));
    }
}
