package com.ekh.backend.edge;

import com.ekh.backend.exception.ResourceNotFoundException;
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

    @GetMapping
    public ResponseEntity<List<Edge>> getBlogInformation() {
        return new ResponseEntity<>(edgeService.getAllBlogInformation().join(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Edge> addEdgeRequest() {
        return new ResponseEntity<>(edgeService.addEdge().join(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Edge> modifyEdgeRequest(
            @RequestBody Edge edge) {
        try {
            Edge modifiedEdge = edgeService.modifyEdge(edge).join();
            return new ResponseEntity<>(modifiedEdge, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}