package com.hexa.lean.application.service;

import com.hexa.lean.domain.port.in.ManageMemoryUseCase;
import com.hexa.lean.domain.port.out.MemoryRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemoryManagementService implements ManageMemoryUseCase {

    private final MemoryRepositoryPort memoryRepository;

    @Override
    public void rememberFact(String fact) {
        log.info("Inyectando nuevo conocimiento en la memoria vectorial: {}", fact);
        memoryRepository.saveFact(fact);
    }

    @Override
    public void forgetFact(Long memoryId) {
        log.warn("Eliminando conocimiento con ID: {}", memoryId);
        memoryRepository.deleteFact(memoryId);
    }
}