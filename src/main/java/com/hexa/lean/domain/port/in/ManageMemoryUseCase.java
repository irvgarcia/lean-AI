package com.hexa.lean.domain.port.in;

public interface ManageMemoryUseCase {

    /**
     * Inyecta un nuevo conocimiento explícito en la base de datos vectorial de Lean.
     *
     * @param fact El hecho a recordar, ej: "El servidor de desarrollo está en el puerto 8080"
     */
    void rememberFact(String fact);

    /**
     * Borra un recuerdo si la información ha cambiado o ya no es útil.
     *
     * @param memoryId El identificador del recuerdo a olvidar.
     */
    void forgetFact(Long memoryId);
}