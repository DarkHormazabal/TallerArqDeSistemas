# Usa una imagen base de Amazon Corretto 16
FROM amazoncorretto:16
# Copiamos el archivo .jar generado al contenedor
COPY build/libs/TallerDeArqDeSistemas-1.0-SNAPSHOT.jar /app/TallerDeArqDeSistemas-1.0-SNAPSHOT.jar

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "matias914/tallerdearqdesistemas:latest .", "org.example.main"]
