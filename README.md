## Серверная часть приложения для благотворительного хакатона

### Как запустить локально?

**Вам понадобится:**

- Docker (можно установить [отсюда](https://www.docker.com/products/docker-desktop/))
- Git (можно установить [отсюда](https://git-scm.com/downloads))

**1. Склонируйте репозиторий и перейдите в корневую папку проекта.**

```
$ git clone https://github.com/Kidchai/jun-hackathon-server
$ cd jun-hackathon-server
```

**2. Запустите сервер с помощью Docker.**

```
$ docker-compose up
```

### Документация для API

Будет доступна после запуска по адресу (profile-controller)

```
http://server:8080/swagger-ui/index.html
```
server: имя сервера или IP

Для локального запуска, например:
http://localhost:8080/swagger-ui/index.html

Не используйте эндпойнты для `profile-controller` и `user-entity-controller`.
