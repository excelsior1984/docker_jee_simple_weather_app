TO DEPLOY APP

to run:

git1/run.sh

to deploy app: 

docker exec -it git1_glassfish2_1 bash

cp /tmp/weather-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/
