package com.aizoon.rendicontazione.service;

import com.aizoon.rendicontazione.error.exceptions.ResourceNotFoundException;
import com.aizoon.rendicontazione.model.dto.request.AnnouncementApplicationRequest;
import com.aizoon.rendicontazione.model.dto.response.AnnouncementApplicationResponse;
import com.aizoon.rendicontazione.model.entity.AnnouncementApplication;
import com.aizoon.rendicontazione.repository.AnnouncementApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class AnnouncementApplicationService {

    private final AnnouncementApplicationRepository applicationsRepository;

    public AnnouncementApplicationService(AnnouncementApplicationRepository requestRepository) {
        this.applicationsRepository = requestRepository;
    }

    public List<AnnouncementApplicationResponse> findApplications() {
        return applicationsRepository.findAll().stream()
                .map(application -> new AnnouncementApplicationResponse().from(application))
                .toList();
    }

    public List<AnnouncementApplicationResponse> findApplicationsByAnnouncementID(Long announcementID) {
        return applicationsRepository.findByAnnouncementID(announcementID).stream()
                .map(application -> new AnnouncementApplicationResponse().from(application))
                .toList();
    }

    public AnnouncementApplicationResponse patchApplication(AnnouncementApplicationRequest request, Long id) throws ResourceNotFoundException {
        AnnouncementApplication application = applicationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find announcement application with id: " + id));

        
        boolean isApproved = request.isApprovationStatus();
        if(isApproved) {
            //TODO Custom exception
            Double approvedMoneyAmount = request.getApprovedMoneyAmount();
            if(approvedMoneyAmount == null) {
                throw new RuntimeException("Money amount needs to be specified when approving");
            } else if(approvedMoneyAmount > application.getMoneyAmount()) {
                throw new RuntimeException("Money amount can't be greater than current amount");
            }
            application.setApprovedMoneyAmount( approvedMoneyAmount );
        }

        application.setApprovationStatus( isApproved );

        applicationsRepository.save(application);
        return new AnnouncementApplicationResponse().from(applicationsRepository.save(application));
    }

}
