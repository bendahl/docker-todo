FROM openjdk:11-jre-slim-buster
LABEL maintainer="Benjamin Dahlmanns"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/todo-frontend/todo-frontend.jar"]

ADD target/todo-frontend.jar /usr/local/todo-frontend/todo-frontend.jar
