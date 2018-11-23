## RESTful service built with Spring Boot 2.x

A sample RESTful customer service built with Spring boot 2.0.6 , JPA  and JDK 8.  
It shows how to build the RESTful endpoint to manupulate with two entities Customer and Account which are connected via one-to-many relationship.

## How to start

Clone the [repository](https://gitlab.com/lihuicheung/customer-service.git) to local. In `customer-service` folder, run `mvnw spring-boot:run` to start the application.


## Call the RESTful services

- [Get all customers](#get_all_customers)
- [Get all accounts of one customer](#get_accounts)
- [Create a customer](#create_customer)
- [Create an account for one customer](#create_account)
- [Get the new customer](#get_a_customer)
- [Get the new account of the new customer](#get_accounts)
- [Update the customer](#license)
- [Update the account](#license)
- [Delete the customer](#license)

## Find all customers
```
$ curl -s -G http://localhost:8088/restapi/customers | json_pp
{
   "sort" : {
      "unsorted" : true,
      "sorted" : false
   },
   "first" : true,
   "last" : true,
   "content" : [
      {
         "customerName" : "Matt Zhang",
         "phoneNumber" : "+610452623758",
         "dateofBirth" : "1980-03-16",
         "customerId" : 1
      },
      {
         "phoneNumber" : "+610452623798",
         "customerName" : "Andrew Davis",
         "customerId" : 2,
         "dateofBirth" : "1985-03-16"
      }
   ],
   "numberOfElements" : 2,
   "number" : 0,
   "totalElements" : 2,
   "pageable" : {
      "unpaged" : false,
      "pageSize" : 20,
      "paged" : true,
      "offset" : 0,
      "pageNumber" : 0,
      "sort" : {
         "unsorted" : true,
         "sorted" : false
      }
   },
   "size" : 20,
   "totalPages" : 1
}

```

## Find all customers with sorting
```
$ curl -s -G http://localhost:8088/restapi/customers?sort=customerId,desc | json_pp
{
   "totalElements" : 2,
   "number" : 0,
   "numberOfElements" : 2,
   "content" : [
      {
         "phoneNumber" : "+610452623798",
         "dateofBirth" : "1985-03-16",
         "customerId" : 2,
         "customerName" : "Andrew Davis"
      },
      {
         "dateofBirth" : "1980-03-16",
         "phoneNumber" : "+610452623758",
         "customerId" : 1,
         "customerName" : "Matt Zhang"
      }
   ],
   "size" : 20,
   "sort" : {
      "unsorted" : false,
      "sorted" : true
   },
   "totalPages" : 1,
   "last" : true,
   "first" : true,
   "pageable" : {
      "offset" : 0,
      "pageNumber" : 0,
      "pageSize" : 20,
      "paged" : true,
      "unpaged" : false,
      "sort" : {
         "sorted" : true,
         "unsorted" : false
      }
   }
}


```
## Find all accounts of one customer
```
$  curl -s -G http://localhost:8088/restapi/customers/1/accounts | json_pp
{
   "pageable" : {
      "offset" : 0,
      "paged" : true,
      "pageNumber" : 0,
      "sort" : {
         "unsorted" : true,
         "sorted" : false
      },
      "pageSize" : 20,
      "unpaged" : false
   },
   "content" : [
      {
         "balance" : 8000,
         "openingDate" : "2016-05-16",
         "accountNumber" : 10881061,
         "accountName" : "westpac esaver"
      },
      {
         "accountNumber" : 10881069,
         "accountName" : "westpac choice",
         "openingDate" : "2016-05-16",
         "balance" : 12000
      }
   ],
   "number" : 0,
   "sort" : {
      "sorted" : false,
      "unsorted" : true
   },
   "totalPages" : 1,
   "first" : true,
   "numberOfElements" : 2,
   "size" : 20,
   "last" : true,
   "totalElements" : 2
}

```
## Add a new customer Iris
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"customerName": "Iris Zhang","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8088/restapi/customers/ | json_pp
{
   "dateofBirth" : "1985-03-16",
   "phoneNumber" : "+610452623738",
   "customerName" : "Iris Zhang",
   "customerId" : 4
}

```
## Add an account of customer Iris
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"accountNumber": 30981069,"accountName": "gold plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8088/restapi/customers/3/accounts | json_pp
{
   "balance" : 12000,
   "accountNumber" : 30981069,
   "accountName" : "gold plus",
   "openingDate" : "2016-05-16"
}
```
## Update the new customer Iris
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"customerName": "Iris Wong","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8088/restapi/customers/3 | json_pp
{
   "phoneNumber" : "+610452623738",
   "customerName" : "Iris Wong",
   "dateofBirth" : "1985-03-16",
   "customerId" : 3
}

```
## Update the new customer Iris
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"accountNumber": 30981069,"accountName": "silver plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8088/restapi/customers/3/accounts/30981069 | json_pp
{
   "accountName" : "silver plus",
   "openingDate" : "2016-05-16",
   "accountNumber" : 30981069,
   "balance" : 12000
}

```
## Delete the customer Iris and all linked accounts
```
$ curl -s -i -H "Content-Type: application/json;accept: application/json" -X DELETE  http://localhost:8088/restapi/customers/3/
HTTP/1.1 200
Content-Length: 0
Date: Fri, 23 Nov 2018 05:11:11 GMT

```
