package com.aizoon.rendicontazione.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizoon.rendicontazione.model.dto.response.AnnouncementResponse;
import com.aizoon.rendicontazione.service.AnnouncementsService;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    
    private final AnnouncementsService announcementsService;

    public AnnouncementController(AnnouncementsService announcementsService) {
        this.announcementsService = announcementsService;
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementResponse>> findAllAnnouncements() {
        return ResponseEntity.ok(
            announcementsService.findAllAnnouncements()
        );
    }

}
