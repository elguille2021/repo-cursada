DROP TABLE IF EXISTS client;

CREATE TABLE client(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    doc_number INT NOT NULL
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
    created_at DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id) --llave foránea con id de tabla client
);

-- detalle factura

DROP TABLE IF EXISTS invoice_details;
CREATE TABLE invoice_details(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    invoice_id INT NOT NULL,
    amount INT NOT NULL,
    product_id INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

