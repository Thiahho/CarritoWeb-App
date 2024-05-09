-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: shopc
-- ------------------------------------------------------
-- Server version	8.0.36

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

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idprod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idprod`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (22,'Nike Celeste ','Zapatilla','5','1800','zapa1.jpg','admin'),(23,'Adidas Blaco/Negro','Zapatilla','4','1600','zapa2.jpg','admin'),(24,'Nike AirForce 1 Mid','Zapatilla','6','2450','zapa3.jpg','admin'),(25,'Nike Air Max 1 Crepe','Zapatilla','7','3500','zapa4.jpg','admin'),(26,'Nike Forum Low','Zapatilla','4','3200','zapa5.jpg','admin'),(27,'Nike Air Force 1 Low Team Red','Zapatilla','5','4500','zapa6.png','admin'),(28,'Nike Jordan Stadium 90','Zapatilla','6','5000','zapa7.jpg','admin'),(29,'Reebok Leather 83','Zapatilla','6','3400','zapa8.jpg','admin'),(30,'Reebok Leather 38','Zapatilla','4','2600','zapa9.jpg','admin'),(31,'Puma Slipstream ','Zapatilla','4','2800','zapa10.jpg','admin'),(32,'Puma Slipstream INVDR','Zapatilla','5','3000','zapa11.jpg','admin'),(34,'Remera Shadow L','Remera','4','4000','remera1.jpg','admin'),(35,'Remera IDEVERRY M','Remera','4','3800','remera2.jpg','admin'),(36,'Remera Mafa S','Remera','5','5000','remera3.jpg','admin'),(37,'Remera NFV XL','Remera','4','3200','remera4.jpg','admin'),(38,'Pantalon Blanco Negro 42','Pantalon','5','7000','pantalon2.jpg','admin'),(39,'Pantalon Celeste Blanco','Pantalon','6','8000','pantalon3.jpg','admin'),(40,'Pantalon Negro','Pantalon','4','7400','pantalon1.jpg','admin'),(41,'Pantalon Verde','Pantalon','6','6700','pantalon4.jpg','admin'),(42,'Remera Azul XM','Remera','4','5200','remera5.jpg','admin'),(43,'Pantalon Cargo Celeste','Pantalon','4','6500','pantalon5.jpg','admin');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09 19:50:59
