package com.ekh.backend.edge;

import com.ekh.backend.exception.ResourceNotFoundException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Async
    @Override
    public CompletableFuture<Edge> modifyEdge(Edge edge) throws ResourceNotFoundException {
//        blogInformation.stream()
//                .filter(x -> x.getId())
        int modifiedIdx = blogInformation.indexOf(edge);
        if (modifiedIdx != -1) {
            blogInformation.set(modifiedIdx, edge);
            return CompletableFuture.completedFuture(edge);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
