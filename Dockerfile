FROM openjdk:8u191-jre-alpine3.9

#Adding curl and jq for healthcheck script
RUN apk add curl jq

#Workspace
WORKDIR /usr/share/udemy

# Add jar files from host target location into the image
ADD target/cucumber-selenium-docker.jar         cucumber-selenium-docker.jar
ADD target/cucumber-selenium-docker-tests.jar   cucumber-selenium-docker-tests.jar
ADD target/libs                                 libs

# Add suite files
ADD testng.xml                                  testng.xml
ADD healthcheck.sh                              healthcheck.sh

# ENV VARIABLES
# BROWSER
# HUB_HOST

ENTRYPOINT sh healthcheck.sh