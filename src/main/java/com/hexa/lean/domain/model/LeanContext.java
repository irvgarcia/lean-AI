package com.hexa.lean.domain.model;

import java.util.List;

public record LeanContext(
        PersonalityProfile personality,
        List<MemoryFragment> activeMemories,
        String currentUserMessage
) {
    // Método de dominio para validar que el contexto está listo
    public boolean isReadyForProcessing() {
        return personality != null && currentUserMessage != null && !currentUserMessage.isBlank();
    }
}