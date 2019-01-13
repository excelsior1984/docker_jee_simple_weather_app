TO DEPLOY APP

docker exec -it git1_glassfish2_1 bash

cp /tmp/weather-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/
