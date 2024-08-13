# Usa una imagen base oficial de OpenJDK
FROM openjdk:22-ea-1-jdk-slim

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el archivo JAR construido en el contenedor. Asegúrate de que solo hay un archivo JAR en build/libs/
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expone el puerto que usa Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
