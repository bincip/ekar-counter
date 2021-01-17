# ekar-counter-service

## Functionalities covered

- a. Create a variable(counter) that can be shared by all the clients, the initial value of the counter is 50.

- b. ENDPOINT that will receive two request parameters, the first one will increase the number of producer threads. The second parameter will increase the number of consumer threads.

     The response will be HTTP 201 Created success status.

- c. Using MySQL, persist the request's information received by the app to the database.

- d. The producer threads will increase the value of the counter while the consumer threads will decrease it. 

- e. Print in the console the current value of the counter when it changes and print which producer/consumer is responsible for the change.

- f. The threads will run in parallel and continue until the counter reaches 0 or 100. Persist in the database the timestamp when the counter reaches 0 or 100.

- g. ENDPOINT that will receive one parameter, the parameter will change the current value of the counter.

	The response will be HTTP 200 Ok success status.

- h. Dockerizing the app.


## API Details

### Process Request API : Processes the request for managing consumer and producer threads

`POST api/thread/process-request`

    'Accept: application/json' 
    
    Request Body:
    {
    "producerCount" : 10,
    "consumerCount":0
    }
    

### Response

    HTTP/1.1 201 Created
    Status: 201 Created
    Connection: close
    Content-Type: application/json
   
    {
    "message": "Successfully Processed the Request",
    "status": "SUCCESS",
    "data": null
    }
  
  
### Reset Counter API : Resets the counter to the value send as path variable

`POST api/thread/set-counter/{count}`

    'Accept: application/json' 
    

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Connection: close
    Content-Type: application/json
   
    {
    "message": "Successfully updated the counter",
    "status": "SUCCESS",
    "data": null
    }
