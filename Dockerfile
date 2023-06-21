FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
COPY app.jar .
ENTRYPOINT ["java","-jar","app.jar"]