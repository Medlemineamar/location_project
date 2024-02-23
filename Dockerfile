#FROM adoptopenjdk/openjdk17:alpine
#COPY target/location_project.jar /app/location_project.jar
#WORKDIR /app
#CMD ["java", "-jar", "location_project.jar"]
# Utilisation de l'image adoptopenjdk/openjdk17:alpine comme base
#FROM adoptopenjdk/openjdk17:alpine

# Copie du fichier JAR de l'application Spring Boot dans le conteneur
#COPY target/location_project.jar /app/location_project.jar

# Commande à exécuter lorsque le conteneur démarre
#CMD ["java", "-jar", "/app/location_project.jar"]



FROM openjdk:17
EXPOSE 8081
ADD target/location_project.jar location_project.jar
ENTRYPOINT ["java", "-jar", "/location_project.jar"]