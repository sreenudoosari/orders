![Kafka_training_micro_service drawio](https://github.com/user-attachments/assets/296cf1a3-45d5-47ac-927c-f6c28622abbc)

**Orders Microservice for Kafka Training course**

Create Order1:

`
curl -X POST http://localhost:8090/api/orders -H "Content-Type: application/json" -d '{
"orderId": "O00001",
"customerId": "C00001",
"total": 123.45,
"items": [{
"productId": "P00001",
"quantity": 3
},{
"productId": "P00002",
"quantity": 1
}]
}' `

Create Order2:

`
curl -X POST http://localhost:8090/api/orders -H "Content-Type: application/json" -d '{
"orderId": "O00002",
"customerId": "C00002",
"total": 97.12,
"items": [{
"productId": "P00001",
"quantity": 2
},{
"productId": "P00002",
"quantity": 1
}]
}' `


