/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: Video.java
 *
 */

package com.subhasmita.streamverse.media.entity;

import com.subhasmita.streamverse.media.enums.MediaType;
import com.subhasmita.streamverse.media.enums.VideoStatues;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "content_id")
    private UUID contentId;

    @Column(name = "content_type")
    private String contentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type")
    private MediaType mediaType;

    @Column(name = "processed_resolutions")
    private Integer processedResolutions;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VideoStatues status;

    @Column(name = "master_playlist_path")
    private String masterPlaylistPath;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VideoFileMetadata> files;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VideoUploadingStatus> statuses;
}
