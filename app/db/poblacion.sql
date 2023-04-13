INSERT INTO Direcciones VALUES (1, 'Miguel Delibes', 3, NULL, 47, 'Simancas', 'Valladolid');
INSERT INTO Direcciones VALUES (2, 'Rosalia de Castro', 15, NULL, 47, 'Simancas', 'Valladolid');
INSERT INTO Direcciones VALUES (3, 'Villabanez', 12, '1 Izq', 47, 'Pajarillos', 'Valladolid');
INSERT INTO Direcciones VALUES (4, 'Paseo del Cauce', 45, '2 B', 47, 'Valladolid', 'Valladolid');
INSERT INTO Direcciones VALUES (5, 'Avenida Giron', 33, NULL, 47, 'Giron, Valladolid', 'Valladolid');
INSERT INTO Direcciones VALUES (6, 'Miguel Iscar', 5, NULL, 30, 'Simancas', 'Valladolid');
INSERT INTO Direcciones VALUES (7, 'Rosalia', 12, NULL, 20, 'Valladolid', 'Valladolid');
INSERT INTO Direcciones VALUES (8, 'Villabanez', 12, '1 Izq', 47, 'Pajarillos', 'Valladolid');
INSERT INTO Direcciones VALUES (9, 'Nueva del Carmen', 45, '2 B', 47, 'Valladolid', 'Valladolid');
INSERT INTO Direcciones VALUES (10, 'Avenida Nueva', 30, NULL, 45, 'Giron, Valladolid', 'Valladolid');

INSERT INTO Destinos VALUES(1, '983268399', 2);
INSERT INTO Destinos VALUES(2, '983392444', 5);
INSERT INTO Destinos VALUES(3, '983275050', 3);
INSERT INTO Destinos VALUES(4, '983346416', 1);
INSERT INTO Destinos VALUES(5, '983473979', 3);

INSERT INTO Usuarios VALUES('14234567B', 'Sergio', 'Perez Perez', '12345', 'sergiovillazul@yahoo.com', '644343536');
INSERT INTO Usuarios VALUES('33299567X', 'Pablo', 'Pereda Yanez', '12345', 'ppereday@gmail.com', '644343537');
INSERT INTO Usuarios VALUES('44232567J', 'Juan', 'Toribio Vazquez', '12345', 'juan.toribio.vazquez@gmail.com', '644343538');
INSERT INTO Usuarios VALUES('54256567A', 'Juan Antonio', 'Pulido Sanz', '12345', 'ja.pulidosanz@hotmail.com', '644343539');
INSERT INTO Usuarios VALUES('77032567T', 'Hector', 'Martin Viloria', '12345', 'hectormartin2001@gmail.com', '644343530');

INSERT INTO Empleados VALUES ('14234567B', '123456789123', 'ES1234567890123456789000', '2012-05-13', 7, 1);
INSERT INTO Empleados VALUES ('33299567X', '123456789124', 'ES1234567890123456789001', '2014-06-03', 6, 2);
INSERT INTO Empleados VALUES ('44232567J', '123456789125', 'ES1234567890123456789002', '2012-05-13', 10, 2);
INSERT INTO Empleados VALUES ('54256567A', '123456789126', 'ES1234567890123456789003', '2014-06-03', 8, 4);
INSERT INTO Empleados VALUES ('77032567T', '123456789127', 'ES1234567890123456789004', '2017-01-20', 9, 5);

INSERT INTO RolesEnEmpresa VALUES('2012-05-13', '14234567B', 1);
INSERT INTO RolesEnEmpresa VALUES('2014-06-03', '33299567X', 5);
INSERT INTO RolesEnEmpresa VALUES('2012-05-13', '44232567J', 3);
INSERT INTO RolesEnEmpresa VALUES('2014-06-03', '54256567A', 5);
INSERT INTO RolesEnEmpresa VALUES('2017-01-20', '77032567T', 2);

INSERT INTO VinculacionesConLaEmpresa VALUES('2012-05-13', '14234567B', 1);
INSERT INTO VinculacionesConLaEmpresa VALUES('2014-06-03', '33299567X', 1);
INSERT INTO VinculacionesConLaEmpresa VALUES('2012-05-13', '44232567J', 1);
INSERT INTO VinculacionesConLaEmpresa VALUES('2014-06-03', '54256567A', 3);
INSERT INTO VinculacionesConLaEmpresa VALUES('2017-01-20', '77032567T', 3);

