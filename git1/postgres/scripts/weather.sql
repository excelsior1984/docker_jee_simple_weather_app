
BEGIN;

SET client_encoding = 'LATIN1';

CREATE TABLE pogoda(id  serial primary key not null, lat double precision, lon double precision, temp double precision, humidity double precision, pressure double precision, tempmin double precision, tempmax double precision, speed double precision, deg double precision, name varchar(30));


COMMIT;

