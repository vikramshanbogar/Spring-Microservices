FROM eclipse-temurin:17-jdk-focal
LABEL authors="Vikram"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} products-service.jar
ENTRYPOINT ["java","-jar","/products-service.jar"]
