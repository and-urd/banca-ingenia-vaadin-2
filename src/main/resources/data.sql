--
--
----CUENTAS
--INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo, entidad) VALUES (1, "23984238947", "Corriente", 2150, "BBVA");
--INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo, entidad) VALUES (2, "65165778947", "Pensiones", 1000, "BBVA");
--INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo, entidad) VALUES (3, "16116515947", "Pensiones", 2000, "CAIXA");
--
----USERS
--INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (1, "rafa", "rafa@email.com", "Calle Falsa 123 Malaga", "654123987");
--INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (2, "andres", "andres@email.com", "Calle Loquesea 268 Malaga", "665165187");
--INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (3, "joaquin", "joaquin@email.com", "Calle Flores 2 Malaga", "665342211");
--
----RELACIÓN CUENTAS-USERS
--INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 1);
--INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 2);
--INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (2, 3);
--INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (3, 3);
--
--
----TARJETAS
--INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (1, 356, "15165165", "2022-05-16", 500, "Debito", 1);
--INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (2, 586, "56161665", "2022-05-13", 300, "Debito", 1);
--INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (3, 834, "23432433", "2022-03-03" , 500 , "Credito", 2);
--INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (4, 443, "89789873", "2022-01-29", 500, "Débito", 3);
--
--
--
----CATEGORIAS
--INSERT INTO categorias(id,tipo_categoria) VALUES (1, "Restaurantes");
--INSERT INTO categorias(id,tipo_categoria) VALUES (2, "Combustible");
--INSERT INTO categorias(id,tipo_categoria) VALUES (3, "Viajes");
--INSERT INTO categorias(id,tipo_categoria) VALUES (4, "Hoteles");
--INSERT INTO categorias(id,tipo_categoria) VALUES (5, "Compras");
--INSERT INTO categorias(id,tipo_categoria) VALUES (6, "Regalos");
--INSERT INTO categorias(id,tipo_categoria) VALUES (7, "Varios");
--INSERT INTO categorias(id,tipo_categoria) VALUES (8, "Domiciliacion");
--
--
----MOVIMIENTOS
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (1, "ingreso", "2021-05-1", "2021-05-1", 50, 50,"15165165", 1, 1);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (2, "ingreso", "2021-05-5", "2021-05-5", 50, 100,"15165165", 1, 1);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (3, "nomina", "2021-05-16", "2021-05-16", 1500, 1600,"", 1, 7);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (4, "Mercadona", "2021-05-20", "2021-05-20", -100, 1500,"", 1, 5);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (5, "Electricidad", "2021-05-20", "2021-05-20", -50, 1450,"", 1, 8);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (6, "Emasa Agua", "2021-05-21", "2021-05-21", -50, 1400,"", 1, 8);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (7, "Hotel Florida", "2021-05-22", "2021-05-22", -100, 1350,"15165165", 1, 4);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (8, "El corte ingles", "2021-05-23", "2021-05-23", -100, 1250,"", 1, 6);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (9, "Hotel Marina", "2021-05-22", "2021-05-22", -100, 1350,"56161665", 1, 4);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (10, "Repsol", "2021-05-23", "2021-05-23", -50, 1300,"56161665", 1, 2);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (11, "Mediamarkt", "2021-05-24", "2021-05-24", -200, 1050,"", 1, 6);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (12, "Movistar", "2021-05-25", "2021-05-25", -50, 1350,"", 1, 8);
--
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (13, "ingreso", "2021-06-1", "2021-06-1", 50, 1400,"15165165", 1, 1);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (14, "ingreso", "2021-06-5", "2021-06-5", 50, 1450,"15165165", 1, 1);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (15, "nomina", "2021-06-16", "2021-06-16", 1500, 2950,"", 1, 7);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (16, "Mercadona", "2021-06-20", "2021-06-20", -100, 2850,"", 1, 5);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (17, "Electricidad", "2021-06-20", "2021-06-20", -50, 2800,"", 1, 8);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (18, "Emasa Agua", "2021-06-21", "2021-06-21", -50, 2750,"", 1, 8);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (19, "Hotel Florida", "2021-06-22", "2021-06-22", -100, 2650,"15165165", 1, 4);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (20, "El corte ingles", "2021-06-23", "2021-06-23", -100, 2550,"", 1, 6);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (21, "Hotel Marina", "2021-06-22", "2021-06-22", -100, 2450,"15165165", 1, 4);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (22, "Repsol", "2021-06-23", "2021-06-23", -50, 2400,"15165165", 1, 2);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (23, "Mediamarkt", "2021-06-24", "2021-06-24", -200, 2200,"", 1, 6);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (24, "Movistar", "2021-06-25", "2021-06-25", -50, 2150,"", 1, 8);
--
--
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (25, "Repsol", "2021-07-23", "2021-07-23", -50, 2400,"23432433", 2, 2);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (26, "Mediamarkt", "2021-07-24", "2021-07-24", -200, 2200,"", 2, 6);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (27, "Movistar", "2021-07-25", "2021-07-25", -50, 2150,"", 2, 8);
--
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (28, "ingreso", "2021-08-1", "2021-08-1", 50, 1400,"89789873", 3, 1);
--INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (29, "ingreso", "2021-08-5", "2021-08-5", 50, 1450,"89789873", 3, 1);
--
--


