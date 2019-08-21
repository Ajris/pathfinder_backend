package com.ekh.backend.edge;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EdgeServiceImpl implements EdgeService {
    private List<Edge> blogInformation = new ArrayList<>();

    @Async
    @Override
    public CompletableFuture<List<Edge>> getAllBlogInformation() {
        return CompletableFuture.completedFuture(blogInformation);
    }

    @Async
    @Override
    public CompletableFuture<Edge> addEdge() {
        Edge added = new Edge();
        blogInformation.add(added);
        return CompletableFuture.completedFuture(added);
    }

    @Async
    @Override
    public CompletableFuture<Edge> modifyEdge(int edgeId, String newName) {
        Edge edge = blogInformation
                .stream()
                .filter(e -> e.getId().equals(edgeId))
                .reduce((a, b) -> {
                    throw new IllegalStateException("Two edges with the same id exist");
                })
                .get();
        edge.setName(newName);
        return CompletableFuture.completedFuture(edge);
    }
}
