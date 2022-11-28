INSERT INTO partidos.associado(cargo, data_nascimento, nome, sexo_enum, partido_id)
VALUES ("NENHUM", '1985-05-16', "João", "MASCULINO", 1);
INSERT INTO partidos.associado(cargo, data_nascimento, nome, sexo_enum, partido_id)
VALUES ("VEREADOR", '1990-04-12', "Maria", "FEMININO", 1);
INSERT INTO partidos.associado(cargo, data_nascimento, nome, sexo_enum, partido_id)
VALUES ("PREFEITO", '1975-07-24', "Pedro", "MASCULINO", 2);
INSERT INTO partidos.associado(cargo, data_nascimento, nome, sexo_enum, partido_id)
VALUES ("VEREADOR", '1995-08-20', "Bruna", "FEMININO", 3);
INSERT INTO partidos.associado(cargo, data_nascimento, nome, sexo_enum, partido_id)
VALUES ("NENHUM", '1996-02-10', "Alice", "FEMININO", 3);

INSERT INTO associado(nome, cargo, data_nascimento, sexo, partido)
VALUES ("João", "Nenhum", '1985-05-16', "Masculino", 1);
INSERT INTO associado(nome, cargo, data_nascimento, sexo, partido)
VALUES ("Maria", "Vereador", '1990-04-12', "Feminino", 1);
INSERT INTO associado(nome, cargo, data_nascimento, sexo, partido)
VALUES ("Pedro", "Prefeito", '1975-07-24', "Masculino", 2);
INSERT INTO associado(nome, cargo, data_nascimento, sexo, partido)
VALUES ("Bruna", "Vereador", '1995-08-20', "Feminino", 3);
INSERT INTO associado(nome, cargo, data_nascimento, sexo, partido)
VALUES ("Alice", "Nenhum", '1996-02-10', "Feminino", 3);