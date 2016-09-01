FROM openjdk

ADD backend.jar /

VOLUME /logs

EXPOSE 8092

ENTRYPOINT ["java", "-Dspring.profiles.active=dev_docker", "-jar", "backend.jar"]