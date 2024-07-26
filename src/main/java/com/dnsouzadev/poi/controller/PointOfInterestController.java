package com.dnsouzadev.poi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnsouzadev.poi.controller.dto.CreatePointOfInterest;
import com.dnsouzadev.poi.entity.PointOfInterest;
import com.dnsouzadev.poi.repository.PointOfInterestRepository;


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

    @GetMapping("/poi")
    public ResponseEntity<Page<PointOfInterest>> listPoi(@RequestParam(name="page", defaultValue="0") Integer page, @RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
        var body = repository.findAll(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(body);
    }

    @GetMapping("/near-poi")
    public ResponseEntity<List<PointOfInterest>> listPoi(@RequestParam("x") Integer x, @RequestParam("y") Integer y, @RequestParam("dmax") Integer dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        var body = repository.findNear(xMin, xMax, yMin, yMax);
        return ResponseEntity.ok(body);
    }


}
