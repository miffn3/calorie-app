# Calorie Counter REST API

REST API личного приложения для подсчета калорий и записи приемов пищи.

Предоставляет следующие API endpoints, [описание REST контракта](src/main/resources/openapi/calorie-counter-docs.yaml). Можно воспользоваться
[сайтом](https://editor.swagger.io) или развернуть приложение и пройти по [адресу локального swagger'а](http://localhost:8080/swagger-ui/index.html) для наглядной демонстрации контракта. 

Для работы необходимо указать в local/env свой адрес:

* URL БД PostgreSQL

Задание:
* Реализовать методы `UserController.updateUser` и `UserService.updateUser` для обновления пользователя.
* Дописать необходимые тесты для сервисов, контроллеров.

Для локального запуска всех контейнеров:
```bash
docker compose --env-file local/env.env -p calorie-counter up -d
```

Для остановки всех контейнеров:
```bash
docker compose --env-file local/env.env stop
```