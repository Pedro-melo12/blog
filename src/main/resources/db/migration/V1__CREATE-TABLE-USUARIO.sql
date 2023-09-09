CREATE TABLE IF NOT EXISTS tb_usuarios(
    idUsuario BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    sobrenome VARCHAR(150),
    email VARCHAR(100),
    senha VARCHAR(20)
    PRIMARY KEY(idUsuario)
);