package com.aizoon.rendicontazione.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aizoon.rendicontazione.model.dto.response.AnnouncementResponse;
import com.aizoon.rendicontazione.repository.AnnouncementsRepository;

@Service
public class AnnouncementsService {
    
    private final AnnouncementsRepository announcementsRepository;

    public AnnouncementsService(AnnouncementsRepository announcementsRepository) {
        this.announcementsRepository = announcementsRepository;
    }

    public List<AnnouncementResponse> findAllAnnouncements() {
        return announcementsRepository.findAll().stream()
            .map( announcement -> new AnnouncementResponse().from(announcement))
            .toList();
    }


}
