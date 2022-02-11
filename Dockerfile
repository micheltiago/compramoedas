FROM openjdk:11
MAINTAINER java
ADD ./build/libs/compramoedas-0.0.1-SNAPSHOT.jar /usr/src/open.jar
WORKDIR /usr/src/
EXPOSE 8080
CMD ["java", "-jar", "open.jar"]