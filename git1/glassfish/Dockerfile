#https://github.com/aws/aws-eb-glassfish-dockerfiles/blob/aafcfc5e812dfb9b998105d3ca9da1b7f10664e1/4.1-jdk8/Dockerfile
FROM        java:8-jdk

ENV         JAVA_HOME         /usr/lib/jvm/java-8-openjdk-amd64
ENV         GLASSFISH_HOME    /usr/local/glassfish4
ENV         PATH              $PATH:$JAVA_HOME/bin:$GLASSFISH_HOME/bin

RUN         apt-get update && \
            apt-get install -y netcat iputils-ping net-tools curl unzip zip inotify-tools && \
            rm -rf /var/lib/apt/lists/*

RUN         curl -L -o /tmp/glassfish-4.1.zip http://download.java.net/glassfish/4.1/release/glassfish-4.1.zip && \
            unzip /tmp/glassfish-4.1.zip -d /usr/local && \
            rm -f /tmp/glassfish-4.1.zip

EXPOSE      8080 4848 8181

WORKDIR     /usr/local/glassfish4

# verbose causes the process to remain in the foreground so that docker can track it
CMD asadmin start-domain --verbose

COPY target/weather-1.0-SNAPSHOT.war /tmp/


#COPY wait-for-postgres.sh /tmp/
#ENTRYPOINT "/tmp/wait-for-postgres.sh" && /bin/bash