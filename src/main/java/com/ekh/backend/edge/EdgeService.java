package com.ekh.backend.edge;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface EdgeService {
    CompletableFuture<List<Edge>> getAllBlogInformation();
}
