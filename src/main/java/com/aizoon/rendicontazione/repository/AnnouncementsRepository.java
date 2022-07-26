package com.aizoon.rendicontazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aizoon.rendicontazione.model.entity.Announcement;

@Repository
public interface AnnouncementsRepository extends JpaRepository<Announcement, Long> {
    
}
