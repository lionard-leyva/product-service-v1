FROM gradle:8.10-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test --no-daemon --stacktrace

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]