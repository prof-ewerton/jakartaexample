# BUILD PHASE
FROM maven:3.8.6-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install package

# PRODUCTION PHASE
FROM tomcat:10.1.30-jre11-temurin-noble
COPY --from=builder /app/target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]