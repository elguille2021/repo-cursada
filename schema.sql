DROP TABLE CLIENTES IF EXISTS;
#CREATE TABLE CLIENTES (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 #nombre VARCHAR(75) NOT NULL, apellido VARCHAR(75) NOT NULL, nombredocumento VARCHAR(11)  NOT NULL);



 #CREATE TABLE CLIENTES (id INT NOT NULL AUTO_INCREMENT ,
 #nombre VARCHAR(75) NOT NULL, apellido VARCHAR(75) NOT NULL, nombredocumento VARCHAR(11)  NOT NULL,PRIMARY KEY (id));

--ES ESTE
 CREATE TABLE CLIENTES (id, nombre VARCHAR(75) NOT NULL, apellido VARCHAR(75) NOT NULL, nombredocumento VARCHAR(11)  NOT NULL);