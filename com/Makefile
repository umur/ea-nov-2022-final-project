all: network

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