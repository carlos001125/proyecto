Create database control_medicamentos;

use control_medicamentos;

show tables;

drop database control_medicamentos;

describe cliente;

insert into cliente(apellido_materno_cliente, apellido_paterno_cliente, edad_cliente, nombre_cliente)
values("Garcia", "Robles", 25, "Evelyn");

insert into cliente(apellido_materno_cliente, apellido_paterno_cliente, edad_cliente, nombre_cliente)
values("Garciaa", "Roes", 67, "Berenice");

insert into cliente(apellido_materno_cliente, apellido_paterno_cliente, edad_cliente, nombre_cliente)
values("Garciaaa", "Rles", 23, "Fernando");

insert into cliente(apellido_materno_cliente, apellido_paterno_cliente, edad_cliente, nombre_cliente)
values("Garciaaaa", "Rob", 12, "Javier");


describe medicamento;

insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 1');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 2');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 3');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 4');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 5');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('200g', 'Med 6');

select * from medicamento;
select * from cliente;

select * from cliente_medicamento;

insert into cliente_medicamento(id_cliente, id_medicamento) values(2, 1);

describe cliente_medicamento;
describe medicamento;

select c.nombre_cliente, m.nombre_medicamento, m.contenido_medicamento
	from Cliente c inner join cliente_medicamento mc on c.id_cliente = mc.id_cliente 
				   inner join medicamento m on m.id_medicamento = mc.id_medicamento where c.id_cliente = 2;


select
        medicament0_.id_medicamento as id_medic1_2_,
        medicament0_.contenido_medicamento as contenid2_2_,
        medicament0_.nombre_medicamento as nombre_m3_2_ 
    from
        medicamento medicament0_ 
    inner join
        cliente_medicamento clientes1_ 
            on medicament0_.id_medicamento=clientes1_.id_medicamento 
    inner join
        cliente cliente2_ 
            on clientes1_.id_cliente=cliente2_.id_cliente 
    where
        id_cliente=2
