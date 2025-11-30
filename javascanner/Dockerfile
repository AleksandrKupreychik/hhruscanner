FROM openjdk:17.0.1-slim as builder
WORKDIR /opt/app
COPY pom.xml ./
COPY .mvn .mvn
COPY src src
COPY mvnw ./
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean install

FROM openjdk:17.0.1-slim
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]