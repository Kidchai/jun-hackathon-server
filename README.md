## Серверная часть приложения для благотворительного хакатона

Это back-end команды #7. Полная информация о проекте доступна в [README организации](https://github.com/Junior-Hackathon-Charity-2023/.github/blob/main/profile/README.md)

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

Будет доступна после запуска по адресу

```
http://server:8080/swagger-ui/index.html
```
server: имя сервера или IP

Для локального запуска, например:
http://localhost:8080/swagger-ui/index.html
