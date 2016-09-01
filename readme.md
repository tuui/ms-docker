## MS-DOCKER

### Build Docker image on Windows using "Docker Quickstart Terminal" - eureka service example
* Build eureka module: "gradlew clean buildDocker"
* Navigate to Dockerfile (..ms-docker/eureka/build/docker)
* Build docker images: "docker build -t ms-dc ."

### Run Docker containers
docker run -d -p 8761:8761 --name discovery ms-dc
docker run -d -p 8092:8092 --name be --link discovery:discovery ms-be
docker run -d -p 8091:8091 --name fe --link discovery:discovery --link be:be ms-fe