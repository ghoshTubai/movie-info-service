FROM openjdk:8
COPY ./target/movie-info-service.jar movie-info-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","info-service.jar"]