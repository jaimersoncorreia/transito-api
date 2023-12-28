create sequence sq_proprietario start 1 increment 1;

create table proprietario
(
    id       bigint       not null default nextval('sq_proprietario'),
    nome     varchar(255) not null,
    email    varchar(255) not null,
    telefone varchar(20)  not null
);

alter table proprietario
    add constraint pk_proprietario primary key (id),
    add constraint uk_proprietario unique (email);