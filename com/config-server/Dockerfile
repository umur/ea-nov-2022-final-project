FROM openjdk:19

COPY target/config-server-0.0.1-SNAPSHOT.jar config-server-app.jar

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

ENTRYPOINT ["java", "-jar","config-server-app.jar"]