.ONESHELL:

all: docker-compare

docker-full: download
	docker build --tag java9-full -f java9-full.Dockerfile .

docker-mini: minimize
	docker build --tag java9-mini -f java9-mini.Dockerfile .

docker-compare: docker-full docker-mini
	docker image ls | grep -E "java9-.*|ubuntu"

download: jdk.tar.gz

minimize: jdk-mini 

jdk-mini: docker-full
	docker run --rm --volume ${PWD}:/out java9-full /bin/bash -c "jlink \
		--module-path /jdk-9/jmods \
		--verbose \
		--add-modules java.base \
		--compress 2 \
		--no-header-files \
		--output /out/jdk-mini && \
		chown -R 1000 /out/jdk-mini/"

jdk.tar.gz:
	wget -O ./jdk.tar.gz -c \
		--header "Cookie: oraclelicense=accept-securebackup-cookie" \
		http://download.oracle.com/otn-pub/java/jdk/9+181/jdk-9_linux-x64_bin.tar.gz

clean:
	rm -rf ./jdk-mini/

.PHONY: all docker-full docker-mini docker-compare minimize clean
