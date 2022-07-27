package com.aizoon.rendicontazione.service;

import com.aizoon.rendicontazione.error.exceptions.ResourceNotFoundException;
import com.aizoon.rendicontazione.model.dto.request.RequestRequest;
import com.aizoon.rendicontazione.model.dto.response.RequestResponse;
import com.aizoon.rendicontazione.model.entity.Request;
import com.aizoon.rendicontazione.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    public List<RequestResponse> findRequests() {
        return requestRepository.findAll().stream()
                .map(u -> new RequestResponse().from(u))
                .toList();
    }

    public RequestResponse updateRequest(RequestRequest userRequest, Long requestID) throws ResourceNotFoundException {
        if(requestRepository.findById(requestID).isEmpty()) {
            throw new ResourceNotFoundException("Domanda with id " + requestID + " not found");
        }

        Request request = userRequest.to(new Request());
        requestRepository.save(request);

        return new RequestResponse().from(request);
    }
}
