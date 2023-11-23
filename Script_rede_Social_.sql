
-- Cria a tabela `usuarios`
CREATE TABLE usuarios (
id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome TEXT NOT NULL, 
  email TEXT NOT NULL, 
  senha TEXT NOT NULL  
);

-- Cria a tabela `mensagens`
CREATE TABLE mensagens (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  remetente INTEGER NOT NULL,
  destinatario INTEGER NOT NULL,
  mensagem TEXT NOT NULL,
  data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP 
);


-- Cria a tabela `amigos`
CREATE TABLE amigos (
  id_usuario INTEGER NOT NULL,
  id_amigo INTEGER NOT NULL,
  PRIMARY KEY (id_usuario, id_amigo),
  
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id),
  FOREIGN KEY (id_amigo) REFERENCES usuarios (id)
);

-- Cria a tabela `users`
CREATE TABLE users (
  id INTEGER AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Cria a tabela `login_history`
CREATE TABLE login_history (
  id INTEGER AUTO_INCREMENT,
  user_id INT NOT NULL,
  login_time TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);


INSERT INTO usuarios (nome, email, senha) VALUES ('João da Silva', 'joao.silva@email.com', '123456');
INSERT INTO usuarios (nome, email, senha) VALUES ('Maria da Silva', 'maria.silva@email.com', '654321');
INSERT INTO usuarios (nome, email, senha) VALUES ('Cristiano da Silva', 'cristiano.silva.com', '123456');

INSERT INTO users (name, email, password)
VALUES ('John Doe', 'johndoe@example.com', 'password123');

INSERT INTO users (name, email, password)
VALUES ('Jane Doe', 'janedoe@example.com', 'password456');

INSERT INTO mensagens (remetente, destinatario, mensagem, data) VALUES ('João da Silva', 'Maria da Silva', 'Olá, Maria! Como vai?', '2023-07-20 12:00:00');

INSERT INTO amigos (id_usuario, id_amigo)
VALUES (1, 2);

INSERT INTO amigos (id_usuario, id_amigo)
VALUES (1, 3);

UPDATE usuarios
SET nome = 'Novo nome',
  email = 'novo.email@email.com',
  senha = 'nova_senha'
WHERE id = 1;

UPDATE mensagens
SET mensagem = 'Nova mensagem'
WHERE id = 1;

UPDATE amigos
SET id_amigo = 3
WHERE id_usuario = 1 AND id_amigo = 2;

UPDATE users SET name = 'new_name'
WHERE id = 1;

UPDATE users SET email = 'new_email'
WHERE id = 1;

UPDATE users SET password = 'new_password'
WHERE id = 1;



SELECT *
FROM usuarios;

SELECT nome, email
FROM usuarios
WHERE id = 1;

SELECT *
FROM mensagens;

SELECT remetente, destinatario, mensagem
FROM mensagens
WHERE id = 1;

SELECT *
FROM usuarios
WHERE email = "plinio@gmail.com";

SELECT *
FROM amigos
WHERE id_usuario = 2 or id_amigo;

DELETE FROM usuarios
WHERE id = 1;

DELETE FROM mensagens
WHERE id = 1;

DELETE FROM amigos
WHERE id = 1 

DELETE FROM users 
WHERE id = 1

