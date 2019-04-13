# Microservice
Spring Boot, Swagger, Docker

## Swagger
```
http://localhost:8081/swagger-ui.htm
```

## Rest

### /transaction
```
curl -X POST \
  http://localhost:8081/transaction \
  -H 'Accept: */*' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: a00ad9c9-851b-41b4-98a0-2faa4695db8f' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: 49' \
  -H 'cookie: JSESSIONID=6F0C32EE41BEE0CE30D1023AFAF3C056' \
  -b JSESSIONID=6F0C32EE41BEE0CE30D1023AFAF3C056 \
  -d '{
	"timestamp":"1555160767",
	"amount":"24.73"
}
'
```

### /statistics
```
curl -X GET \
  http://localhost:8081/statistics \
  -H 'Postman-Token: 438994e1-863b-4676-b63a-8f0777c668d2' \
  -H 'cache-control: no-cache'
```

## Docker

### Dockerfile
```
FROM openjdk:8
ADD target/trabalho-microservice.jar trabalho-microservice.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "trabalho-microservice.jar"]
```

### Run
```
$ docker run -p 8081:8081 trabalho-microservice
```
