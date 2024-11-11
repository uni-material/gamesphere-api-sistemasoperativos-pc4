# Usar la imagen oficial de OpenJDK 21 como base
FROM openjdk:21-jdk-slim


# Copiar el proyecto y construirlo
COPY . /app
WORKDIR /app
RUN ./mvnw package -DskipTests

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar el archivo JAR
CMD ["java", "-jar", "target/spring-mongo-api-0.0.1-SNAPSHOT.jar"]
