# Docker-tiedosto Spring Boot -sovellukselle (Gradle)

# Perusimage, jossa on JDK (OpenJDK 17)
FROM eclipse-temurin:17-jdk

# Aseta työskentelykansio kontissa
WORKDIR /app

# Kopioi build-tiedostot (Gradle Wrapper, build.gradle, settings.gradle)
# ja src-hakemisto, jotta voimme ajaa buildin kontissa.
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
COPY src src

# Lataa Gradle-wrapperin riippuvuudet ensin (helpottaa välimuistia)
RUN ./gradlew --version

# Aja sovelluksen käännös ja pakkaus
RUN ./gradlew bootJar --no-daemon

# Jos build onnistui, jar-tiedosto pitäisi löytyä build/libs/ -kansiosta
# Kopioi valmiiksi rakennettu jar sovelluksen ajamista varten
# (Tämän voisi yhdistää aiempaan, mutta useampi kerros helpottaa välimuistin käyttöä)
RUN mkdir /app/dist
RUN cp build/libs/*.jar /app/dist/app.jar

# Kontin ajon aikana käytettävä portti
EXPOSE 8080

# Käynnistä sovellus
CMD ["java", "-jar", "/app/dist/app.jar"]
