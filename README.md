                                               # Target Interview

## __Case Study:  myRetail RESTful service__

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 

The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.
Build an application that performs the following actions: 
Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 

Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail) 

Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response. 

BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 

*********************************************************************************************************************************
# __Solution:__

## MyRetail API :

<ol>
  <li>Retrieve product and price information by Product Id.</li>
  <li>Secure API with basic authentication.</li>	
  <li>Implement Swagger2 for API documentation</li>
</ol>
Below endpoint is totally secure in this application using basic security. 
                                   Method               Request                   Credentials
                                     GET              /products/{id}              [SECURE -- normaluser/normaluser]
					

###Technology Stack Used =>

1. Spring Boot : 
	https://start.spring.io/
	https://spring.io/guides/gs/serving-web-content/ 
2. MongoDB:
	https://www.mongodb.com/what-is-mongodb 
3. Maven:
	https://maven.apache.org/ 
4. Mokito/Junit:
	http://site.mockito.org/ 
5. Postman: 
	https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en 

###Instructions for setup =>

1. Java 1.8
2. IntelliJ  : https://www.jetbrains.com/idea/download/#section=windows
3. Mongo DB: https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/
4. Maven: https://www.mkyong.com/maven/how-to-install-maven-in-windows/ 
5. Github:
Download project from the following git repository
https://github.com/sonicasingh9/myRetail

a) Download as a ZIP file   OR
b) Clone the git project from git-bash or command prompt (You must have git setup)

6. Import the project into intelliJ


### Instructions to test the project =>

Test cases are present for service layer using mokito.

tgt\myRetail\src\test\java

To run the test, run command  => mvn test.

### Instructions to run the project =>

Run mongo DB from the command prompt, check using link http://localhost:27017/  
Run command => mvn spring-boot:run 

### Check the http Request:__

### Secure API
The end point of this application is secure. There are 3 users in this application.
1. admin/admin   --- This user is added for updating the price for future use. In this version UPDATE functionality is not implemented 
2. normaluser/normaluser  --  get the product by prodctId.
3. dbuser/dbuser  -- get the product by prodctId.

###  Swagger2 
http://localhost:8080/swagger-ui.html
