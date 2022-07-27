package com.aizoon.rendicontazione.controllers;

import com.aizoon.rendicontazione.error.exceptions.ResourceNotFoundException;
import com.aizoon.rendicontazione.model.dto.request.RequestRequest;
import com.aizoon.rendicontazione.model.dto.response.RequestResponse;
import com.aizoon.rendicontazione.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<RequestResponse>> findRequest() {
        return ResponseEntity.ok(
                requestService.findRequests()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestResponse> updateRequest(@Valid @RequestBody RequestRequest request, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(
                requestService.updateRequest(request, id)
        );
    }

}
