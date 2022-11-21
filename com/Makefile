all: network

network:
	docker network create group-1-amdb-project

config_server_image:
	docker build -t docker.io/heritier004/ea-project:config-server ./config-server

config-server:
	docker run --rm -d -it -p 8888:8888 --name config-server --network=group-1-amdb-project docker.io/heritier004/ea-project:config-server

config_server_push:
	docker push docker.io/heritier004/ea-project:config-server