package com.ekh.backend.edge;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
public class Edge {
    private Integer id = new Random().nextInt(100);
    private String name = "123";
}
