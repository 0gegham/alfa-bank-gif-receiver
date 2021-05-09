FROM adoptopenjdk/openjdk11 as builder
COPY . /app
WORKDIR /app
ARG JAR_FILE=/app/build/libs/alfa-bank-gif-receiver-*.jar
RUN java -Djarmode=layertools -jar ${JAR_FILE} extract

FROM openjdk:11
WORKDIR /app
COPY --from=builder /app/dependencies/ ./
COPY --from=builder /app/snapshot-dependencies/ ./
COPY --from=builder /app/spring-boot-loader/ ./
COPY --from=builder /app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]