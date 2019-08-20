package com.ekh.backend.edge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/edge")
@Slf4j
class EdgeController {

    private EdgeService edgeService;

    public EdgeController(EdgeService edgeService) {
        this.edgeService = edgeService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Edge>> getBlogInformation() {
        return new ResponseEntity<>(edgeService.getAllBlogInformation().join(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Edge> addEdgeRequest() {
        return new ResponseEntity<>(edgeService.addEdge().join(), HttpStatus.CREATED);
    }

}