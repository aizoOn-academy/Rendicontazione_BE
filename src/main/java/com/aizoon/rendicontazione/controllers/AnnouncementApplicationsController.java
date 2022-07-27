package com.aizoon.rendicontazione.controllers;

import com.aizoon.rendicontazione.error.exceptions.ResourceNotFoundException;
import com.aizoon.rendicontazione.model.dto.request.AnnouncementApplicationRequest;
import com.aizoon.rendicontazione.model.dto.response.AnnouncementApplicationResponse;
import com.aizoon.rendicontazione.service.AnnouncementApplicationService;

import org.hibernate.annotations.Fetch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class AnnouncementApplicationsController {
    private final AnnouncementApplicationService requestService;

    public AnnouncementApplicationsController(AnnouncementApplicationService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementApplicationResponse>> findApplications() {
        return ResponseEntity.ok(
            requestService.findApplications()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AnnouncementApplicationResponse> updateApplication(@RequestBody @Valid AnnouncementApplicationRequest request, @PathVariable("id") Long id) {
        return ResponseEntity.ok(
            requestService.patchApplication(request, id)
        );
    }

}
