FROM openjdk

ADD frontend.jar /

VOLUME /logs

EXPOSE 8091

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "frontend.jar"]