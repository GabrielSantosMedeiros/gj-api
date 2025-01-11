FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gj_api.jar
ENTRYPOINT [ "java", "-jar", "/gj_api.jar" ]    