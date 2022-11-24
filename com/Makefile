all: network

images: config_server_image service_discovery_image api_gateway_image
images_push: config_server_push service_discovery_push api_gateway_push

network:
	docker network create group-1-amdb-project

config_server_image:
	docker build -t docker.io/heritier004/ea-project:config-server ./config-server

config_server:
	docker run --rm -d -it -p 8888:8888 --name config-server --network=group-1-amdb-project docker.io/heritier004/ea-project:config-server

config_server_push:
	docker push docker.io/heritier004/ea-project:config-server

service_discovery_image:
	docker build -t docker.io/heritier004/ea-project:service-discovery ./service-discovery

service_discovery:
	docker run --rm -d -it -p 8761:8761 --name service-discovery --network=group-1-amdb-project docker.io/heritier004/ea-project:service-discovery

service_discovery_push:
	docker push docker.io/heritier004/ea-project:service-discovery

push_config_server:
	docker push docker.io/heritier004/ea-project:config-server
db_image:
	docker pull postgress

users_db:
	docker run --name users-db-server -d --rm -it -e POSTGRES_DB=users-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5422:5432 --network=group-1-amdb-project  postgres

users_image:
	docker build -t docker.io/heritier004/ea-project:users-service ./users

users_image_push:
	docker push docker.io/heritier004/ea-project:users-service

api_gateway_image:
	docker build -t docker.io/heritier004/ea-project:api-gateway ./api-gateway

api_gateway_discovery:
	docker run --rm -d -it -p 4848:4848 --name api-gateway --network=group-1-amdb-project docker.io/heritier004/ea-project:api-gateway

api_gateway_push:
	docker push docker.io/heritier004/ea-project:api-gateway

series_db:
	docker run --name series-db-server -d --rm -it -e POSTGRES_DB=series-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_USERNAME=postgres -p 5433:5432 --network=group-1-amdb-project  postgres

series_image:
	docker build --no-cache -t docker.io/heritier004/ea-project:series-service ./series

series_image_push:
	docker push docker.io/heritier004/ea-project:series-service


