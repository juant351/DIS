-- Reset database
--Derby does not support DROP TABLE IF EXISTS 
DROP TABLE DISPONIBILIDADES;
DROP TABLE VINCULACIONESCONLAEMPRESA;
DROP TABLE ROLESENEMPRESA;
DROP TABLE TIPOSDEDISPONIBILIDAD;
DROP TABLE TIPOSDEVINCULACION;
DROP TABLE TIPOSDEROL;
DROP TABLE PEDIDOSDESUMINISTRODEPRODUCTO;
DROP TABLE ESTADOSPEDIDO;
DROP TABLE PREPARACIONPEDIDOS;
DROP TABLE REGISTRODEENTREGAS;
DROP TABLE EXISTENCIASENTIENDAS;
DROP TABLE PRODUCTOS;
DROP TABLE CATEGORIAS;
DROP TABLE OFICINAS;
DROP TABLE TIENDAS;
DROP TABLE ALMACENES;
DROP TABLE EMPLEADOS;
DROP TABLE USUARIOS;
DROP TABLE DESTINOS;
DROP TABLE DIRECCIONES;

-- Enum
create table TIPOSDEROL
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPOSDEROL
VALUES  (1,'GestorMarca'),
        (2,'RecursosHumanos'),
        (3,'EncargadoLogistica'),
        (4,'EncargadoAlmacen'),
        (5,'EncargadoTienda'),
        (6,'EmpleadoAlmacen'),
        (7,'EmpleadoTienda');

-- Enum
create table TIPOSDEVINCULACION
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)

);

INSERT INTO TIPOSDEVINCULACION
VALUES  (1,'Contratado'),
        (2,'Despedido'),
        (3,'EnERTE');

-- Enum
create table TIPOSDEDISPONIBILIDAD
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPOSDEDISPONIBILIDAD
VALUES  (1,'Vacaciones'),
        (2,'BajaTemporal'),
	(3, 'Trabajando');


-- Datatype
create table DIRECCIONES
(
	Id SMALLINT not null,
	Calle VARCHAR(20) not null,
	Numero SMALLINT,
	Otros VARCHAR(20),
	CodigoPostal SMALLINT not null,
	Localidad VARCHAR(20) not null,
	Provincia VARCHAR(20) not null,
		PRIMARY KEY(Id)
);

create table DESTINOS
(
	Id SMALLINT not null primary key,
	Telefono VARCHAR(12) not null,
	Direccion SMALLINT not null,
		FOREIGN KEY(Direccion) REFERENCES DIRECCIONES(Id)
);

create table USUARIOS
(
	Nif VARCHAR(9) not null primary key,
	Nombre VARCHAR(20) not null,
	Apellidos VARCHAR(30) not null,
	Password VARCHAR(15) not null,
	Email VARCHAR(100) not null,
	Telefono VARCHAR(12) not null
);

create table EMPLEADOS
(
	Nif VARCHAR(9) not null primary key,
	NumeroSeguridadSocial VARCHAR(12) not null,
	Iban VARCHAR(24) not null,
	FechaInicioEnEmpresa DATE not null,
	DireccionPostal SMALLINT not null,
	DestinadoEn SMALLINT not null,
            FOREIGN KEY(Nif) REFERENCES USUARIOS(Nif),
            FOREIGN KEY(DireccionPostal) REFERENCES DIRECCIONES(Id),
            FOREIGN KEY(DestinadoEn) REFERENCES DESTINOS(Id)
);

-- Association
create table ROLESENEMPRESA
(
	ComienzoEnRol DATE not null,
	Empleado VARCHAR(9) not null,
	Rol SMALLINT not null,
            FOREIGN KEY(Empleado) REFERENCES EMPLEADOS(Nif),
            FOREIGN KEY(Rol) REFERENCES TIPOSDEROL(IdTipo)
);

-- Association
create table VINCULACIONESCONLAEMPRESA
(
	inicio DATE not null,
	Empleado VARCHAR(9) not null,
	Vinculo SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADOS(Nif),
		FOREIGN KEY(Vinculo) REFERENCES TIPOSDEVINCULACION(IdTipo) 
);

