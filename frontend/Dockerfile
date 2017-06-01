FROM openjdk:8-jre-alpine
LABEL maintainer "Benjamin Dahlmanns"
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/local/todo-frontend/todo-frontend.jar"]

ADD target/todo-frontend.jar /usr/local/todo-frontend/todo-frontend.jar
