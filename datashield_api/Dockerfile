# Utilisation de l'image Amazon Corretto JDK 17 comme base
FROM amazoncorretto:17


# Spécifier le chemin du fichier JAR via un argument
ARG JAR_FILE=./jarfile/*.jar

# Copier le fichier JAR depuis le contexte de build dans l'image Docker
COPY ${JAR_FILE} /app/api.jar

# Définir le répertoire de travail
WORKDIR /app

# Commande par défaut pour exécuter l'application Java
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "api.jar"]

# Commande Maven pour lancer l'application Spring Boot (utilisée typiquement pour le développement)
CMD ["mvn", "spring-boot:run"]
