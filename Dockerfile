FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
#ARG JAR_FILE=build/libs/travel-0.0.1-SNAPSHOT.jar
COPY build/libs/travel-0.0.1-SNAPSHOT.jar /opt/
WORKDIR .
ENTRYPOINT ["java","-jar","/opt/travel-0.0.1-SNAPSHOT.jar"]