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

## get all customers
```
$ curl -s -G http://localhost:8088/restapi/customers | json_pp
{
   "totalElements" : 4,
   "number" : 0,
   "numberOfElements" : 4,
   "pageable" : {
      "offset" : 0,
      "sort" : {
         "sorted" : false,
         "unsorted" : true
      },
      "pageSize" : 20,
      "pageNumber" : 0,
      "paged" : true,
      "unpaged" : false
   },
   "size" : 20,
   "content" : [
      {
         "dateofBirth" : "1980-03-16",
         "customerId" : 1,
         "customerName" : "Matt Zhang",
         "phoneNumber" : "+610452623758"
      },
      {
         "dateofBirth" : "1985-03-16",
         "phoneNumber" : "+610452623798",
         "customerName" : "Andrew Davis",
         "customerId" : 2
      },
      {
         "phoneNumber" : "+610452623738",
         "customerId" : 6,
         "customerName" : "Iris Zhang",
         "dateofBirth" : "1985-03-16"
      },
      {
         "dateofBirth" : "1985-03-16",
         "customerName" : "Iris Zhang",
         "customerId" : 7,
         "phoneNumber" : "+610452623738"
      }
   ],
   "sort" : {
      "sorted" : false,
      "unsorted" : true
   },
   "totalPages" : 1,
   "last" : true,
   "first" : true
}
```
