# mwi-gilded-rose-expansion

Explanation :

Set Up:
Following are the steps taken while setting up for an application:
Download and install Spring Tool Suite.
Create a New--Maven Project and named  as GildedRose
Group Id:  gilded.rose 
Artifact Id: GildedRose
Packaging :Jar 
Added dependencies to pom.xml 
Right Click-GildedRose-Maven-Update Project
Now all jars have imported to Maven Dependencies as part of project structure.


Surging Price Logic:
A static ArrayList has been taken with data type LocalDateTime.
static List<LocalDateTime>requestTimeLists=new ArrayList<LocalDateTime>();
Whenever any request comes, we fetch time of current request. Then this time of current request is added to ArrayList object.
We compare the time of latest request with time of all its prior requests till following 2 conditions meet:
Count of viewing the items requests is more than 10 and time of these requests happened in less than or equal to 1 hour.
Assumption:  Here I see there is need to increase in price only one time when there are more than 10 views  per hour. 
So, after increasing in price by 10% based on surging condition, when second time this condition meets, we are not increasing the price.
This is achieved by using static boolean surgedPrice=false; in InventoryService.java 
So, after increasing price one time, we are setting this flag to true.  If this flag is true we are not increasing the price again by 10% although above 2 conditions meet (more than 10 views per hour)
Currently there is no logic given to de surge the price. If we go on increasing the price then price of item will become unrealistic.



b.	Choice of data format. Include one example of a request and response. 

REST API is being used to process the request and response. 
json and String is the format taken in request and response.

URI: localhost:8080/v1/items 
Method: GET 

Request Header Parameters:
Parameter Key: Authrorization
Parameter value: Bearer <token generated value>

Response Body Parameters:
{
"itemId":int,
“name”: “String”,
“description”: “String”,
“price”: int
}


URI: localhost:8080/v1/buyItem/{itemId}/{quantity}

Request Header Parameters:
Parameter Key: Authrorization
Parameter value: Bearer <token generated value>
  
Response Body Parameter

returns a String .
Case 1:
It returns a String message: “You Order has been placed successfully”  
Case 2:
Or when item quantity is 0 then returns String
 “Sorry this item is out of stock”
Case 3: When user enters an invalid itemId. For which there is no item present in an inventory list.
"Yours requested item is not valid"

c.	What authentication mechanism was chosen, and why?

Authentication Mechanism:  JWT (JSON Web Token) is being used to process the authentication of user.
APIs will use JWT to ensure the trust between the server and its client.
JSON Web Token is being used because it allows for custom private claims, making JWTs a good tool for exchanging any sort of validated or encrypted data that can be easily encoded as JSON.
We have used application/json format to process the REST API request and response. So, it is the best suitable tool for authentication.



-	How do we know if a user is authenticated? 
To answer this question when a user will hit required 2 API requests 
localhost:8080/v1/items  
localhost:8080/v1/buyItem/{itemId}/{quantity} 
 User will receive 401 Unauthorized error. Requires a valid token to process these requests.


-	Is it always possible to buy an item? 

No, it is not always possible to buy an item. Following are the 3 scenarios in which user will not be able to buy an item.
(1)	 If user is not authenticated, then in this case user will receive 401 Unauthorized error.
(2)	If user enters an invalid itemId.  In this case, User will receive a message “Yours requested item is not valid”
(3)	If the requested quantity of item is more than quantity present in an inventory list. 
    In this case, User will receive a message “Sorry this item is out of stock”



Deliverables and Instructions for run an application:
Deploy and run an application:

(1) Copy the whole project in one folder location.
(2) Go to path where src, pom.xml, target folders are placed.
(3) Open CMD 
(4) Execute command “maven clean install”
(5) It will load all the dependencies and create a jar file in target folder.
(6) Go to target folder 
(7) To run this jar type command “java -jar <name of jar file created”
(8) Now you can hit the mentioned REST API requests from Postman.


Note: How to test each API ,  sample request and response have been documented in a separate document.

Assumptions: Currently there is no database being used.  So there are pre defined users and items in inventory list.
             It is assumed that users have been created.
             Predefined Users are:
    Current all users and passwords are in lowercase letters. Like admin, andy, randall, dwayne  
    username   password
    admin      password
    andy       password
    randall    password
    dwayne     password 
    
   While authenticating (token generation), any user can be used for testing the REST APIs.
   
   
    
