package com.hexa.lean.domain.model;

public record MemoryFragment(
        String content,          // Ej: "El usuario está creando un orquestador de pagos"
        double relevanceScore    // Qué tan relevante es este recuerdo para la charla actual (0.0 a 1.0)
) {}