FROM openjdk:17
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
COPY target/rating_service-0.0.1-SNAPSHOT.jar /home/app/rating-service.jar
ENTRYPOINT ["java","-jar","/home/app/rating-service.jar"]