-- Association
create table DISPONIBILIDADES
(
	Comienzo DATE not null,
	FinalPrevisto DATE,
	Empleado VARCHAR(9) not null,
	Disponibilidad SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADOS(Nif),
		FOREIGN KEY(Disponibilidad) REFERENCES TIPOSDEDISPONIBILIDAD(IdTipo)
);

create table OFICINAS
(
	Id SMALLINT not null primary key,
	OtrasIndicacionesDeZona VARCHAR(20) not null,
		FOREIGN KEY(Id) REFERENCES DESTINOS(Id)
);

create table ALMACENES
(
	Id SMALLINT not null primary key,
	Superficie SMALLINT not null,
		FOREIGN KEY(Id) REFERENCES DESTINOS(Id)
);

create table TIENDAS
(
	Id SMALLINT not null primary key,
	NombreIdentificativo VARCHAR(50) not null,
		FOREIGN KEY(Id) REFERENCES DESTINOS(Id)
);

create table CATEGORIAS
(
	Id SMALLINT not null primary key,
	Nombre VARCHAR(50)
);

create table PRODUCTOS
(
	Id SMALLINT not null primary key,
	Nombre VARCHAR(30) not null unique,
	Precio REAL not null,
	FechaDeCreacion DATE not null,
	Categoria SMALLINT not null,
		FOREIGN KEY(Categoria) REFERENCES CATEGORIAS(Id)
);

-- Association
create table EXISTENCIASENTIENDAS
(
	Cantidad SMALLINT not null,
	EnTienda SMALLINT not null,
	Producto SMALLINT not null,
		PRIMARY KEY(EnTienda,Producto),
		FOREIGN KEY(EnTienda) REFERENCES TIENDAS(Id),
		FOREIGN KEY(Producto) REFERENCES PRODUCTOS(Id)
);

-- Enum
create table ESTADOSPEDIDO
(
	IdEstado SMALLINT not null primary key,
	NombreEstado VARCHAR(20) not null unique
);

INSERT INTO ESTADOSPEDIDO
VALUES  (1,'Pendiente'),
        (2,'Confirmado'),
        (3,'Preparado'),
        (4,'Enviado'),
        (5,'En reparto'),
        (6,'Entregado'),
        (7,'Reclamado');

-- Transactions
create table REGISTRODEENTREGAS
(
	Id SMALLINT not null primary key,
	Fecha DATE not null,
	Hora TIME not null,
	DniQuienFirma VARCHAR(9) not null
);

create table PREPARACIONPEDIDOS
(
	Id SMALLINT not null primary key,
	FechaPreparacion DATE not null,
	PreparadoPor VARCHAR(9) not null,
	AlmacenDondeSePrepara SMALLINT not null,
	RegistroDeEntrega SMALLINT,
		FOREIGN KEY(PreparadoPor) REFERENCES EMPLEADOS(nif),
		FOREIGN KEY(AlmacenDondeSePrepara) REFERENCES ALMACENES(Id),
		FOREIGN KEY(RegistroDeEntrega) REFERENCES REGISTRODEENTREGAS(Id)
);


create table PEDIDOSDESUMINISTRODEPRODUCTO
( 
	Id SMALLINT not null primary key,
	Cantidad SMALLINT,
	Fecha DATE not null,
	Estado SMALLINT not null,
	Producto SMALLINT not null,
	SolicitadoEn SMALLINT not null,
	Preparacion SMALLINT,
        	FOREIGN KEY(SolicitadoEn) REFERENCES TIENDAS(Id),
		FOREIGN KEY(Producto) REFERENCES PRODUCTOS(Id),
		FOREIGN KEY(Estado) REFERENCES ESTADOSPEDIDO(IdEstado),
		FOREIGN KEY(Preparacion) REFERENCES PREPARACIONPEDIDOS(Id)
);
