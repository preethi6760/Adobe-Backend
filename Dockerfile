# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file (make sure to build your app first!)
COPY target/integerromanconversion-0.0.1-SNAPSHOT.jar app.jar

# Expose the backend port (update to 8083)
EXPOSE 8083

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
