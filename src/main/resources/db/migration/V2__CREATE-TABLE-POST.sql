CREATE TABLE IF NOT EXISTS tb_posts(
    idPost  BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT NOT NULL,
    dataDeCriacao  DATE NOT NULL,
    PRIMARY KEY(idPost) REFERENCES tb_usuarios(idAutor),
    FOREIGN KEY(idAutor)
);