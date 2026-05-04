package com.hexa.lean.domain.port.out;

import com.hexa.lean.domain.model.ExecutionResult;
import com.hexa.lean.domain.model.LeanContext;
import com.hexa.lean.domain.model.SystemCommand;

import java.util.Optional;

public interface LlmProviderPort {

    /**
     * Envía el contexto completo al modelo de IA y espera su análisis.
     *
     * @param context El contexto ensamblado con personalidad y recuerdos.
     * @return Un Optional con el comando de sistema a ejecutar,
     *         o vacío si la IA solo quiere conversar.
     */
    Optional<SystemCommand> analyzeIntent(LeanContext context);

    /**
     * Genera una respuesta de texto natural para el usuario.
     *
     * @param context El contexto ensamblado.
     * @param actionResult El resultado de la acción que acaba de ejecutar (opcional).
     * @return Texto de respuesta de Lean (ej: "Listo, abrí Firefox").
     */
    String generateResponse(LeanContext context, ExecutionResult actionResult);
}