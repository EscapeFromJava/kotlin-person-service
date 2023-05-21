build:
	docker build -t person-service .

run:
	docker run -p 8081:8080 --name person-service --rm person-service