# mwi-gilded-rose-expansion

Explanation :

Set Up:
Following are the steps taken while seeting up for an application:
Download and install Spring Tool Suite.
Create a New--Maven Project and named  
Group Id:  gilded.rose 
Artifact Id: GildedRose
Packaging :Jar 
Added dependencies to pom.xml 
Right Click-GildedRose-Maven-Update Project
Now all jars have imported to Maven Dependencies as part of project structure.


Surging Price Logic:
A variable named counter has been used as static and int data type. Initially it is initialized with 0.
When the first request will come, it will be incremented to 1.
Then for any further request, this counter variable value will be incremented by 1. 
Another static variable named dtime has been used of LocalDateTime data type.
Whenever first request comes, this this dtime variable is initialized with time when this first request came.
Then we check the condition whenever counter value increased to more than 10. Here we fetch time of latest request and calculate its time difference when first request came. If we have counter value more than 10 and time difference is less than 1 and equal to 1 hour here, we initiate an increase in price by 10%.
Assumption:
Here I assumed the situation that we need to increase in price every time when there is more than 10 views per hour. 

So again after increasing a price based on  10 views per hour condition,  counter variable is set to 0.  dtime variable will be the time when price increased.


b.	Choice of data format. Include one example of a request and response. 

REST API is being used to process the request and response. 
json and String is the format taken in request and response.

URI: localhost:8080/items
Method: GET 

Request Header Parameters:
Parameter Key: Authrorization
Parameter value: Bearer <token generated value>

Response Body Parameters:
{
“name”: “String”,
“description”: “String”,
“price”: int
}


URI: localhost:8080/buyItem

Request Header Parameters:
Parameter Key: Authrorization
Parameter value: Bearer <token generated value>
  

Request Body Parameters:
{
“name”: “String”,
“description”: “String”,
“price”: int
}


Response Body Parameter

returns a String .

It returns a String message: “You Order has been placed successfully”  

Or when item quantity is 0 then returns String
 “Sorry this item is out of stock”


c.	What authentication mechanism was chosen, and why?

Authentication Mechanism:  JWT (JSON Web Token) is being used to process the authentication of user.
APIs will use JWT to ensure the trust between the server and its client.
JSON Web Token is being used because it allows for custom private claims, making JWTs a good tool for exchanging any sort of validated or encrypted data that can be easily encoded as JSON.
We have used application/json format to process the REST API request and response. So, it is the best suitable tool for authentication.



-	How do we know if a user is authenticated? 
To answer this question when a user will hit required 2 API requests 
localhost:8080/items 
localhost:8080/buyItem/{itemName}/{description}/{price} 
 He/she will receive 401 Unauthorized error. Requires a valid token to process these requests.


-	Is it always possible to buy an item? 

No, it is not always possible to buy an item. Following are the 2 scenarios in which user will not be able to buy an item.

(1)	 If user is not authenticated, then in this case he/she will receive 401 Unauthorized error.
(2)	If the count of item is 0. In this case, User will receive a message “Sorry this item is out of stock”


Deliverables and Instructions for run an application:
Deploy and run an application:

(1) Copy the whole project in one folder location.
(2) Go to path where src, pom.xml, target folders are placed.
(3) Open CMD 
(4) Execute command “maven clean install”
(5) It will load all the dependencies and create a jar file in target folder.
(6) Go to target folder 
(7) To run this jar type command “java -jar <name of jar file created”
(8) Now you can hit the mentioned REST API requests from POSTMAN or any REST Client tool.


Note: How to test each API ,  sample request and response have been documented in a separate document.
