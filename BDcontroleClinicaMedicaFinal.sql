-- Criando tabela paciente
CREATE TABLE tb_paciente (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100), 
	sexo VARCHAR(10),
	data_nasc DATE,
	fg_ativo BOOL
);

wadawdawdaw

-- Criando tabela especialidade
CREATE TABLE tb_especialidade (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100)
);

-- Criando tabela medico
CREATE TABLE tb_medico (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100), 
	id_especialidade INT,
	nro_crm VARCHAR(15),
	fg_ativo BOOL,
	FOREIGN KEY (id_especialidade)
		REFERENCES tb_especialidade(id) 
);

-- Criando tabela agendamento
CREATE TABLE tb_agendamento (
	id SERIAL PRIMARY KEY,
	data DATE,
	id_paciente INT,
	id_medico INT,
	status VARCHAR(15),
	horario TIME,
	FOREIGN KEY (id_paciente)
		REFERENCES tb_paciente(id),
	FOREIGN KEY (id_medico)
		REFERENCES tb_medico(id)
);

-- Adicionando mais 3 campos a tabela tb_paciente
ALTER TABLE tb_paciente
	ADD COLUMN telefone VARCHAR(15),
	ADD COLUMN email VARCHAR(100),
	ADD COLUMN cpf VARCHAR(15);
	
SELECT * FROM tb_paciente;

-- Adicionando mais 2 campos a tabela tb_medico
ALTER TABLE tb_medico 
	ADD COLUMN telefone VARCHAR(15),
	ADD COLUMN email VARCHAR(100);
	
SELECT * FROM tb_medico;

-- Adicionando mais 1 campos a tabela tb_agendamento
ALTER TABLE tb_agendamento 
	ADD COLUMN sintoma VARCHAR(200);
	
SELECT * FROM tb_agendamento;