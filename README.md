### Создание типа контакта для работы со связкой клинент-контакты:
curl --request POST - sL  \
     --headers  "Content-type: application/json; 
                 charset=utf-8"
     --url http://localhost:8081/types/add \
     --data '{"name": "Телефон"}' \
### Создание записи клиента:
curl --request POST - sL  \
--headers  "Content-type: application/json;
charset=utf-8"
--url http://localhost:8081/client-information/add \
--data '{"name": "Иван Петров"}' \

### Получение списка клиентов:
curl --request GET - sL  \
--url http://localhost:8081/client-information/get-all \

### Получение информации по заданному клиенту:
curl --request GET - sL  \
--url http://localhost:8081/client-information/get/1 \

### Создание записи контакта:
curl --request POST - sL  \
--headers  "Content-type: application/json;
charset=utf-8"
--url http://localhost:8081/contacts/add \
--data '{"clientId": 2,
"value": "a@s",
"type": 2}' \

### Получение информации о контактах заданного клиента:
curl --request GET - sL  \
--url http://localhost:8081/contacts/get-all-contacts/1 \

### Получение информации о контактах заданного клиента по типу контакта:
curl --request GET - sL  \
--url http://localhost:8081/contacts/get-contacts-by-type/1?type=2 \
