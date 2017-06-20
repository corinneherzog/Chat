echo ====== Sending a message ========

curl -i -X POST -H "Content-Type:application/json" -H "user:Shai" http://localhost:8000/messages -d '{"receiver":"Corinne", "text":"shai1"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Kim" http://localhost:8000/messages -d '{"receiver":"Corinne", "text":"kim1"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Simone" http://localhost:8000/messages -d '{"receiver":"Corinne", "text":"simone1"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Shai" http://localhost:8000/messages -d '{"receiver":"Corinne", "text":"shai2"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Shai" http://localhost:8000/messages -d '{"receiver":"Corinne", "text":"shai3"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Corinne" http://localhost:8000/messages -d '{"receiver":"Shai", "text":"corinne to shai 1"}'

curl -i -X POST -H "Content-Type:application/json" -H "user:Corinne" http://localhost:8000/messages -d '{"receiver":"Kim", "text":"Corinne to Kim 1}'

curl -i -X GET -H "Content-Type:application/json" -H "user:Shai" http://localhost:8000/messages
