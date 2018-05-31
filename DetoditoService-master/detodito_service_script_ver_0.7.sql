CREATE DATABASE  IF NOT EXISTS `detodito_service` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `detodito_service`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: detodito_service
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Programación','Clases particulares de programación'),(2,'Matemática','Clases particulares de matemática'),(3,'Inglés','Clases particulares de inglés');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Lima'),(2,'Arequipa'),(3,'Ica');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distritos`
--

DROP TABLE IF EXISTS `distritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distritos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `provincia_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_provincia_idx` (`provincia_id`),
  KEY `fkk_provincia_idx` (`provincia_id`),
  KEY `ffk_provincia_idx` (`provincia_id`),
  CONSTRAINT `ffk_provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distritos`
--

LOCK TABLES `distritos` WRITE;
/*!40000 ALTER TABLE `distritos` DISABLE KEYS */;
INSERT INTO `distritos` VALUES (1,'Ancón',1),(2,'Ate',1),(3,'Barranco',1),(4,'Breña',1),(5,'Carabayllo',1),(6,'Chaclacayo',1),(7,'Chorrillos',1),(8,'Cieneguilla',1),(9,'Comas',1),(10,'El Agustino',1),(11,'Independencia',1),(12,'Jesús María',1),(13,'La Molina',1),(14,'La Victoria',1),(15,'Lima',1),(16,'Lince',1),(17,'Los Olivos',1),(18,'Lurigancho-Chosica',1),(19,'Lurin',1),(20,'Magdalena del Mar',1),(21,'Miraflores',1),(22,'Pueblo Libre',1),(23,'Pachacámac',1),(24,'Pucusana',1),(25,'Puente Piedra',1),(26,'Punta Hermosa',1),(27,'Punta Negra',1),(28,'Rímac',1),(29,'San Bartolo',1),(30,'San Borja',1),(31,'San Isidro',1),(32,'San Juan de Lurigancho',1),(33,'San Juan de Miraflores',1),(34,'San Luis',1),(35,'San Martín de Porres',1),(36,'San Miguel',1),(37,'Santa Anita',1),(38,'Santa María del Mar',1),(39,'Santa Rosa',1),(40,'Santiago de Surco',1),(41,'Surquillo',1),(42,'Villa El Salvador',1),(43,'Villa María del Triunfo',1);
/*!40000 ALTER TABLE `distritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `servicio_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `fecha` varchar(45) NOT NULL DEFAULT '',
  `observaciones` varchar(250) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `fk_usuario_idx` (`usuario_id`),
  KEY `fk_servicio_idx` (`servicio_id`),
  CONSTRAINT `fk_servicio` FOREIGN KEY (`servicio_id`) REFERENCES `servicios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,1,'24/07/2017','Ser puntual');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento_id` int(11) NOT NULL,
  `codigo_documento` varchar(45) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_documento_id_idx` (`tipo_documento_id`),
  KEY `fkk__usuario_idx` (`usuario_id`),
  KEY `fk___usuario_idx` (`usuario_id`),
  CONSTRAINT `fkk_tipo_documento` FOREIGN KEY (`tipo_documento_id`) REFERENCES `tipo_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,1,'088452368',1),(2,1,'123456',8),(3,1,'123456',1),(4,1,'12',8),(5,1,'123456',8),(6,1,'72247876',7),(7,1,'72247876',7),(8,1,'72247876',6),(9,1,'78239490',8);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ffk_departamentos_idx` (`departamento_id`),
  CONSTRAINT `ffk_departamentos` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Lima',1),(2,'Huaral',1),(3,'Canta',1);
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reclamos`
--

DROP TABLE IF EXISTS `reclamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reclamos` (
  `id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  `servicio_id` int(11) NOT NULL,
  `fecha` varchar(45) NOT NULL DEFAULT '',
  `observaciones` varchar(250) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `fk_servicio_idx` (`servicio_id`),
  KEY `fk_pedido_id_idx` (`pedido_id`),
  CONSTRAINT `fk_pedido_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_id` FOREIGN KEY (`servicio_id`) REFERENCES `servicios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reclamos`
--

LOCK TABLES `reclamos` WRITE;
/*!40000 ALTER TABLE `reclamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `reclamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `contactar` tinyint(1) NOT NULL,
  `descripcion` varchar(250) DEFAULT '',
  `observaciones` varchar(250) DEFAULT '',
  `proveedor_id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  `provincia_id` int(11) NOT NULL,
  `distrito_id` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_idx` (`categoria_id`),
  KEY `fk_proveedor_servicio_idx` (`proveedor_id`),
  KEY `fk__distrito_idx` (`distrito_id`),
  KEY `fk__provincia_idx` (`provincia_id`),
  KEY `fk__departamento_idx` (`departamento_id`),
  CONSTRAINT `fk__departamento` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk__distrito` FOREIGN KEY (`distrito_id`) REFERENCES `distritos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk__provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,1,'Java',1,'Clases particulares de Java, en todos los niveles','Dentro del pago se incluye el transporte.',1,1,1,40,'espera'),(2,2,'nada',1,'nada','nada',3,1,1,11,'espera'),(3,1,'123asd',1,'sadad','dsada',4,1,1,16,'reservado'),(4,1,'12asd',1,'asd','asd',5,1,1,18,'reservado'),(5,1,'C++',1,'Programacion basica en c++','Tipos de dato y funciones',7,1,1,15,'espera'),(6,1,'Sexual',1,'Sexual','Solo varones',8,1,1,4,'espera'),(7,3,'Inglish',1,'Verbo tu vi','I am\r\nYou are',9,1,1,8,'espera');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'DNI','Documento Nacional de Identidad');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Diego Cortez','Calle Guillermo Penaloza 172, Chorrillos','4582697','diego@gmail.com','123456'),(2,'Florette Skitteral','AV ANGAMOS ESTE 140 INT 201 MIRAFLORES','3055286','fskitteral0@mlb.com','xEudBq1'),(3,'Maren Rickerby','Jr. Huascarán 1185 - La Victoria','3747748','mrickerby1@google.ca','XXe8vpUS5yyY'),(4,'Jessie Tranckle','Av. La Marina 1321 - San Miguel','4371738','jtranckle4@deliciousdays.com','89TOb8'),(5,'Prudi Wilkenson','Yahuar Huaca 7308 Urb. El Trébol - Los Olivos','2957178','pwilkenson8@ted.com','BtoGhEjSMmVa'),(6,'abcd','aasd','1123','asd@dfg.com','123'),(7,'juan','123','123','juan@gmail.com','123'),(8,'andre','Jr. PoseidÃ³n Mz. A9 Lt. 16 urb. Sagitario-Surco','977654231','andre@gmail.com','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'detodito_service'
--

--
-- Dumping routines for database 'detodito_service'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18  9:23:30
