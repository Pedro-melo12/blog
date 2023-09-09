CREATE TABLE IF NOT EXISTS tb_comentarios(
    idComentario BIGINT NOT NULL AUTO_INCREMENT,
    texto TEXT,
    dataDeCriacao DATE,
    PRIMARY KEY(idComentario)
    FOREIGN KEY(idAutor) REFERENCES tb_usuarios(idAutor)
    FOREIGN KEY(idPost) REFERENCES tb_posts(idPost)
);