FROM openjdk:8
COPY ./target/movie-info-service.jar movie-info-service.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","movie-info-service.jar"]