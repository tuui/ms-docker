#### Build Docker images
### Build on Windows using "Docker Quickstart Terminal"
* Build modules:
<pre>
gradlew clean buildDocker
</pre>
* Navigate to Dockerfile (..ms-docker/eureka/build/docker)
* Build docker images
<pre>
docker build -t ms-dc .
docker build -t ms-be .
docker build -t ms-fe .
</pre>

#### Run Docker containers
### Start manually one by one
<pre>
docker run -d -p 8761:8761 --name discovery ms-dc
docker run -d -p 8092:8092 --name be --link discovery:discovery ms-be
docker run -d -p 8091:8091 --name fe --link discovery:discovery --link be:be ms-fe
</pre>
### Start by docker-compose
<pre>
docker-compose up -d
</pre>