
# Määrittele muuttuja Docker Compose -tiedostolle
COMPOSE_FILE = docker-compose.yml

# PHONY tarkoittaa, ettei ole oikeita tiedostoja vastaavia kohteita
.PHONY: build up down logs

# Rakentaa Docker-imaget
build:
	docker-compose -f $(COMPOSE_FILE) build

build-run:
	docker-compose -f $(COMPOSE_FILE) build docker-compose up

# Käynnistää kontit taustalla
up:
	docker-compose -f $(COMPOSE_FILE) up -d

# Näyttää lokit reaaliajassa
logs:
	docker-compose -f $(COMPOSE_FILE) logs -f

# Sammuttaa ja poistaa kontit
down:
	docker-compose -f $(COMPOSE_FILE) down
##
run: build up

##
destroy:
	docker-compose -f $(COMPOSE_FILE) down --rmi all --volumes --remove-orphans