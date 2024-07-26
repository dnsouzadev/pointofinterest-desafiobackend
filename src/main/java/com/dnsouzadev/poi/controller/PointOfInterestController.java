package com.dnsouzadev.poi.controller;

import com.dnsouzadev.poi.controller.dto.CreatePointOfInterest;
import com.dnsouzadev.poi.entity.PointOfInterest;
import com.dnsouzadev.poi.repository.PointOfInterestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfInterestController {

    private final PointOfInterestRepository repository;

    public PointOfInterestController(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/poi")
    public ResponseEntity<Void> create(@RequestBody CreatePointOfInterest body) {
        repository.save(new PointOfInterest(body.name(), body.x(), body.y()));
        return ResponseEntity.ok().build();
    }

}
