FROM openjdk:17-alpine
ADD target/spring-boot-employee.jar spring-boot-employee.jar
ENTRYPOINT ["java","-jar","/spring-boot-employee.jar"]
EXPOSE 8085


