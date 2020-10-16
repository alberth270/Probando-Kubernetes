FROM openjdk:8-jdk-alpine
COPY "./target/bancos-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]