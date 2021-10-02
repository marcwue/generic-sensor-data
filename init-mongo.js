// switch to admin db
db = new Mongo().getDB("admin");
// create user in admin db
db.createUser({
    user: 'clojure-rw',
    pwd: 'asdf1234',
    roles: [{
	role: 'readWrite',
	db: 'sensor-data',
    }],
});

// switch to sensor-data db
db = new Mongo().getDB("sensor-data");
// create collection
db.createCollection('temperature', { capped: false });