INSERT INTO Disponibilidades VALUES('2012-05-13', '2022-12-31', '14234567B', 3);
INSERT INTO Disponibilidades VALUES('2014-06-03', '2022-12-31', '33299567X', 3);
INSERT INTO Disponibilidades VALUES('2012-05-13', '2022-12-31', '44232567J', 3);
INSERT INTO Disponibilidades VALUES('2014-06-03', '2022-12-31', '54256567A', 2);
INSERT INTO Disponibilidades VALUES('2017-01-20', '2022-12-31', '77032567T', 2);

INSERT INTO Oficinas VALUES(1, 'Color verde');
INSERT INTO Oficinas VALUES(2, 'Color azul');

INSERT INTO Almacenes VALUES(3, 100);

INSERT INTO Tiendas VALUES(1, 'BlueManzanaShop1');
INSERT INTO Tiendas VALUES(2, 'BlueManzanaShop2');
INSERT INTO Tiendas VALUES(3, 'BlueManzanaShop3');
INSERT INTO Tiendas VALUES(4, 'BlueManzanaShop4');
INSERT INTO Tiendas VALUES(5, 'BlueManzanaShop5');

INSERT INTO Categorias VALUES(1, 'Jugueteria');
INSERT INTO Categorias VALUES(2, 'Moda');
INSERT INTO Categorias VALUES(3, 'Mueble');
INSERT INTO Categorias VALUES(4, 'Hardware');
INSERT INTO Categorias VALUES(5, 'Software');

INSERT INTO Productos VALUES(1, 'Nintendo', 399.99, '2001-01-01', 1);
INSERT INTO Productos VALUES(2, 'Camiseta', 9.99, '2001-01-01', 2);
INSERT INTO Productos VALUES(3, 'Mesa de salon', 29.99, '2001-01-01', 3);
INSERT INTO Productos VALUES(4, 'Ordenador Lenovo', 599.99, '2001-01-01', 4);
INSERT INTO Productos VALUES(5, 'Sistema OP Windows 10', 11.99, '2001-01-01', 5);

INSERT INTO ExistenciasEnTiendas VALUES(10, 1, 1);
INSERT INTO ExistenciasEnTiendas VALUES(100, 2, 2);
INSERT INTO ExistenciasEnTiendas VALUES(10, 3, 3);
INSERT INTO ExistenciasEnTiendas VALUES(10, 4, 4);
INSERT INTO ExistenciasEnTiendas VALUES(100, 5, 5);

INSERT INTO RegistroDeEntregas VALUES(1, '2022-01-01', '14:30:00', '12345678A');
INSERT INTO RegistroDeEntregas VALUES(2, '2022-01-01', '14:00:00', '12345678B');
INSERT INTO RegistroDeEntregas VALUES(3, '2022-01-01', '15:00:00', '12345678C');
INSERT INTO RegistroDeEntregas VALUES(4, '2022-01-01', '15:30:00', '12345678D');
INSERT INTO RegistroDeEntregas VALUES(5, '2022-01-01', '16:00:00', '12345678E');

INSERT INTO PreparacionPedidos VALUES(3, '2021-12-01', '14234567B', 3, 3);
INSERT INTO PreparacionPedidos VALUES(4, '2021-12-01', '14234567B', 3, 4);
INSERT INTO PreparacionPedidos VALUES(5, '2021-12-01', '14234567B', 3, 5);

INSERT INTO PedidosDeSuministroDeProducto VALUES(1, 2, '2021-11-01', 2, 1, 5, 3);
INSERT INTO PedidosDeSuministroDeProducto VALUES(2, 3, '2021-11-01', 2, 2, 4, 4);
INSERT INTO PedidosDeSuministroDeProducto VALUES(3, 4, '2021-11-01', 2, 3, 4, 5);
INSERT INTO PedidosDeSuministroDeProducto VALUES(4, 5, '2021-11-01', 5, 4, 5, 3);
