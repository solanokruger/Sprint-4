INSERT INTO partido(nome, sigla, ideologia, data_fundacao) VALUES ("MOVIMENTO DEMOCRÁTICO BRASILEIRO", "MDB", "CENTRO", '1980-01-15');
INSERT INTO partido(nome, sigla, ideologia, data_fundacao) VALUES ("PARTIDO TRABALHISTA BRASILEIRO", "PTB", "DIREITA", '1979-11-21');
INSERT INTO partido(nome, sigla, ideologia, data_fundacao) VALUES ("PARTIDO DEMOCRÁTICO TRABALHISTA", "PDT", "ESQUERDA", '1979-06-17');

INSERT INTO associado(nome, cargo, data_nascimento, sexo_enum, partido_id) VALUES ("João", "NENHUM", '1985-05-16', "MASCULINO", 1);
INSERT INTO associado(nome, cargo, data_nascimento, sexo_enum, partido_id) VALUES ("Maria", "VEREADOR", '1990-04-12', "FEMININO", 1);
INSERT INTO associado(nome, cargo, data_nascimento, sexo_enum, partido_id) VALUES ("Pedro", "PREFEITO", '1975-07-24', "MASCULINO", 2);
INSERT INTO associado(nome, cargo, data_nascimento, sexo_enum, partido_id) VALUES ("Bruna", "VEREADOR", '1995-08-20', "FEMININO", 3);
INSERT INTO associado(nome, cargo, data_nascimento, sexo_enum, partido_id) VALUES ("Alice", "NENHUM", '1996-02-10', "FEMININO", 3);