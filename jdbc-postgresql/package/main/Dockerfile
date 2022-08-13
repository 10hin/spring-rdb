ARG JAVA_VERSION=17

FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

COPY ./.mvn ./.mvn
COPY ./mvnw ./mvnw
COPY ./pom.xml ./pom.xml

RUN ./mvnw dependency:go-offline

COPY ./src ./src

RUN ./mvnw package \
    && cp ./target/demo.jar /demo.jar

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine AS runner

COPY --chown=1001:1001 --from=builder /demo.jar /app/demo.jar

USER 1001:1001
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
