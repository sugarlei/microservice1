package com.ln.trace;

import java.util.List;
import java.util.Map;

public interface CustomeTraceRepository {
    List<CustomTrace> findAll();

    void add(Map<String, Object> arg0);
}