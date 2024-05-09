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
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idpedido` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `unombre` varchar(45) DEFAULT NULL,
  `uemail` varchar(45) DEFAULT NULL,
  `udireccion` varchar(45) DEFAULT NULL,
  `pnombre` varchar(45) DEFAULT NULL,
  `pcategoria` varchar(45) DEFAULT NULL,
  `pprecio` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'PROD-ID-0012','thiago','thiago22@gmail.com','casa 22','Remera 4','Remeras','6000.0','PAGADO'),(2,'PROD-ID-0021','thiago','thiago22@gmail.com','casa 22','Zapatilla 5','Zapatilla','15000.0','PAGADO'),(3,'PROD-ID-0012','thiago','thiago22@gmail.com','casa 22','Remera 4','Remeras','6000.0','PAGADO'),(4,'PROD-ID-0012','thiago2','thiago@gmail.com2','casa 1232','Remera 4','Remeras','6000.0','PAGADO'),(5,'PROD-ID-0021','thiago','thiago22@gmail.com','casa 22','Zapatilla 5','Zapatilla','15000.0','PAGADO'),(6,'PROD-ID-0021','thiago','thiago22@gmail.com','casa 22','Zapatilla 5','Zapatilla','15000.0','PAGADO'),(7,'PROD-ID-0021','thiago2','thiago@gmail.com2','casa 1232','Zapatilla 5','Zapatilla','15000.0','PAGADO'),(8,'PROD-ID-0016','santi','santi@gmail.com','casa 123','Zapatilla 2','Zapatilla','15000.0','PAGADO'),(9,'PROD-ID-0014','santi','santi@gmail.com','casa 123','Zapatilla 1','Zapatilla','15000.0','PAGADO'),(10,'PROD-ID-0016','santi','santi@gmail.com','casa 123','Zapatilla 2','Zapatilla','15000.0','PAGADO');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
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
