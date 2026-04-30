package com.hexa.lean.domain.ports;

import com.hexa.lean.domain.model.SystemStatus;

public interface SystemQueryPort {
    SystemStatus getRamUsage();
    SystemStatus getCpuTemperature();
}