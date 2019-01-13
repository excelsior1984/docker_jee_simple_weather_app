FROM postgres:10

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123456
#ENV POSTGRES_DB world-db
ENV POSTGRES_DB weather

RUN         apt-get update && \
            apt-get install -y iputils-ping net-tools emacs


ADD scripts/*.sql /docker-entrypoint-initdb.d/

#ADD scripts/*.sh /docker-entrypoint-initdb.d/

#COPY pg_hba.conf /var/lib/postgresql/data/pg_hba.conf

COPY docker-healthcheck /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck

HEALTHCHECK CMD ["docker-healthcheck"]

ADD pg_hba.conf /var/lib/postgresql/data/



