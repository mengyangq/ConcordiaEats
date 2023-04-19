# ConcordiaEats

## Overview

ConcordiaEats is a web application that provides an e-commerce platform for users to explore, order, and manage food products. The application features both customer and admin dashboards that offer functionalities such as product search, product management, cart management, favorite products, user registration, and login.

This project adopts the Model-View-Controller (MVC) architecture, which allows for the clean separation of concerns and modular organization of components. It utilizes the Spring MVC framework and implements database operations through the Spring Data JPA.

## Project Structure

The project is organized into the following components:

## Model

The Model layer encapsulates the data and business logic of the application. It contains classes that represent entities such as:

- Cart
- CartItemInfo
- Category
- Favorite
- Product
- User

These classes are annotated with JPA annotations, such as @Entity, @Table, and @Id, to define database tables, primary keys, and relationships. Getters and setters are provided for all fields, and some classes include composite primary keys using the @Embeddable and @EmbeddedId annotations.

## Views

The View layer defines HTML templates that are used to render the user interface. This includes the customer dashboard with links to search, categories, favorites, cart, and profile pages. The admin dashboard provides links to manage categories, products, discounts, and customer accounts.

## Controllers

The Controller layer is responsible for handling HTTP requests and generating appropriate responses. It includes controllers such as:

- LoginController
- RegisterController
- ManageCategoriesController
- ManageCustomersController
- ManageDiscountController
- ManageProductsController
- AdminSellingController
- CustomerCategoriesController
- SearchController
- FavoriteController
- CartController

These controllers handle GET and POST requests, interact with the Service and Model layers, and redirect or return views based on the user's actions.

## Repository

The Repository layer facilitates interactions with the database using Spring Data JPA CrudRepository or JpaRepository interfaces. This layer provides methods for basic CRUD operations, such as querying, inserting, updating, and deleting data.

## Service

The Service layer implements the business logic of the application. It processes requests, performs computations, and interacts with the Repository layer. The service classes include methods for operations such as registering a user, adding products to cart or favorites, updating product information, and more.

## Testing Strategies

The project includes a comprehensive suite of unit tests designed to validate the functionality and reliability of both the Model and Controller components. Tests are conducted using the JUnit testing framework, and the testing section includes test cases and summaries for classes such as UserTest, ProductTest, CategoryTest, FavoriteIdTest, CartIdTest, and various Controller tests.

## Quality Control

Quality control efforts include restructuring the base code to adhere to the MVC architectural pattern, thereby enhancing modularity and organization. The implementation of the Spring MVC framework contributes to the maintainability, robustness, and scalability of the ConcordiaEats web application.

## Dependencies

- Spring MVC
- Spring Data JPA
- Thymeleaf
- JUnit

## How to run 

- Pre requirement: Spring boot Installed in Eclipse IDE (Enterprise for web development), mysql Database (online or local)

(1)
```
Download and import project in Eclipse IDE
```

(2)
```
Make database name: springproject (or other name you like) 
```

(3)
```
Import springproject.sql file in database to create all tables (e.g., using MySQL Workbench)
```

(4)
```
Change the path to your database in application.properties (in src/main/resources)
```

(5)
```
Right click project and run as Spring Boot App & open:- http://localhost:8080/
```

## Login Example

### Customer login

- username: jay
- password: 123

### Admin login

- username: admin
- password: 123

## Our Amazing Team:

- [@QuoiHang](https://github.com/QuoiHang)
- [@Yunqing-Chen](https://github.com/Yunqing-Chen)
- [@xianzhigege](https://github.com/xianzhigege)
- [@SpankeyDaMankey](https://github.com/SpankeyDaMankey)
- [@MUSAIMAN](https://github.com/MUSAIMAN)
- [@zuwara](https://github.com/zuwara)


## Screenshots of the Customer-side Interface

### Login (same for admin)

<img width="1728" alt="1_login" src="https://user-images.githubusercontent.com/42892401/232938372-6911c66c-a76d-4892-af0f-33e6d8d35783.png">

### Customer Main

<img width="1728" alt="2_customerMain" src="https://user-images.githubusercontent.com/42892401/232938420-92c932d4-1e04-4c88-83be-ca1cb39b5a67.png">

### Search

<img width="1728" alt="3_search" src="https://user-images.githubusercontent.com/42892401/232938464-f7f1c931-2938-491b-b987-f1f5c6bd136d.png">

### Cart

<img width="1728" alt="4_cart" src="https://user-images.githubusercontent.com/42892401/232938488-2ba9c753-9e7b-4abf-91e2-7faad9c30b8a.png">

## Screenshots of the Admin-side Interface

### Admin Main

<img width="1728" alt="5_adminMain" src="https://user-images.githubusercontent.com/42892401/232938513-44f1babf-8227-441c-a257-ba348ef23631.png">

### Product Update

<img width="1728" alt="6_product" src="https://user-images.githubusercontent.com/42892401/232938532-d080d76f-7a6a-45b4-9c1d-551ae3edbbc2.png">

### Discount

<img width="1728" alt="7_discount" src="https://user-images.githubusercontent.com/42892401/232938552-a8688014-8ed9-4f4f-8940-b0e0505e5020.png">

### Most/least Selling

<img width="1728" alt="8_selling" src="https://user-images.githubusercontent.com/42892401/232938570-12d1f2f2-c1d1-4e8c-a56b-727ff1880e17.png">
