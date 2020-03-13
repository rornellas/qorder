FROM openjdk:8-jre-alpine

RUN apk add --update bash && rm -rf /var/cache/apk/*

USER root
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/order-app
ADD build/libs/qorder-0.0.1-SNAPSHOT.jar /usr/local/order-app/qorder-0.0.1-SNAPSHOT.jar

ADD ./docker/run.sh /root/
RUN chmod +x /root/run.sh
RUN ls -ltr /usr/local/order-app
RUN ls -ltr /root
CMD sh /root/run.sh