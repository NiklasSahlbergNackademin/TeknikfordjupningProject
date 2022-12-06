FROM openjdk:19

COPY target/spring-boot-backend.jar spring-boot-backend.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-backend.jar"]