FROM pedramrn/java-gradle:oracle-8-gradle-2.10

VOLUME /tmp

#ADD spring-boot-docker-template-0.0.1-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'

ADD . ~/src/webapp
WORKDIR ~/src/webapp

RUN mv app/build/libs/*.jar /app.jar && \
    rm -rf ~/src

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar","/app.jar"]