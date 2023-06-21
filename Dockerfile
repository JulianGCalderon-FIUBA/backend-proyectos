FROM eclipse-temurin:17-jdk-alpine as build
COPY gradle gradle
COPY gradlew .
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src
RUN ./gradlew build -x test

FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080:8080
COPY --from=build build/libs/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]