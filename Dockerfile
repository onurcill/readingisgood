# jdk 11 image
FROM maven:3.6-jdk-11 as builder

COPY pom.xml /tmp/

COPY reading-is-good-app /tmp/reading-is-good-app/
COPY reading-is-good-bom /tmp/reading-is-good-bom/
COPY reading-is-good-data /tmp/reading-is-good-data/
COPY reading-is-good-parent /tmp/reading-is-good-parent/
COPY reading-is-good-rest /tmp/reading-is-good-rest/
COPY reading-is-good-service /tmp/reading-is-good-service/

WORKDIR /tmp/

# Build a release artifact.
RUN mvn clean install -Pdocker

# Use AdoptOpenJDK for base image.
FROM adoptopenjdk/openjdk11:alpine-slim

# Copy the jar to the production image from the builder stage.
COPY --from=builder /tmp/reading-is-good-app/target/reading-is-good-app*.jar /reading-is-good.jar

EXPOSE 8080

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/reading-is-good.jar"]

