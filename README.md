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
Run `curl` command