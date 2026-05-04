package com.hexa.lean.application.service;

import com.hexa.lean.domain.model.*;
import com.hexa.lean.domain.port.in.ProcessUserIntentUseCase;
import com.hexa.lean.domain.port.out.LlmProviderPort;
import com.hexa.lean.domain.port.out.MemoryRepositoryPort;
import com.hexa.lean.domain.port.out.PersonalityRepositoryPort;
import com.hexa.lean.domain.port.out.SystemOperatorPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IntentProcessorService implements ProcessUserIntentUseCase {

    private final MemoryRepositoryPort memoryRepository;
    private final PersonalityRepositoryPort personalityRepository;
    private final LlmProviderPort llmProvider;
    private final SystemOperatorPort systemOperator;

    @Override
    public ExecutionResult process(String userMessage) {
        log.info("Recibiendo instrucción para Lean: {}", userMessage);

        // 1. Preparar la mente de Lean (RAG + Personalidad)
        LeanContext context = buildContext(userMessage);

        // 2. El modelo de IA local analiza qué debe hacer
        Optional<SystemCommand> possibleCommand = llmProvider.analyzeIntent(context);

        // 3. Evaluar la decisión del LLM
        if (possibleCommand.isPresent()) {
            SystemCommand command = possibleCommand.get();
            log.info("Lean ha decidido ejecutar la acción: {}", command.action());

            // 3.1 Ejecutar el comando en el sistema host
            ExecutionResult actionResult = systemOperator.execute(command);

            // 3.2 Generar una respuesta natural ("Ya creé la carpeta, señor")
            String naturalResponse = llmProvider.generateResponse(context, actionResult);

            // 3.3 Devolver el resultado empaquetado
            return new ExecutionResult(actionResult.isSuccessful(), naturalResponse, actionResult.rawOutput());
        }

        // 4. Si la IA decide que no hay comandos que ejecutar, es solo una charla
        log.info("La intención no requiere comandos del sistema. Generando respuesta conversacional.");
        String conversationalResponse = llmProvider.generateResponse(context, null);

        return ExecutionResult.success(conversationalResponse, "No execution needed");
    }

    /**
     * Método auxiliar privado para ensamblar todo el contexto que la IA necesita
     * antes de procesar el mensaje.
     */
    private LeanContext buildContext(String userMessage) {
        PersonalityProfile profile = personalityRepository.getActiveProfile();

        // Traemos el top 5 de recuerdos más relevantes usando similitud vectorial
        List<MemoryFragment> memories = memoryRepository.findRelevantMemories(userMessage, 5);

        return new LeanContext(profile, memories, userMessage);
    }
}
