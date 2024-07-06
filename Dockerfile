# Use the Gradle JDK 17 image for building the application
FROM gradle:8.7-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Build the application using Gradle
RUN gradle build --no-daemon --stacktrace --info

# Instalar Java y MySQL client en Ubuntu
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk mysql-client && \
    rm -rf /var/lib/apt/lists/*

# Use the OpenJDK 17 image for running the application
FROM openjdk:17-jdk

# Copy the built JAR file from the build stage to the runtime stage
COPY --from=build /app/build/libs/*.jar /app.jar
COPY src/main/resources/org.example/resources/application.yaml /app/org.example/resources/application.yaml

# Define the command to run the application
CMD ["java", "-jar", "/app.jar"]