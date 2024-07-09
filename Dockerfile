# Use the Gradle JDK 17 image for building the application
FROM gradle:8.7-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Usa una imagen base de Amazon Corretto 16
FROM amazoncorretto:17
# Copiamos el archivo .jar generado al contenedor
COPY build/libs/TallerDeArqDeSistemas-1.0-SNAPSHOT.jar /app/TallerDeArqDeSistemas-1.0-SNAPSHOT.jar

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "matias914/tallerdearqdesistemas:latest .", "org.example.main"]