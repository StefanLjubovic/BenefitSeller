# BenefitSeller

## Getting Started

### Commands

You can start the project using the following command.

```bash
docke-compose up --build
```

### Usage

On endpoint localhost:5050 we can connect to pgadmin and database with email ljubovicstefan@gmail.com and password admin2.
And from there we can connect to database postgres and postgres

For backend server there are three endpoints
```bash
Post: localhost:8082/transaction/

{
    "value":1000,
    "benefitName":"Coffee shops",
    "category":"Food and drinks",
    "email":"ivo@gmail.com"
}
```
With this endpoint we create transactions 

Second one is:

```bash
Get: localhost:8082/transaction/FAILURE
```
Where we can receive succesfull or failed transactions 

And 3rd api for getting information about users card balance

```bash
Get: localhost:8082/user/funds/ivo@gmail.com
```

## Environment

On the root of the project .env file needs to be created with these env values
```bash
# Variables
DB_HOST = postgres
DB_USERNAME = postgres
DB_PASSWORD = postgres
PGADMIN_DEFAULT_EMAIL=email
PGADMIN_DEFAULT_PASSWORD = admin2
DB_NAME = payment 
```
