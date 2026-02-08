package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<Episode, UUID> {
}
