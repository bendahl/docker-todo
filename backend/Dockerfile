FROM openjdk:11-jre-slim-buster
LABEL maintainer="Benjamin Dahlmanns"
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/usr/local/todo-backend/todo-backend.jar"]

ADD target/todo-backend.jar /usr/local/todo-backend/todo-backend.jar
