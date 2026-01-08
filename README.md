Inventory Service — Microservice 1

The Inventory Service manages product stock across multiple batches with expiry dates.
It exposes REST APIs to retrieve available inventory and update stock after orders.
************************************************************
🔗 API Endpoints
GET Endpoints - > http://localhost:8081/inventory/1005
{
	"productId": 1005,
	"productName": "Smartwatch",
	"batches": [
		{
			"batchId": 5,
			"quantity": 39,
			"expiryDate": "2026-03-31"
		},
		{
			"batchId": 7,
			"quantity": 40,
			"expiryDate": "2026-04-24"
		},
		{
			"batchId": 2,
			"quantity": 52,
			"expiryDate": "2026-05-30"
		}
	]
}

*******************************************************************************

POST Endpoints
http://localhost:8081/inventory/update?productId=1005&quantity=60
output - Inventory updated

******************************************************************** Post Upadte *********
http://localhost:8081/inventory/1005

{
	"productId": 1005,
	"productName": "Smartwatch",
	"batches": [
		{
			"batchId": 5,
			"quantity": 0,
			"expiryDate": "2026-03-31"
		},
		{
			"batchId": 7,
			"quantity": 19,
			"expiryDate": "2026-04-24"
		},
		{
			"batchId": 2,
			"quantity": 52,
			"expiryDate": "2026-05-30"
		}
	]
}
