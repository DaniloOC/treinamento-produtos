CREATE TABLE produto (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(200),
    descricao varchar(255),
    valor NUMERIC(8, 2)
);

CREATE TABLE estoque (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    produto_id varchar(200),
    quantidade BIGINT,
    dt_hr_update TIMESTAMP,
    foreign key (produto_id) references produto(id)
);
