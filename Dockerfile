FROM openjdk:17
ADD build/libs/*.jar assignment.jar
ENTRYPOINT ["java", "-jar", "/assignment.jar"]