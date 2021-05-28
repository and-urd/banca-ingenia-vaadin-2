
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
INSERT INTO usuarios (direccion,email,password,telefono,username, active) VALUES
	 ('Calle Falsa 123 Malaga','rafa@email.com','{noop}password','654123987','admin', 0),
	 ('Calle Loquesea 268 Malaga','andres@email.com','{noop}password','665165187','operator', 0),
	 ('Calle Flores 2 Malaga','joaquin@email.com','{noop}1234','665342211','andres', 0);


-- CUENTAS-USUARIOS --
INSERT INTO cuentas_users (cuenta_id,user_id) VALUES
	 (1,1),
	 (1,2),
	 (2,3),
	 (3,3);

-- TARJETAS --
INSERT INTO tarjetas (cvv,fecha_caducidad,limite_maximo,numero_tarjeta,tipo_tarjeta,id_cuenta) VALUES
	 (356,'2022-05-16',500.0,'15165165','Débito',1),
	 (586,'2022-05-13',300.0,'56161665','Débito',1),
	 (834,'2022-03-03',500.0,'23432433','Crédito',2),
	 (443,'2022-01-29',500.0,'89789873','Débito',3),
	 (220,'2022-03-10',600.0,'43027100','Crédito',5),
	 (117,'2022-11-24',1000.0,'21210741','Débito',3),
	 (205,'2022-11-04',600.0,'67302742','Crédito',2),
	 (992,'2022-10-02',500.0,'74210723','Débito',4),
	 (992,'2022-10-02',500.0,'94270041','Débito',4);

-- MOVIMIENTOS --
	 INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
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
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
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
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
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
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
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
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
     	 (-200.0,'Mediamarkt','2021-07-24','2021-07-24','21210741',2400.0,6,3),
     	 (-50.0,'Movistar','2021-07-25','2021-07-25','89789873',2350.0,8,3),
     	 (-50.0,'Carrefour','2021-07-26','2021-07-26','89789873',2300.0,9,3),
     	 (-50.0,'Movistar','2021-07-27','2021-07-27','21210741',2250.0,7,3),
     	 (-50.0,'Mercadona','2021-07-28','2021-07-28','89789873',2200.0,5,3),
     	 (-50.0,'El Corte Ingles','2021-07-29','2021-07-29','21210741',2150.0,3,3),
     	 (1050.0,'Nómina','2021-07-30','2021-07-30','',3200.0,7,3),
     	 (-50.0,'Hotel Florida','2021-08-01','2021-08-01','21210741',3150.0,4,3),
     	 (-50.0,'Repsol','2021-08-02','2021-08-02','89789873',3100.0,2,3),
     	 (-50.0,'Mediamarkt','2021-08-03','2021-08-03','21210741',3050.0,9,3);
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
     	 (-50.0,'Emasa Agua','2021-08-04','2021-08-04','89789873',3000.0,8,3),
     	 (-50.0,'Restaurante Paca','2021-08-05','2021-08-05','89789873',2950.0,1,3),
     	 (-50.0,'Dentista','2021-08-06','2021-08-06','21210741',2900.0,7,3),
     	 (-50.0,'ITV','2021-08-07','2021-08-07','89789873',2850.0,7,3),
     	 (-50.0,'Repsol','2021-07-23','2021-07-23','74210723',2800.0,2,4),
     	 (-200.0,'Mediamarkt','2021-07-24','2021-07-24','94270041',2600.0,6,4),
     	 (-50.0,'Movistar','2021-07-25','2021-07-25','74210723',2550.0,8,4),
     	 (-50.0,'Carrefour','2021-07-26','2021-07-26','94270041',2500.0,9,4),
     	 (100.0,'Ingreso','2021-07-27','2021-07-27','',2600.0,7,4),
     	 (-50.0,'Mercadona','2021-07-28','2021-07-28','74210723',2550.0,5,4);
     INSERT INTO training2.movimientos (cantidad,concepto,fecha_operacion,fecha_valor,num_tarjeta,saldo_actual,id_categoria,id_cuenta) VALUES
     	 (-50.0,'El Corte Ingles','2021-07-29','2021-07-29','94270041',2500.0,3,4),
     	 (-50.0,'Hotel Florida','2021-08-01','2021-08-01','74210723',2450.0,4,4),
     	 (50.0,'Ingreso','2021-08-02','2021-08-02','',2500.0,2,4),
     	 (-50.0,'Mediamarkt','2021-08-03','2021-08-03','74210723',2450.0,9,4),
     	 (-50.0,'Emasa Agua','2021-08-04','2021-08-04','94270041',2400.0,8,4),
     	 (-50.0,'Restaurante Paca','2021-08-05','2021-08-05','94270041',2350.0,1,4),
     	 (150.0,'Ingreso','2021-08-06','2021-08-06','',2200.0,7,4),
     	 (-50.0,'ITV','2021-08-07','2021-08-07','94270041',2150.0,7,4);

