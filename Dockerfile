FROM eclipse-temurin:17-jdk-alpine


COPY gradle gradle
COPY .gradle .gradle
COPY build.gradle.kts .
COPY gradlew .
COPY gradlew.bat .
COPY settings.gradle.kts .
COPY src src

RUN ./gradlew build -x test

EXPOSE 8080
ENTRYPOINT ["java","-jar","build/libs/proyectos-0.0.1-SNAPSHOT.jar"]