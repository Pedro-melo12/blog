CREATE TABLE IF NOT EXISTS tb_comentarios(
    idComentario BIGINT NOT NULL AUTO_INCREMENT,
    texto TEXT NOT NULL,
    dataDeCriacao DATE NOT NULL,
    idUsuario BIGINT,
    idPost BIGINT,
    PRIMARY KEY(idComentario),
    FOREIGN KEY(idUsuario) REFERENCES tb_usuarios(idUsuario),
    FOREIGN KEY(idPost) REFERENCES tb_posts(idPost)
);