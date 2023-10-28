DROP TABLE IF EXISTS clients; --nota para el Profe: a las tablas Le venia manejando los nombres de CLIENTES para la primera entrega y luego client para estas ultimas entregas antes de esta final(y antes de ver y de que trabajaramos el modelo de 3 capas)  y luego de client en estas ultimas entregas; Ahora la pongo tal como está en el diagrama E-R Porque voy a subir este diagrama al proyectofinal en mi github 

CREATE TABLE clients(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,  --en la tabla estan sin guión_  no last_name
    docnumber INT NOT NULL
);

--demas DDL (Data definition languaje)

DROP TABLE IF EXISTS products;
CREATE TABLE products(
    id INTEGER AUTO_INCREMENT PRIMARY KEY ,
    description VARCHAR(50),
    code VARCHAR(50),
    stock INTEGER UNIQUE NOT NULL,
    price DOUBLE
);

--La restricción UNIQUE en SQL se utiliza para garantizar que no se inserten valores duplicados en una columna específica o combinación de columnas que participen en la restricción UNIQUE y no formen parte de la CLAVE PRIMARIA.


--invoice / factura
DROP TABLE IF EXISTS invoice;      
CREATE TABLE invoice(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATETIME NOT NULL, --DEBE SER DATETIME NO DATE
    total DOUBLE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id) --llave foránea con id de tabla clients (le cambié de client a clients para que cumpliera con la nomenclatura del diagrama E-R)
);

-- detalle factura

#hay que tener cuidado con definir bien los campos y las relaciones para que estas se logren como deben en las querys

DROP TABLE IF EXISTS invoice_details;
CREATE TABLE invoice_details(   --correcciones
    --id INTEGER PRIMARY KEY AUTO_INCREMENT,  ESTE NO IBA y faltaba el campo de invoice_detail (como PRIMARY KEY) tener cuidado  debe estar como en el Diagrama E-r 
    invoice_id INT NOT NULL,
    invoice_detail_id INT PRIMARY KEY AUTO_INCREMENT,
    amount INT NOT NULL,
    product_id INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES products(id) --los campos rojos en el diagrama son las FK  que conectan a las Pk de las tablas invoice y productos[fk invoice_id con PK invoice]  y luego [fk product_id con Pk Products]
);

