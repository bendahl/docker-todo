FROM maven:3-jdk-11 as builder
WORKDIR /build
COPY pom.xml /build
COPY src/ /build/src
RUN mvn clean install

FROM openjdk:11-jre-slim-buster
LABEL maintainer="Benjamin Dahlmanns"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/todo-frontend/todo-frontend.jar"]

COPY --from=builder /build/target/todo-frontend.jar /usr/local/todo-frontend/
