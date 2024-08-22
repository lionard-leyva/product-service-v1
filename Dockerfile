# Etapa de construcción
FROM gradle:9.

WORKDIR /app

# Copia los archivos necesarios
COPY build.gradle settings.gradle ./
COPY src ./src

# Ejecuta la compilación de Gradle
RUN gradle build --no-daemon

# Etapa final
FROM openjdk:22-slim

WORKDIR /app

# Copia el archivo JAR generado en la etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Expone el puerto que usa Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]