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

Spring MVC
Spring Data JPA
Thymeleaf
JUnit
