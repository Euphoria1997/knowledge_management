package com.example.knowledge_managing.entity;

import lombok.Data;

import java.util.List;

@Data
public class TreeStatistics {
    private String level;
    private Integer number; //从属level的document总数
    private List<TreeStatistics> children;

}
