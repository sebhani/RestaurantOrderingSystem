# RestaurantOrderingSystem
RestaurantOrderingSystem is our Software Architecture and Design I (SOEN 343 - Team Skyway) project for the semester.


## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)
  
  - *A great [video](https://www.youtube.com/watch?v=u96rVINbAUI) is available which shows you how to install MySQL as well as MySQL Workbench (optional GUI)*
- [Eclipse](https://www.eclipse.org/downloads/) (or any IDE)
- [Maven](https://stackoverflow.com/questions/8620127/maven-in-eclipse-step-by-step-installation)


## Running the application locally

1. Clone the repository:
 ```
 git clone https://github.com/trevornag/RestaurantOrderingSystem.git
 ```
2. Import the project in your preferred IDE.

3. It's important to update the project through Maven. In Eclipse, this can be done by holding `ALT+F5` or Right click on the project, select Maven then Update Project.

4. Run the script restaurantorderingsystem_db.sql in MySQL Workbench. This file can be found in the `resources` folder of the project.

5. Also in the `resources` folder, you will find a file called `application.properties`. Input your local database credentials in this file like this:

  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/restaurantorderingsystem_db
  spring.datasource.username=root
  spring.datasource.password=YOUR_PASSWORD
  ```

5. One way to run a Restaurant Ordering System application (a Spring Boot application) on your local machine is to execute the `main` method in the `api.RestaurantOrderingSystemApi` class from your IDE.

6. Open a web browser and head over to [http://localhost:8080](http://localhost:8080) to access the application.


## Accessing the deployed version of the application

Through Microsoft Azure services as well as a virtual machine running Ubuntu 18 LTS, anyone connected to the internet can also access the application by visiting [http://13.68.235.113:8080](http://13.68.235.113:8080)
