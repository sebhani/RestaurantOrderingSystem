CREATE DATABASE restaurantorderingsystem_db;
USE restaurantorderingsystem_db;
DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Lasagna','Culinary dish made with stacked layers of pasta alternated with sauces and ingredients',15,1),(2,'Poutine','Dish that includes french fries and cheese curds topped with a brown gravy',4.35,1),(3,'Falafel','Deep-fried ball, or a flat or doughnut-shaped patty, made from ground chickpeas, fava beans, or both',8,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

