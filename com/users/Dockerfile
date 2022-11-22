FROM openjdk:19

COPY target/users-0.0.1-SNAPSHOT.jar users-app.jar

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

ENTRYPOINT ["java", "-jar","users-app.jar"]