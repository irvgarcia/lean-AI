package com.hexa.lean.domain.port.out;

import com.hexa.lean.domain.model.PersonalityProfile;

public interface PersonalityRepositoryPort {

    /**
     * Obtiene el perfil de personalidad marcado como activo en la BD.
     *
     * @return El perfil activo.
     */
    PersonalityProfile getActiveProfile();
}