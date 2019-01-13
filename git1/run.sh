cd postgres
./build.sh
cd ..

#cp test6/target/test6-1.0-SNAPSHOT.war glassfish/target/
cp weather/target/weather-1.0-SNAPSHOT.war glassfish/target/
cd glassfish
./build.sh
cd ..

docker-compose up
