CREATE DATABASE univel4a;

USE univel4a;

CREATE TABLE usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome_usuario VARCHAR(50) NOT NULL,
	senha_hash VARCHAR(64) NOT NULL,
	data_criacao timestamp
);
