# Lean - Asistente de Sistema Local con Arquitectura Hexagonal

Lean es un asistente inteligente diseñado para ejecutarse de forma local, permitiendo la interacción con el sistema operativo mediante lenguaje natural. Utiliza **Inteligencia Artificial Local** para procesar intenciones, gestionar memoria a largo plazo y ejecutar comandos del sistema, todo bajo una estructura robusta de **Arquitectura Hexagonal**.

## 🚀 Características Principales

- **Procesamiento de Intenciones con LLM Local**: Utiliza [Ollama](https://ollama.com/) para ejecutar modelos de lenguaje (como Qwen2.5) localmente, garantizando privacidad y baja latencia.
- **Memoria de Largo Plazo (RAG)**: Implementa *Retrieval-Augmented Generation* utilizando **PGVector** en PostgreSQL para almacenar y recuperar recuerdos relevantes según el contexto de la conversación.
- **Interacción con el Sistema**: Capacidad para ejecutar comandos en el sistema operativo (soporta Windows y Linux), como abrir aplicaciones, crear directorios o consultar métricas de recursos (RAM).
- **Arquitectura Hexagonal**: Separación clara entre el dominio, la lógica de aplicación y los adaptadores de infraestructura (IA, Persistencia, API REST).
- **Personalidad Configurable**: Sistema de perfiles que define el tono y comportamiento del asistente.

## 🛠️ Stack Tecnológico

- **Lenguaje**: Java 21
- **Framework**: Spring Boot 3.2.5
- **IA**: Spring AI (Ollama, PGVector)
- **Base de Datos**: PostgreSQL 16 con extensión `pgvector`
- **Herramientas**: Lombok, Docker, Maven

## 📂 Estructura del Proyecto

El proyecto sigue los principios de Clean Architecture y Arquitectura Hexagonal:

```text
src/main/java/com/hexa/lean/
├── application/           # Servicios de aplicación (Casos de Uso)
│   └── service/           # Implementaciones de la lógica de aplicación
├── domain/                # Modelos de dominio y Puertos
│   ├── model/             # Entidades y objetos de valor
│   └── port/              # Interfaces de entrada (In) y salida (Out)
└── infrastructure/        # Adaptadores (Implementaciones técnicas)
    └── adapter/
        ├── ai/            # Integración con Ollama
        ├── in/rest/       # Controladores API REST
        ├── out/persistence/ # Adaptadores de base de datos
        └── out/system/    # Adaptadores de sistema operativo (Windows/Linux)
```

## ⚙️ Configuración y Requisitos

### 1. Requisitos Previos
- **Java 21** instalado.
- **Docker** y **Docker Compose**.
- **Ollama** instalado y ejecutándose localmente.

### 2. Preparar el Entorno de IA
Descarga los modelos necesarios en Ollama:
```bash
ollama pull qwen2.5:7b
ollama pull nomic-embed-text
```

### 3. Levantar la Infraestructura
Inicia la base de datos con soporte vectorial:
```bash
docker-compose up -d
```

### 4. Ejecución
Ejecuta la aplicación mediante Maven:
```bash
./mvnw spring-boot:run
```

## 📡 API Endpoints

### Procesar Intención
- **URL**: `/api/v1/lean/process`
- **Método**: `POST`
- **Cuerpo (JSON)**:
  ```json
  {
    "message": "Hola Lean, ¿puedes crear una carpeta llamada 'Proyectos'?"
  }
  ```
- **Respuesta**:
  ```json
  {
    "success": true,
    "responseMessage": "He creado la carpeta 'Proyectos' por usted, señor.",
    "rawOutput": "Directory created successfully"
  }
  ```

## 🧠 Flujo de Trabajo

1. **Recepción**: La API recibe un mensaje de texto.
2. **Contextualización**: Se recuperan recuerdos relevantes de PGVector y el perfil de personalidad activo.
3. **Análisis (LLM)**: El modelo analiza el contexto y decide si debe ejecutar una acción del sistema o simplemente responder.
4. **Ejecución**: Si se detecta un comando (ej. `CREATE_DIRECTORY`), el adaptador correspondiente lo ejecuta.
5. **Respuesta Natural**: El LLM genera una respuesta coherente basada en el resultado de la ejecución.

## 📄 Licencia

Este proyecto es de código abierto. Siéntete libre de contribuir o adaptarlo a tus necesidades.