-- NUEVOS DATOS ---

-- CATEGORIAS ---
INSERT INTO categorias (tipo_categoria) VALUES
	 ('Restaurantes'),
	 ('Combustible'),
	 ('Viajes'),
	 ('Hoteles'),
	 ('Compras'),
	 ('Regalos'),
	 ('Varios'),
	 ('Domiciliacion'),
	 ('Electrónica');

-- CUENTAS --
INSERT INTO cuentas (entidad,numero_cuenta,saldo,tipo_cuenta) VALUES
	 ('BBVA','23984238947',2150.0,'Corriente'),
	 ('BBVA','65165778947',1000.0,'Corriente'),
	 ('CAIXA','16116515947',2000.0,'Ahorro'),
	 ('BANCO SANTANDER','3047103742',10000.0,'Ahorro'),
	 ('UNICAJA','4901749274',12000.0,'Corriente');

-- USUARIOS --
INSERT INTO usuarios (direccion,email,password,telefono,username) VALUES
	 ('Calle Falsa 123 Malaga','rafa@email.com',NULL,'654123987','rafa'),
	 ('Calle Loquesea 268 Malaga','andres@email.com',NULL,'665165187','andres'),
	 ('Calle Flores 2 Malaga','joaquin@email.com',NULL,'665342211','joaquin');


-- CUENTAS-USUARIOS --
INSERT INTO cuentas_users (cuenta_id,user_id) VALUES
	 (1,1),
	 (1,2),
	 (2,3),
	 (3,3);

-- TARJETAS --
INSERT INTO tarjetas (cvv,fecha_caducidad,limite_maximo,numero_tarjeta,tipo_tarjeta,id_cuenta) VALUES
	 (356,'2022-05-16',500.0,'15165165','Debito',1),
	 (586,'2022-05-13',300.0,'56161665','Debito',1),
	 (834,'2022-03-03',500.0,'23432433','Credito',2),
	 (443,'2022-01-29',500.0,'89789873','Débito',3),
	 (220,'2022-03-10',600.0,'43027100','Crédito',5),
	 (117,'2022-11-24',1000.0,'21210741','Débito',3),
	 (205,'2022-11-04',600.0,'67302742','Crédito',2),
	 (992,'2022-10-02',500.0,'74210723','Débito',4);

-- CATEGORIAS --
INSERT INTO categorias (tipo_categoria) VALUES
	 ('Restaurantes'),
	 ('Combustible'),
	 ('Viajes'),
	 ('Hoteles'),
	 ('Compras'),
	 ('Regalos'),
	 ('Varios'),
	 ('Domiciliacion'),
	 ('Electrónica');

