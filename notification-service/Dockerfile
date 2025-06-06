FROM openjdk:17-jdk-slim
COPY target/notification-service-0.0.1-SNAPSHOT.jar app.jar
CMD sleep 15 && java -jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
