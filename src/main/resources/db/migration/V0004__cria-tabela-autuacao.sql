create sequence sq_autuacao start 1 increment 1;

create table autuacao
(
    id              bigint         not null default nextval('sq_autuacao'),
    veiculo_id      bigint         not null,
    descricao       text           not null,
    valor_multa     decimal(10, 2) not null,
    data_ocorrencia timestamp      not null
);

alter table autuacao
    add constraint pk_autuacao primary key (id),
    add constraint fk_autuacao_veiculo foreign key (veiculo_id) references veiculo (id);