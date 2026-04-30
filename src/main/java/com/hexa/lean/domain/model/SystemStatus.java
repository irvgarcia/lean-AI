package com.hexa.lean.domain.model;

public record SystemStatus(
        String metricName,
        String rawValue,
        boolean isHealthy
) {
}