-- MOVIMIENTOS --
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (50.0,'ingreso','2021-05-01','2021-05-01','',50.0,1,1),
	 (50.0,'ingreso','2021-05-05','2021-05-05','',100.0,1,1),
	 (1500.0,'nomina','2021-05-16','2021-05-16','',1600.0,7,1),
	 (-100.0,'Mercadona','2021-05-20','2021-05-20','56161665',1500.0,5,1),
	 (-50.0,'Electricidad','2021-05-20','2021-05-20','56161665',1450.0,8,1),
	 (-50.0,'Emasa Agua','2021-05-21','2021-05-21','15165165',1400.0,8,1),
	 (-100.0,'Hotel Florida','2021-05-22','2021-05-22','15165165',1350.0,4,1),
	 (-100.0,'El corte ingles','2021-05-23','2021-05-23','15165165',1250.0,6,1),
	 (-100.0,'Hotel Marina','2021-05-22','2021-05-22','56161665',1350.0,4,1),
	 (-50.0,'Repsol','2021-05-23','2021-05-23','56161665',1300.0,2,1);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-200.0,'Mediamarkt','2021-05-24','2021-05-24','15165165',1050.0,6,1),
	 (-50.0,'Movistar','2021-05-25','2021-05-25','56161665',1350.0,8,1),
	 (50.0,'ingreso','2021-06-01','2021-06-01','',1400.0,1,1),
	 (50.0,'ingreso','2021-06-05','2021-06-05','',1450.0,1,1),
	 (1500.0,'nomina','2021-06-16','2021-06-16','',2950.0,7,1),
	 (-100.0,'Mercadona','2021-06-20','2021-06-20','56161665',2850.0,5,1),
	 (-50.0,'Electricidad','2021-06-20','2021-06-20','56161665',2800.0,8,1),
	 (-50.0,'Emasa Agua','2021-06-21','2021-06-21','15165165',2750.0,8,1),
	 (-100.0,'Hotel Florida','2021-06-22','2021-06-22','15165165',2650.0,4,1),
	 (-100.0,'El corte ingles','2021-06-23','2021-06-23','56161665',2550.0,6,1);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-100.0,'Hotel Marina','2021-06-22','2021-06-22','15165165',2450.0,4,1),
	 (-50.0,'Repsol','2021-06-23','2021-06-23','15165165',2400.0,2,1),
	 (-200.0,'Mediamarkt','2021-06-24','2021-06-24','56161665',2200.0,6,1),
	 (-50.0,'Movistar','2021-06-25','2021-06-25','56161665',2150.0,8,1),
	 (-50.0,'Repsol','2021-07-23','2021-07-23','23432433',2400.0,2,2),
	 (-200.0,'Mediamarkt','2021-07-24','2021-07-24','67302742',2200.0,6,2),
	 (-50.0,'Movistar','2021-07-25','2021-07-25','30432433',2150.0,8,2),
	 (-50.0,'Carrefour','2021-07-26','2021-07-26','67302742',2100.0,9,2),
	 (-50.0,'Movistar','2021-07-27','2021-07-27','67302742',2050.0,7,2),
	 (-50.0,'Mercadona','2021-07-28','2021-07-28','30432433',2000.0,5,2);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-50.0,'El Corte Ingles','2021-07-29','2021-07-29','67302742',1950.0,3,2),
	 (1050.0,'Nómina','2021-07-30','2021-07-30','',3000.0,7,2),
	 (-50.0,'Hotel Florida','2021-08-01','2021-08-01','67302742',2950.0,4,2),
	 (-50.0,'Repsol','2021-08-02','2021-08-02','67302742',2900.0,2,2),
	 (-50.0,'Mediamarkt','2021-08-03','2021-08-03','30432433',2850.0,9,2),
	 (-50.0,'Emasa Agua','2021-08-04','2021-08-04','67302742',2800.0,8,2),
	 (-50.0,'Restaurante Paca','2021-08-05','2021-08-05','30432433',2750.0,1,2),
	 (-50.0,'Dentista','2021-08-06','2021-08-06','30432433',2700.0,7,2),
	 (-50.0,'ITV','2021-08-07','2021-08-07','67302742',2650.0,7,2),
	 (-50.0,'Repsol','2021-07-23','2021-07-23','89789873',2600.0,2,3);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-200.0,'Mediamarkt','2021-07-24','2021-07-24','21210741',2400.0,6,3),
	 (-50.0,'Movistar','2021-07-25','2021-07-25','89789873',2350.0,8,3),
	 (-50.0,'Carrefour','2021-07-26','2021-07-26','89789873',2300.0,9,3),
	 (-50.0,'Movistar','2021-07-27','2021-07-27','21210741',2250.0,7,3),
	 (-50.0,'Mercadona','2021-07-28','2021-07-28','89789873',2200.0,5,3),
	 (-50.0,'El Corte Ingles','2021-07-29','2021-07-29','21210741',2150.0,3,3),
	 (1050.0,'Nómina','2021-07-30','2021-07-30',' ',3200.0,7,3),
	 (-50.0,'Hotel Florida','2021-08-01','2021-08-01','21210741',3150.0,4,3),
	 (-50.0,'Repsol','2021-08-02','2021-08-02','89789873',3100.0,2,3),
	 (-50.0,'Mediamarkt','2021-08-03','2021-08-03','21210741',3050.0,9,3);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-50.0,'Emasa Agua','2021-08-04','2021-08-04','89789873',3000.0,8,3),
	 (-50.0,'Restaurante Paca','2021-08-05','2021-08-05','89789873',2950.0,1,3),
	 (-50.0,'Dentista','2021-08-06','2021-08-06','21210741',2900.0,7,3),
	 (-50.0,'ITV','2021-08-07','2021-08-07','89789873',2850.0,7,3),
	 (-50.0,'Repsol','2021-07-23','2021-07-23','74210723',2800.0,2,4),
	 (-200.0,'Mediamarkt','2021-07-24','2021-07-24','74210723',2600.0,6,4),
	 (-50.0,'Movistar','2021-07-25','2021-07-25','74210723',2550.0,8,4),
	 (-50.0,'Carrefour','2021-07-26','2021-07-26','74210723',2500.0,9,4),
	 (-50.0,'Movistar','2021-07-27','2021-07-27','74210723',2450.0,7,4),
	 (-50.0,'Mercadona','2021-07-28','2021-07-28','74210723',2400.0,5,4);
INSERT INTO movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
	 (-50.0,'El Corte Ingles','2021-07-29','2021-07-29','74210723',2350.0,3,4),
	 (-50.0,'Hotel Florida','2021-08-01','2021-08-01','74210723',2300.0,4,4),
	 (-50.0,'Repsol','2021-08-02','2021-08-02','74210723',2250.0,2,4),
	 (-50.0,'Mediamarkt','2021-08-03','2021-08-03','74210723',2200.0,9,4),
	 (-50.0,'Emasa Agua','2021-08-04','2021-08-04','74210723',2150.0,8,4),
	 (-50.0,'Restaurante Paca','2021-08-05','2021-08-05','74210723',2100.0,1,4),
	 (-50.0,'Dentista','2021-08-06','2021-08-06','74210723',2050.0,7,4),
	 (-50.0,'ITV','2021-08-07','2021-08-07','74210723',2000.0,7,4);