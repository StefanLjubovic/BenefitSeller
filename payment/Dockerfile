FROM maven:3.8.5-openjdk-17-slim AS backendBuild
WORKDIR /root/src/backend
COPY . .
RUN mvn package  -DskipTests

FROM openjdk:17 AS backendRuntime
WORKDIR /app
COPY --from=backendBuild /root/src/backend/target/payment-exe.jar ./
EXPOSE 8082
CMD java -jar payment-exe.jar