db = connect("173.193.75.86:30017");
use admin
db.auth('admin', 'pa55w0rd')
db = db.getSiblingDB('Customer')

db.createUser({
    user: 'customerdbuser', 
    pwd: 'customerdbuserpwd', 
    roles: [
        { role: 'dbOwner', 
        db: 'Customer' }
    ] 
})
