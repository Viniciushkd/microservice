FROM openjdk:8
ADD target/trabalho-microservice.jar trabalho-microservice.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "trabalho-microservice.jar"]