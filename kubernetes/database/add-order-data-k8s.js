db = connect("173.193.75.86:30017");
use Order
db.auth('orderdbuser', 'orderdbuserpwd')
db.Order.insertOne({"orderNumber": "ORDER123", "customerNumber": "CUST456", "orderPrice": "31.85", "orderMenuItems": [ {"menuItemNumber": "MENU-112", "quantityOfMenuItem": "2", "menuName": "Salmon", "price": "12.95" }, {"menuItemNumber": "MENU554", "quantityOfMenuItem": "1", "menuName": "Salad", "price": "5.95" }] })

