FROM amazoncorretto:17
MAINTAINER emilianaarduzzo
COPY target/EmAr-0.0.1-SNAPSHOT.jar EmAr-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EmAr-0.0.1-SNAPSHOT.jar"]