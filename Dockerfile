FROM openjdk:11

ARG JAR_FILE
copy ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
