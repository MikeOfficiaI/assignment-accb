README for Assignment Project
=========================

This README provides essential information on running the Assignment project:

How to Start the Assignment application
----------------------------
To start the Assignment application, follow these steps:

1. Clone the repository from GitHub: https://github.com/MikeOfficiaI/assignment-accb.git;
2. Open the `application.properties` file located in the `src/main/resources` directory and configure the database connection properties according to your setup. If you have Docker, you can use the Dockerized database setup instructions provided later in this README.
3. Save the changes made to the `application.properties` file.
4. Build the application using Gradle by executing the following command:
   ```
   gradle clean build
   ```
5. After building the application, run the application using the following command:
   ```
   gradle bootRun
   ```
6. The application will start, and you should see logs in the console.

Dockerized Database Setup
-------------------------
If you prefer to use Docker for the database setup, follow these additional steps:

1. Install Docker on your system and ensure it is running.
2. Find a suitable mysql image, in my case I used mysql:8.
3. Update the `application.properties` file with the appropriate database connection properties:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:3306/test
   spring.datasource.username=root
   spring.datasource.password=admin
   ```
4. Build container for mysql, using command like this: 
   ```
   docker run -p {PORT}:3306 --name {NAME} -e MYSQL_ROOT_PASSWORD={PASSWORD} -e MYSQL_DATABASE={DB_NAME} mysql:{TAG}
   ```
5. Create network, using following command: 
   ```
   docker network create {NEWTWORK_NAME}
   ```
6. Add mysql into network, using following command:
   ```
   docker network connect {NETWROK_NAME} mysqldb
   ```
7. Move to the root of the project and use this command to bring up the container:
   ```
   docker run -p 9090:8080 --name assignment --net {NETWROK_NAME} -e MYSQL_HOST=mysqldb -e MYSQL_USER={USER} -e MYSQL_PASSWORD={PASSWORD} -e MYSQL_PORT=3306 assignment
   ```
   Now you can access the application in http://localhost:9090/contracts.

Docker-compose Setup
-------------------------

1. Update the `application.properties` file with the appropriate database connection properties:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:3306/test
   spring.datasource.username=root
   spring.datasource.password=admin
   ```
2. Update the 'docker-compose.yml', according your configurations of database:
   ```
   MYSQL_HOST: mysqldb
   MYSQL_DATABASE: test
   MYSQL_USER: root
   MYSQL_ROOT_PASSWORD: admin
   MYSQL_PORT: 3306
   ```
3. Build our custom image:
   ```
   docker build -t assignment .
   ```
4. Use 'docker-compose up' to run our custom image;
5. Now you can access the application in http://localhost:9090/contracts

Reason for Chosen Solution
--------------------------
The chosen solution for the Assignment project is based on Java Spring Boot with Gradle as the build tool:


Frontend Hierarchy
============================

The frontend hierarchy of the Assignment project consists of multiple HTML pages, including `contracts.html`, `newContract.html`, `newCustomer.html`, `newVehicle.html`, `updateContract.html`, `updateCustomer.html` and `updateVehicle.html`.

1. **contracts.html**
   This page is used as a start page and displays a list of contracts, as well as buttons to go to pages to change the data of cars, customers and contracts.

2. **newContract.html**
   On this page, leasing contracts are created. There is a choice of cars that do not have contracts, and from all available customers. There are buttons to go to the main page and to the pages for creating cars and customers.

3. **newCustomer.html**
   On this page, customers are created. It is possible to add a first name, last name and date of birth. It is also possible to go to the main page.

4. **newVehicle.html**
   This page is where cars are created. It is possible to add the brand, model, wine, year and price of the car. It is possible to go to the home page.

5. **updateContract.html**
   On this page, there are changes to these contracts. It is possible to change the customer to any other available. To change the details of a specific customer, you need to go to the page for changing the details of a customer. It is possible to change the car to available cars from the list. (!!!CARS THAT HAVE CONTRACTS WILL NOT BE AVAILABLE BECAUSE THE TABLES ARE JOINED ONE TO ONE!!!) To change the details of a specific car, you need to go to the page to change the details of the customer. Other parameters, such as contract number and monthly rate, are available for editing on this page.

6  **updateVehicle.html**
   This page is only accessible from the page for changing contract data. On this page, you can change the data of a car that has a contract. All parameters of the car are available for changing.

7  **updateCustomer.html**
   This page is only accessible from the page for changing contract data. On this page, you can change the customer data from a specific contract. All parameters of the customer are available for changing.
