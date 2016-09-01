FROM openjdk

ADD eureka.jar /

VOLUME /logs

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka.jar"]