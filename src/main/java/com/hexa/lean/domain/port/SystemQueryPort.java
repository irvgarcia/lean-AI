package com.hexa.lean.domain.port;

import com.hexa.lean.domain.model.SystemStatus;

public interface SystemQueryPort {
    SystemStatus getRamUsage();
    SystemStatus getCpuTemperature();
}
