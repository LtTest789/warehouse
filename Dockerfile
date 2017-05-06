FROM maven:3.3.9-jdk-8

WORKDIR /code
COPY *.xml /code/
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

COPY src /code/src
RUN ["mvn", "clean", "package"]

EXPOSE 9001
CMD ["java", "-jar", "target/warehouse-1.0.jar"]