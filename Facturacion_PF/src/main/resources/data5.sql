INSERT INTO clients (name, lastname, docnumber) VALUES
('Juan','Perez',1),        
('Azucena','Garcia',2),   
('Serafin','Lopez',3);  

--quité lo de memouno..dos..ytres porque es numero no letras  y los campos se nombran como piden en el diagrama de las tablas no nombre, apellido, nombredocumento

-- SQL-DML(data manipulation languaje)

-- NOTA: POR ESO SE CREAN EN ESTE ORDEN Y POR RECOMENDACION DEL PROFE PARA LAS RELACIONES 
-- MODELAR LAS TABLAS EMPEZANDO POR LAS QUE NO TIENEN RELACIONES A LOS LADOS

-- Insertando datos en la tabla  product
INSERT INTO products(description, code, stock, price)
VALUES
    ('PROD1', '001', 10, 20.00),
    ('PROD2', '002', 50, 12.00),
    ('PROD3', '003', 100, 25.95);


-- Insertar datos en la tabla  invoice
INSERT INTO invoice(client_id, created_at, total)
VALUES
    (1, '2024-01-10', 200.00),
    (2, '2023-02-11', 350.50),
    (3, '2022-03-12', 800.95);


-- detalle de factura

-- Insertar datos en la tabla  invoice_detail  
INSERT INTO invoice_details(invoice_id, amount, product_id, price)
VALUES
    (1, 200, 312, 15.99),
    (2, 350, 359, 20.50),
    (3, 800, 819, 80.28);


