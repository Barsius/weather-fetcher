FROM maven:3.8.1-openjdk-8 AS build
COPY . project
WORKDIR project
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=build project/target/*jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]