# Coronavirus-tracker

## Build application
```
mvn clean package -DskipTests
```

## Navigate to browser
```
localhost:2020
```

## Build docker image
```
docker build -t corornavirus-tracker .
```

## Run docker image
```
docker run -d -it -p 2020:2020 coronavirus-tracker
```
