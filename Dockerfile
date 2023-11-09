FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn install -Dmaven.test.skip=true

FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build /app/target/server-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]