package com.example.knowledge_managing.common;

import lombok.Data;

import java.util.List;
import java.util.Objects;
@Data
public class CachedResult {
    private Integer begin_index;
    private Integer end_index;
    private List<DocumentResult> results;
//    todo：需加入整体统计结果
}
