package com.aizoon.rendicontazione.repository;

import com.aizoon.rendicontazione.model.entity.AnnouncementApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementApplicationRepository extends JpaRepository<AnnouncementApplication, Long> {

}
