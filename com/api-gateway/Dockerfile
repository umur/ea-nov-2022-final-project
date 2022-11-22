FROM openjdk:19

COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-app.jar

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

ENTRYPOINT ["java", "-jar","api-gateway-app.jar"]