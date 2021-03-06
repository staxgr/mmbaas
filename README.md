mmbaas
======

Provides a minimal backend as a service for mobile. Use it for rapid apps prototyping.

The aim is to provide you with a flexible backend with a NoSQL database running in less then 5 minutes.

Installation
=====

Download, install and run mongodb.
http://www.mongodb.org/downloads

Download, unzip and run:
```
bin/mongod
```

Check out this repository and execute it:

```
git clone <this repo>
./gradlew jettyRun
```

You should see
```
Building 75% > :backend:jettyRun > Running at http://localhost:8080/backend
```

Now the backend is up and running on your local machine on port 8080.

Test it by adding some new data. Execute the following in a web browser on your machine (tested in Chrome)
```
http://localhost:8080/backend/rest/data/insert/fruit?jsonData={fruitType:'banana',color:'yellow'}
http://localhost:8080/backend/rest/data/insert/fruit?jsonData={fruitType:'apple',color:'green'}
```
You should see some object id returned. We can ignore that for now.

Now query for yellow fruits:

```
http://localhost:8080/backend/rest/data/query/fruit?query={color:'yellow'}
```

You should get your banana back. 
Of course fruits is just a stupid example. You can add anything you like!





