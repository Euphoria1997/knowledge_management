package com.example.knowledge_managing.strategy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;

public class P6SpyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int i, String s, long l, String s1, String s2, String s3, String s4) {
        return !"".equals(s4.trim()) ? "[ " + LocalDateTime.now() + " ] --- | took "
                + l + "ms | " + s2 + " | connection " + i + "\r "
                + s4 + ";" : "";
    }
}