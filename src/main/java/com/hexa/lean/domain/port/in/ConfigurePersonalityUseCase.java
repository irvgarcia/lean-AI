package com.hexa.lean.domain.port.in;

import com.hexa.lean.domain.model.PersonalityProfile;

public interface ConfigurePersonalityUseCase {

    /**
     * Cambia el perfil activo de Lean.
     *
     * @param profileName El nombre del perfil, ej: "Técnico", "Relajado".
     * @return El perfil activado.
     */
    PersonalityProfile changeActiveProfile(String profileName);
}