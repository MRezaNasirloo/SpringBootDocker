FROM pedramrn/java-gradle:oracle-8-gradle-2.10

VOLUME /tmp

ADD . ~/src/webapp
WORKDIR ~/src/webapp

RUN gradle bootRepackage && \
    mv app/build/libs/*.jar /app.jar && \
    rm -rf ~/src

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar","/app.jar"]