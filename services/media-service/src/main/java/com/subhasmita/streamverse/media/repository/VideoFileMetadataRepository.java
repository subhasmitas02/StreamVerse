package com.subhasmita.streamverse.media.repository;

import com.subhasmita.streamverse.media.entity.VideoFileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoFileMetadataRepository extends JpaRepository<VideoFileMetadata, UUID> {

}
