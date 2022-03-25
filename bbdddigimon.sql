DROP DATABASE IF EXISTS digimon;

CREATE DATABASE digimon CHARACTER SET utf8 COLLATE utf8_general_ci;
USE digimon;

CREATE TABLE usuario(
    codigoUsu INT PRIMARY KEY AUTO_INCREMENT,
    nombreUsu VARCHAR(30) NOT NULL,
    contraseñaUsu VARCHAR(30) NOT NULL,
    partidasUsu INT DEFAULT 0 NOT NULL,
    partidasganaUsu INT DEFAULT 0 NOT NULL,
    evolucionesUsu INT DEFAULT 0 NOT NULL
);

CREATE TABLE digimon(
    nombreDig VARCHAR(30),
    nombreevolucionDig VARCHAR(30),
    nivelDig INT(1) NOT NULL,
    defensaDig INT NOT NULL,
    ataqueDig INT NOT NULL, 
    tipoDig ENUM("acuático", "arma", "baba", "diablillo", "parásito") NOT NULL,
    PRIMARY KEY (nombreDig,nombreevolucionDig)
);
    
    
CREATE TABLE tiene(
    codigoUsu INT, 
    nombreDig VARCHAR(30),
    equipo BOOLEAN,
    PRIMARY KEY(codigoUsu,nombreDig),
    CONSTRAINT fk_tiene_usuario FOREIGN KEY (codigoUsu) REFERENCES usuario(codigoUsu)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_tiene_nombre FOREIGN KEY (nombreDig) REFERENCES digimon(nombreDig)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- ALTER TABLE digimon ADD CONSTRAINT fk_digimon FOREIGN KEY (nombreevolucionDig) REFERENCES digimon(nombreDig) ON DELETE NO ACTION ON UPDATE CASCADE;
-- Lo controlamos por código
