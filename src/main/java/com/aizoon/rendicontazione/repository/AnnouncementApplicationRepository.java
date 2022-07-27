package com.aizoon.rendicontazione.repository;

import com.aizoon.rendicontazione.model.entity.AnnouncementApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementApplicationRepository extends JpaRepository<AnnouncementApplication, Long> {

    @Query("SELECT a FROM AnnouncementApplication a WHERE a.announcement.announcementId = ?1")
    List<AnnouncementApplication> findByAnnouncementID(Long announcementID);

}
