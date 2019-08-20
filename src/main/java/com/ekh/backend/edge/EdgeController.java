package com.ekh.backend.edge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
class EdgeController {

    private EdgeService edgeService;

    public EdgeController(EdgeService edgeService) {
        this.edgeService = edgeService;
    }

    @CrossOrigin
    @GetMapping(path = "edge")
    public ResponseEntity<List<Edge>> getBlogInformation() {
        return new ResponseEntity<>(edgeService.getAllBlogInformation().join(), HttpStatus.ACCEPTED);
    }
}