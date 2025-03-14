# Use Node.js for backend
FROM node:20-alpine

WORKDIR /app

# Copy files and install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the backend code
COPY . .

EXPOSE 5000

# Start the backend server
CMD ["npm", "start"]
# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file (make sure to build your app first!)
COPY target/integerromanconversion-0.0.1-SNAPSHOT.jar app.jar
RUN ls -l /app
# Expose the backend port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
