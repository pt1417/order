db = connect("localhost:27017");
use Order
db.Order.insertOne({"orderNumber": "ORDER123", "customerNumber": "CUST456", "orderPrice": "31.85", "orderMenuItems": [ {"menuItemNumber": "MENU-112", "quantityOfMenuItem": "2", "menuName": "Salmon", "price": "12.95" }, {"menuItemNumber": "MENU554", "quantityOfMenuItem": "1", "menuName": "Salad", "price": "5.95" }] })
