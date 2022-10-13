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
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('100g', 'Aspirina');
insert into medicamento(contenido_medicamento, nombre_medicamento)
values('20g', 'Aspirina 2');

select * from medicamento;
select * from cliente;

select * from cliente_medicamento;
select * from cliente_medicamento inner join cliente on cliente.id_cliente = cliente_medicamento.id_cliente where nombre_cliente = 'Berenice';

insert into cliente_medicamento(id_cliente, id_medicamento) values(2, 1);

describe cliente_medicamento;
describe medicamento;
select * from cliente_medicamento;

select * from usuario;
insert into usuario(clave_usuario, correo_usuario, nombre_usuario, id_cliente) values("123", "fubdsi", "fbkds", 3);
select u.* from Usuario u where (u.nombre_usuario = "fbkds" and clave_usuario = "123") or (u.correo_usuario = "fubdsi" and clave_usuario = "4343");

select * from usuario;

SET SQL_SAFE_UPDATES = 0;
select u.* from Usuario u where (u.nombre_usuario = '' or u.correo_usuario = 'yufvd');

select cm.* from cliente_medicamento cm where cm.hora_medicacion = "10:31";

select * from cliente_medicamento;


select cm.id_cliente_medicamento, cm.completado_medicamento, cm.fecha_medicacion, cm.hora_medicacion, m.nombre_medicamento, cm.id_cliente FROM cliente_medicamento cm INNER JOIN medicamento m ON m.id_medicamento = cm.id_medicamento where cm.id_cliente = 1;


select cm.id_cliente_medicamento as id_cliente_medicamento, cm.completado_medicamento as completado_medicamento, cm.fecha_medicacion as fecha_medicacion, cm.hora_medicacion as hora_medicacion, m.nombre_medicamento as nombre_medicamento, cm.id_cliente as id_cliente FROM cliente_medicamento cm INNER JOIN medicamento m ON m.id_medicamento = cm.id_medicamento where cm.id_cliente = 2;



