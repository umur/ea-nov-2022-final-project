docker run --name users-db-server -d --rm -it -e POSTGRES_DB=users-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5422:5432 --network=group-1-amdb-project  postgres
docker run --name series-db-server -d --rm -it -e POSTGRES_DB=series-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5433:5432 --network=group-1-amdb-project  postgres
docker run --name comments-db-server -d --rm -it -e POSTGRES_DB=comments-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5444:5432 --network=group-1-amdb-project  postgres
docker run --name movies-db-server -d --rm -it -e POSTGRES_DB=movies-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5455:5432 --network=group-1-amdb-project  postgres
