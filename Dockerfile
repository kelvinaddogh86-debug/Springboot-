
# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built jar from your project into the container
COPY target/*.jar app.jar

# Expose the port your app runs on (Spring Boot default is 8080)
EXPOSE 8080

# Command to run your jar
ENTRYPOINT ["java","-jar","app.jar"]

