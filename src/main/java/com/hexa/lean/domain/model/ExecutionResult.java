package com.hexa.lean.domain.model;

public record ExecutionResult(
        boolean isSuccessful,
        String message,      // Mensaje para el usuario o la IA (ej. "Carpeta creada")
        String rawOutput     // La salida cruda de la terminal de Arch Linux
) {
    // Métodos estáticos de fábrica para código más limpio
    public static ExecutionResult success(String message, String rawOutput) {
        return new ExecutionResult(true, message, rawOutput);
    }

    public static ExecutionResult failure(String errorMessage) {
        return new ExecutionResult(false, errorMessage, "");
    }
}