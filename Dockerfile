FROM openjdk:11
WORKDIR /usr/app/api
ADD ./target/ekar-thread-counter-0.0.1.jar ekar-thread-counter-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ekar-thread-counter-0.0.1.jar"]