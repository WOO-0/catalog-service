FROM eclipse-temurin:17 AS builder
WORKDIR /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]

# FROM eclipse-temurin:17 AS builder
# WORKDIR /app
# ARG JAR_FILE=build/libs/*.jar
# COPY ${JAR_FILE} catalog-service.jar
# RUN java -Djarmode=layertools -jar catalog-service.jar extract

# FROM eclipse-temurin:17
# RUN useradd spring
# USER spring
# WORKDIR /app
# COPY --from=builder /app/dependencies/ ./
# COPY --from=builder /app/spring-boot-loader/ ./
# COPY --from=builder /app/snapshot-dependencies/ ./
# COPY --from=builder /app/application/ ./

# ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]

