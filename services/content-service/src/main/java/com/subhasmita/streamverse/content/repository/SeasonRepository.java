package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Season;
import com.subhasmita.streamverse.content.enums.RecordStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
    Optional<Season> findAllByContentId(UUID contentId);

    Optional<Season> findByIdAndRecordStatusNot(UUID seasonId, RecordStatus recordStatus);
}
