package com.example.demo1.logic;

public class TableRow {
    private final Integer id;
    private final Integer n;
    private final Integer threads;
    private final Double integralResult;
    private final Long time;

    public TableRow(int id, int n, int threads, double integralResult, long time) {
        this.id = id;
        this.n = n;
        this.threads = threads;
        this.integralResult = integralResult;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public Integer getN() {
        return n;
    }

    public Integer getThreads() {
        return threads;
    }

    public Double getResult() {
        return integralResult;
    }

    public Long getTime() {
        return time;
    }
}
