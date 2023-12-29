create sequence sq_veiculo start 1 increment 1;

create table veiculo
(
    id              bigint      not null default nextval('sq_veiculo'),
    proprietario_id bigint      not null,
    marca           varchar(20) not null,
    modelo          varchar(20) not null,
    placa           varchar(7)  not null,
    status          varchar(20) not null,
    data_cadastro   timestamp   not null,
    data_apreensao  timestamp
);

alter table veiculo
    add constraint pk_veiculo primary key (id),
    add constraint fk_veiculo_proprietario foreign key (proprietario_id) references proprietario (id),
    add constraint uk_veiculo unique (placa)
;
