package com.hexa.lean.domain.model;

import java.util.Map;

public record SystemCommand(
        CommandAction action,
        Map<String, String> parameters // Ej: {"appName": "firefox"} o {"path": "/home/user/test"}
) {}