CREATE TABLE IF NOT EXISTS tb_posts(
    idPost  BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255),
    conteudo TEXT,
    dataDeCriacao  DATE,
    PRIMARY KEY(idPost) REFERENCES tb_usuarios(idAutor)
    FOREIGN KEY(idAutor)
);