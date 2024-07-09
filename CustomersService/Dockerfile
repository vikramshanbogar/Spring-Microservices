#
# Build stage
#
# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17-slim AS build
ENV HOME=/home/app
RUN ls
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN ls
RUN mvn clean package

#
# Package stage
#
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build $JAR_FILE /app/runner.jar
EXPOSE 8080
ENTRYPOINT java -jar /app/runner.jar