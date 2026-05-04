package com.hexa.lean.domain.port.out;

import com.hexa.lean.domain.model.MemoryFragment;

import java.util.List;

public interface MemoryRepositoryPort {

    /**
     * Busca en los recuerdos del usuario los más similares a la frase dada.
     *
     * @param userQuery Lo que el usuario acaba de decir.
     * @param maxResults Límite de recuerdos a traer.
     * @return Lista de fragmentos de memoria relevantes.
     */
    List<MemoryFragment> findRelevantMemories(String userQuery, int maxResults);

    /**
     * Guarda un nuevo conocimiento.
     *
     * @param fact El texto del conocimiento a guardar.
     */
    void saveFact(String fact);

    /**
     * Elimina un recuerdo por su ID.
     */
    void deleteFact(Long memoryId);
}