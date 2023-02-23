# Fawry-Demo

steps for importing the project to eclips:

file -> import -> existing gradle project -> next -> select project source code from filesystem
 -> press run button on the top left

Requirements for project from JDK
The project requires JDK 19

attached in "attachments" directory all:  Sequence diagrams for different cases, Class diagram, Subsystem decomposition diagram,
                                         Software design specification (SDS) document and postman collection JSON file 

all API routes in postman collection are well teste

APIs examples.
----------------------------------------------------

POST /users/login
Body:
{
    "email":"youssef@gmail.com",
    "password":"youssef"
}

----------------------------------------------------

POST /users/register

Body: 
{
    "username":"ah",
    "email":"ah@gmail.com",
    "password": "ahmed"
}

----------------------------------------------------

POST services/search/Vodafone
return all services containing this query (Vodafone).

----------------------------------------------------

POST /etisalat-internet/creditCard-pay
Body:
{
    "secretInternetCode": "1aas71a21s8",
    "amount": 200
}


----------------------------------------------------

POST /etisalat-internet/wallet-pay

Body:
{
    "secretInternetCode": "1aas71a21s8",
    "amount": 200
}

----------------------------------------------------

POST /refund/add-refund/1

----------------------------------------------------

POST /wallet-funds/add-funds/200

----------------------------------------------------

POST /admins/overall-discount/0.5

----------------------------------------------------

GET /payment-transaction/list

----------------------------------------------------

GET /wallet-funds/list

----------------------------------------------------

GET /refund/list

----------------------------------------------------

POST /refund/accept/1

----------------------------------------------------

POST /refund/reject/1
