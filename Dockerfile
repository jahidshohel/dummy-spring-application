FROM maven:3 as build
LABEL authors="jahid"

WORKDIR /learning
COPY pom.xml .
COPY src ./src/
RUN mvn clean install -DskipTests
RUN ls -al

FROM openjdk:17
WORKDIR /learning
COPY --from=build /learning/target/*.jar app.jar
RUN ls
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]