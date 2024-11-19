CREATE DATABASE libreria;

USE libreria;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    precio DECIMAL(10, 2),
    descripcion TEXT
);
SHOW TABLES;
DESCRIBE libros;

ALTER TABLE libros ADD COLUMN nombre VARCHAR(255);
SELECT * FROM libros LIMIT 10;

INSERT INTO libros (titulo, autor, precio, descripcion) VALUES
('Java para principiantes', 'Juan Pérez', 29.99, 'Un libro completo para aprender Java desde cero.'),
('Programación avanzada en Java', 'María García', 49.99, 'Para programadores experimentados que quieren profundizar en Java.'),
('Estructuras de datos en Java', 'Carlos López', 39.99, 'Explora las estructuras de datos más importantes en Java.');
