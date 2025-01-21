# Use a base image with JDK and necessary dependencies
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files to the image
COPY . .

# Install necessary dependencies (e.g., Maven, Gradle)
RUN apt-get update && apt-get install -y maven

# Expose port for application
EXPOSE 8080

# Define command to run the application
CMD ["mvn", "test"]
