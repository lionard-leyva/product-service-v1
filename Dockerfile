# Etapa de construcción
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Instalar Gradle
RUN apt-get update && apt-get install -y curl unzip \
    && curl -L https://services.gradle.org/distributions/gradle-8.5-bin.zip -o gradle.zip \
    && unzip gradle.zip \
    && mv gradle-8.5 /opt/gradle \
    && rm gradle.zip
ENV PATH=$PATH:/opt/gradle/bin

# Copia los archivos necesarios
COPY build.gradle settings.gradle ./
COPY src ./src

# Ejecuta la compilación de Gradle
# En la etapa de construcción
RUN gradle build -x test --no-daemon

# Etapa final
FROM eclipse-temurin:22-jre-jammy

WORKDIR /app

# Copia el archivo JAR generado en la etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Expone el puerto que usa Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]