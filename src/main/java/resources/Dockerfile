# Usamos una imagen base de Amazon Corretto 21
FROM amazoncorretto:21

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo .jar generado por Maven al contenedor
COPY target/TallerDeArqDeSistemas.jar /app/TallerDeArqDeSistemas.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "TallerDeArqDeSistemas.jar"]
