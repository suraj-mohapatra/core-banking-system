#FROM eclipse-temurin:17-jdk-alpine
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/api.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]