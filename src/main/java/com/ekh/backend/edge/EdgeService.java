package com.ekh.backend.edge;

import com.ekh.backend.exception.ResourceNotFoundException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface EdgeService {
    CompletableFuture<List<Edge>> getAllBlogInformation();
    CompletableFuture<Edge> addEdge();
    CompletableFuture<Edge> modifyEdge(Edge edge) throws ResourceNotFoundException;
}
