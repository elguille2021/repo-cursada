INSERT INTO CLIENTES (id, nombre, apellido, nombredocumento) values
( 1,'Juan', 'Perez', 'memouno'),     #ya no van 12345678
(2,'Azucena', 'García', 'memodos'),   #23456789   34567890
(3,'Serafin' , 'Lopez', 'memotres');    


/*PASOS

1. PRIMERO  CREAR LOS SCRIPTS DE SQL EN   resources  --Ahi ya esta application.properties que tiene todo el enlace a la bd que hace JPA

EN CARPETAS DISTINTAS  
schema.sql 
data.sql

PASO 2 crear las entidades o sea la clase Clientes.java  que va en la carpeta de entity


PASO 3  CREAR EL DAO  o clase DaoFactory.java en la carpeta service

PASO 4 LEVANTAR SPRING PARA VER EL RESULTADO O SI YA ESTA CORRIENDO ACTUALIZAR LA PÁGINA

 */