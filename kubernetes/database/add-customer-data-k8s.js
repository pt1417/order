db = connect("173.193.75.86:30017");
use Customer
db.auth('customerdbuser', 'customerdbuserpwd')
db.Customer.insertOne({"customerNumber": "CUST1234","firstName": "John", "lastName": "Smith","email": "jsmith@abc.com"})

