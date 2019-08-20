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
//        List<Edge> blogInformation = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            blogInformation.add(new Edge());
//        }
        return CompletableFuture.completedFuture(blogInformation);
    }
    @Async
    @Override
    public CompletableFuture<Edge> addEdge() {
        Edge added = new Edge();
        blogInformation.add(added);
        return CompletableFuture.completedFuture(added);
    }
}
