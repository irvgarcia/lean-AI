package com.hexa.lean.domain.port.in;

import com.hexa.lean.domain.model.ExecutionResult;

public interface ProcessUserIntentUseCase {

    /**
     * Procesa una instrucción en lenguaje natural del usuario.
     *
     * @param userMessage El mensaje crudo, ej: "Lean, abre el navegador"
     * @return ExecutionResult con el resultado de la operación o la respuesta de texto.
     */
    ExecutionResult process(String userMessage);
}