CREATE TABLE IF NOT EXISTS pontos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomePonto VARCHAR(255) NOT NULL,
    angulo_junta1 INT NOT NULL,
    angulo_junta2 INT NOT NULL,
    angulo_junta3 INT NOT NULL
);