-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 35.202.113.52    Database: springproject
-- ------------------------------------------------------
-- Server version	8.0.26-google

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4e6d6ac8-d8e6-11ed-be32-42010a400002:1-68297';

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `cart_ibfk_2` (`product_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `categoryid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'meal'),(2,'snacks'),(3,'fruits'),(4,'vege'),(5,'drink'),(10,'toothpaste');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `favorites_ibfk_2` (`product_id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,1),(1,3),(1,6),(1,15),(1,20),(1,22),(1,24),(1,26),(3,26),(3,30),(1,33),(3,35),(3,36),(1,37);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL,
  `password` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'123','1');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT 'https://placehold.co/100x100.png',
  `categoryid` int NOT NULL,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  `weight` int NOT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `onsale` tinyint(1) NOT NULL DEFAULT '0',
  `discount` int NOT NULL DEFAULT '0',
  `sold` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `products_ibfk_1` (`categoryid`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `categories` (`categoryid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Coke','https://i.postimg.cc/HnmKwnwy/drink-coke.jpg',5,481,3,384,'A carbonated soft drink that has a sweet, caramel-like flavor and is one of the most popular beverages in the world',1,10,119),(2,'Coke (Diet)','https://i.postimg.cc/gjK7NpsB/drink-dietcoke.jpg',5,498,3,384,'A sugar-free, calorie-free carbonated beverage that has a similar taste to regular Coke, but with artificial sweeteners',0,0,12),(3,'Coke (Zero)','https://i.postimg.cc/Hxwvkmqs/drink-zerocoke.jpg',5,297,3,384,'A zero-sugar, low-calorie soft drink that has a similar taste to regular Coke, but with a different sweetener blend',0,0,3),(4,'Iced Coffee','https://i.postimg.cc/y6h2VhKX/drink-icedcoffee.jpg',5,250,2.5,250,'A cold, refreshing beverage made by pouring brewed coffee over ice and often mixed with milk or flavorings',1,20,100),(5,'Iced Tea','https://i.postimg.cc/kXnzDVXr/drink-icedtea.jpg',5,250,3.5,250,'A refreshing beverage made by steeping tea leaves in hot water, cooling it down, and serving it over ice with optional sweeteners and flavors',0,0,50),(6,'Latte','https://i.postimg.cc/m28q9btP/drink-latte.jpg',5,250,3,250,'A popular espresso-based drink made with steamed milk and topped with a small amount of foam',0,0,10),(7,'Orange Juice','https://i.postimg.cc/g2j7qfZN/drink-orangejuice.jpg',5,100,4,384,'A refreshing, vitamin C-rich citrus beverage made by squeezing or pressing fresh oranges',0,0,10),(8,'Sprite','https://i.postimg.cc/2StKH2dm/drink-sprite.jpg',5,100,3,384,'A clear, lemon-lime flavored carbonated soft drink that is known for its crisp, clean taste and refreshing bubbles',0,0,5),(9,'Hot Tea','https://i.postimg.cc/4dkFGyFS/drink-tea.jpg',5,100,4,100,'A comforting and warming beverage made by steeping tea leaves in hot water and often served with milk, honey, or lemon',0,0,0),(10,'Bottle Water','https://i.postimg.cc/GpsS6GzD/drink-water.jpg',5,500,3.5,500,'A popular brand of purified water that is sourced from local municipal water supplies and goes through a rigorous filtration process to ensure purity and taste',0,0,3),(11,'Apple','https://i.postimg.cc/QCj4BPDg/fruit-apple.jpg',3,481,0.8,150,'A round, juicy fruit with a crisp texture and sweet or tart flavor',0,0,119),(12,'Banana','https://i.postimg.cc/Znjf6cYG/fruit-banana.jpg',3,500,0.4,150,'A sweet, tropical fruit that is elongated and curved, with a soft, creamy flesh and a yellow or green skin that is peeled before eating',1,10,10),(13,'Blackberry','https://i.postimg.cc/nhXdQByW/fruit-blackberry.jpg',3,299,3.97,170,'A dark, juicy berry with a sweet and tangy flavor, often eaten raw, used in baking, or made into jams and jellies',0,0,1),(14,'Blueberry','https://i.postimg.cc/kMyhrnNT/fruit-blueberry.jpg',3,250,4.97,170,'A small, sweet berry with a deep blue color, often eaten raw, used in baking, or made into jams and syrups',0,0,100),(15,'Dragon Fruit','https://i.postimg.cc/YCTdNjkC/fruit-dragonfruit.jpg',3,250,3.78,250,'A tropical fruit with a bright pink or yellow skin and a white, juicy flesh filled with small black seeds, often eaten raw or used in smoothies and salads',0,0,50),(16,'grape','https://i.postimg.cc/bvb3m8NH/fruit-grape.jpg',3,250,5,630,'A small, juicy fruit with a sweet or tart flavor, often eaten raw, used in winemaking, or dried into raisins',0,0,10),(17,'Kiwi','https://i.postimg.cc/9F88MJnT/fruit-kiwi.jpg',3,100,7.97,500,'A small, oval-shaped fruit with a brown, fuzzy exterior and a bright green or yellow flesh with tiny black seeds, often eaten raw or used in salads and desserts',0,0,10),(18,'Mango','https://i.postimg.cc/zBrpMMym/fruit-mango.jpg',3,100,1,250,'A sweet, juicy tropical fruit with a yellow or orange flesh and a thick, tough skin that is peeled before eating, often used in smoothies, chutneys, and curries',0,0,5),(19,'Orange','https://i.postimg.cc/VvsgsC9D/fruit-orange.jpg',3,100,0.5,250,'A round, citrus fruit with a thick, orange skin and juicy, sweet-tart flesh, often eaten raw, juiced, or used in cooking and baking',0,0,0),(20,'Pineapple','https://i.postimg.cc/sfKK6Ty8/fruit-pineapple.jpg',3,500,3.47,2000,'A tropical fruit with a spiky, rough exterior and a sweet, juicy yellow flesh with a core of tougher, fibrous flesh, often eaten raw, used in smoothies and salads, or grilled for a caramelized flavor',0,0,3),(21,'Burger','https://i.postimg.cc/mDyVGw9P/meal-burger.jpg',1,500,8,250,'A sandwich consisting of a cooked ground beef patty, often served with lettuce, tomato, onion, pickles, and various condiments, all placed inside a sliced bun',0,0,100),(22,'Fried Chicken','https://i.postimg.cc/1XWH83JP/meal-friedchicken.jpg',1,500,20,1000,'Chicken pieces (such as wings, drumsticks, and breasts) that are coated in a seasoned breading or batter and then deep-fried until crispy and golden',0,0,10),(23,'Fried Rice','https://i.postimg.cc/bNJgK1wv/meal-friedrice.jpg',1,296,10,400,'A dish made from cooked rice that is stir-fried in a wok or frying pan, often mixed with vegetables, eggs, and various proteins such as chicken, shrimp, or pork',1,20,4),(24,'Lobster','https://i.postimg.cc/G2dJzyfd/meal-lobster.jpg',1,250,35,1000,'A large marine crustacean typically served steamed or boiled, often accompanied by melted butter and lemon',0,0,100),(25,'Pizza','https://i.postimg.cc/yNFyFPvL/meal-pizza.jpg',1,250,15,1000,'A popular Italian dish made from a yeasted flatbread topped with tomato sauce, cheese, and various toppings, typically baked in a high-temperature oven',0,0,50),(26,'Ramen','https://i.postimg.cc/Pxyb7qGZ/meal-ramen.jpg',1,249,15,550,'A Japanese dish consisting of wheat noodles served in a meat or fish-based broth, flavored with soy sauce or miso, and often garnished with ingredients such as sliced pork, dried seaweed, and green onions',0,0,11),(27,'Salad','https://i.postimg.cc/yNqTg5XJ/meal-salad.jpg',1,97,8,200,'A dish made from a mixture of raw or cooked vegetables, often dressed with a vinaigrette, mayonnaise, or other dressing',0,0,13),(28,'Steak','https://i.postimg.cc/fTJ7HZ8t/meal-steak.jpg',1,97,25,400,'A high-quality cut of beef, typically from the loin or rib, cooked by grilling, broiling, or pan-frying',0,0,8),(29,'Taco','https://i.postimg.cc/y83PNB94/meal-tacco.jpg',1,100,3.5,150,'A traditional Mexican dish made from a folded corn or flour tortilla filled with various ingredients such as seasoned meat, beans, cheese, lettuce, tomatoes, and salsa',0,0,0),(30,'Wonton','https://i.postimg.cc/L4yBBh3F/meal-wonton.jpg',1,500,12,350,'A Chinese dish consisting of small dumplings filled with a mixture of ground meat and/or vegetables, typically served in a clear broth',0,0,3),(31,'Broccoli','https://i.postimg.cc/mk6Yb6gg/veg-broccoli.jpg',4,498,1.5,300,'A nutrient-rich green vegetable with a dense, tree-like structure, often steamed or boiled and served as a healthy side dish',0,0,102),(32,'Carrot','https://i.postimg.cc/152G2TdW/veg-carrot.jpg',4,500,0.25,60,'An orange root vegetable with a crunchy texture and a sweet taste, commonly eaten raw, cooked, or juiced',0,0,10),(33,'Corn','https://i.postimg.cc/2y5dNfmt/veg-corn.jpg',4,300,0.5,250,'A popular cereal grain with sweet, juicy kernels that can be boiled, grilled, or used as an ingredient in various dishes',0,0,0),(34,'Cucumber','https://i.postimg.cc/CKVjL8Sk/veg-cucumber.jpg',4,249,0.75,300,'A long, green vegetable with a mild flavor and high water content, often used in salads, sandwiches, or as a refreshing snack',0,0,101),(35,'Lettuce','https://i.postimg.cc/HL4bJLkK/veg-lettuce.jpg',4,250,1.25,800,'A leafy green vegetable, often used as a base for salads or as a crunchy component in sandwiches and wraps',0,0,50),(36,'Mashroom','https://i.postimg.cc/g2hVWsFG/veg-mushroom.jpg',4,250,2,225,'Edible fungi with a unique, earthy flavor and a meaty texture, used in a variety of culinary dishes',0,0,10),(37,'Onion','https://i.postimg.cc/hjDTVqJG/veg-onion.jpg',4,100,0.4,150,'A pungent, aromatic vegetable with layers of papery skin, often used to enhance the flavor of savory dishes',0,0,10),(38,'Green Pepper','https://i.postimg.cc/j2CfkQ40/veg-pepper.jpg',4,100,0.75,150,'A mildly flavored, crunchy vegetable with a hollow interior, often used in salads, stir-fries, and stuffed with various fillings',0,0,5),(39,'Potato','https://i.postimg.cc/DZxsgYsP/veg-potato.jpg',4,100,0.4,200,'A starchy, versatile root vegetable that can be baked, mashed, fried, or used in a wide range of dishes',0,0,0),(40,'Tomato','https://i.postimg.cc/5yGzcYsH/veg-tomato.jpg',4,500,0.6,180,'A juicy, red vegetable with a slightly sweet and tangy flavor, often used in salads, sandwiches, sauces, and many other dishes',0,0,3),(46,'test','https://placehold.co/100x100.png',1,1,1,1,'111',0,0,0),(76,'test3','https://placehold.co/100x100.png',1,2,2,2,'334',0,0,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchased`
--

DROP TABLE IF EXISTS `purchased`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchased` (
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `purchased_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `purchased_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchased`
--

LOCK TABLES `purchased` WRITE;
/*!40000 ALTER TABLE `purchased` DISABLE KEYS */;
INSERT INTO `purchased` VALUES (1,1,26),(1,2,2),(1,3,3),(1,5,5),(1,11,19),(1,13,1),(1,15,3),(1,23,4),(1,25,1),(1,28,2),(1,31,2),(1,34,1),(3,26,1),(3,27,3),(3,28,1);
/*!40000 ALTER TABLE `purchased` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(250) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'ROLE_USERS',
  `enabled` tinyint DEFAULT NULL,
  `email` varchar(110) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jay','123','ROLE_USER',1,'gajerajay9@gmail.com'),(2,'admin','123','ROLE_ADMIN',1,'20ceuos042@ddu.ac.in'),(3,'random1','random1','ROLE_USER',1,'random1@gmail.com'),(4,'random2','random2','ROLE_USER',1,'random2@gmail.com'),(5,'random3','random3','ROLE_USER',1,'random3@gmail.com'),(8,'testadmin','123','ROLE_ADMIN',1,'random5@gmail.com'),(9,'testuser','123','ROLE_USER',1,'random4@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18  2:52:49
