package com.hexa.lean.domain.port.out;

import com.hexa.lean.domain.model.ExecutionResult;
import com.hexa.lean.domain.model.SystemCommand;

public interface SystemOperatorPort {

    /**
     * Ejecuta una acción estructurada en el sistema host.
     *
     * @param command El comando estructurado que el LLM decidió ejecutar.
     * @return ExecutionResult indicando éxito, fracaso y la salida de la terminal.
     */
    ExecutionResult execute(SystemCommand command);

    /**
     * Lee métricas básicas del sistema de forma segura.
     *
     * @return Texto con el estado actual (RAM, CPU, etc.)
     */
    String readSystemMetrics();
}