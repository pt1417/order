db = connect("173.193.75.86:30017");
use Menu
db.auth('menudbuser', 'menudbuserpwd')
db.Menu.insertOne({"menuItemNumber": "MENU-112","category":"entry","description":"grilled salmon","numAvailable": "2", "Name": "Salmon", "price": "12.95" });
db.Menu.insertOne({"menuItemNumber": "MENU-554","category":"salad","description":"garden salad", "numAvailable": "10", "name": "Salad", "price": "5.95" });
db.Menu.insertOne({"menuItemNumber":"","category":"salad","description":"chef salad", "numAvailable": "10", "name": "Salad", "price": "5.95" });
