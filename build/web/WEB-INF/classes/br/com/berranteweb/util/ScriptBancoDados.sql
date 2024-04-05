create database BerranteWeb;
create table pessoa(
    idPessoa serial not null,
    nome varchar(100),
    cpf varchar(100) not null,
    cidade varchar(100),
    estado varchar(100),
    cep varchar(100),
    email varchar(100) not null,
    senha varchar (30) not null,
    constraint pk_pessoa primary key(idPessoa)
);

create table pecuarista(
    idPecuarista serial not null,
    idPes integer,
    constraint pk_pecuarista primary key(idPecuarista),
    constraint fk_pecuarista_pessoa foreign key(idPes) references pessoa (idPessoa)
);

create table funcionario(
    idFuncionario serial not null,
    idPes integer not null,
    idfazenda integer not null,
    trabalho varchar(200),
    salario numeric,
    constraint pk_funcionario primary key(idFuncionario),
    constraint fk_funcionario_pessoa foreign key(idPes) references pessoa (idPessoa),
    constraint fk_funcionario_fazenda foreign key(idfazenda) references fazenda (idFazenda)

);

create table fazenda(
    idFazenda serial not null,
    idPes integer,
    nomeFazenda varchar(100),
    endereco varchar(100),
    numero varchar(100),
    cidade varchar(100),
    estado varchar(100),
    constraint pk_fazenda primary key(idFazenda),
    constraint fk_fazenda_pessoa foreign key(idPes) references pessoa (idPessoa)
);



create table animal(
    idAnimal serial not null,
    idFazenda integer not null,
    brinco numeric(100) not null,
    raca varchar(10),
    sexo varchar(10),
    dataNasc date(100),
    tipo varchar(100),
    status varchar (30),
    constraint pk_animal primary key(idAnimal),
    constraint fk_animal_pessoa foreign key(idFaz) references fazenda (idFazenda)
);

select*from pessoa;
select*from pecuarista;
select*from funcionario;