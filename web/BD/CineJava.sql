create database cine;

use cine;

create table Usuario(
pkUsuario int primary key auto_increment,
clave varchar(30),
cuenta varchar(30),
nombre varchar(30),
apPaterno varchar(30),
apMaterno varchar(30),
dni varchar(8),
correo varchar(30)) CHARSET=utf8;

insert into Usuario values(1,'1234','admin','Oscar','Quinones','Verastegui','73060476','abc@gmail.com');
insert into Usuario values(2,'1111','nsp','Paul','Lluque','Delgado','11223344','xyz@gmail.com');
insert into Usuario values(3,'1111','usuario','Edinson','Molina','Zea','55223344','mmm@gmail.com');
insert into Usuario values(4,'1211','user','Omar','Alejandro','Galvan','56223344','nnn@gmail.com');
------------------------------------------------------------------------------------------------

create table Pelicula(
pkPelicula int PRIMARY KEY auto_increment,
nombre varchar(60),
calificacion varchar(20),
duracion varchar(10),
synopsis varchar(140),
url varchar(100),
genero varchar(30)) CHARSET=utf8;

insert into Pelicula values(1,'La casa del fin de los tiempo','r','013700','Narra la historia de Dulce (Ruddy Rodríguez), una madre de familia que tiene encuentros con apariciones dentro de su vieja casa','n4A63pjNDXI','terror');
insert into Pelicula values(2,'The Hunger Games: Mockingjay - Part 1','a','020300','Katniss Everdeen sin quererlo se convierte en el símbolo de la rebelión de masas en contra del Capitolio.','7dCB2U9lX48','accion,aventura');
insert into Pelicula values(3,'Quiero Matar a mi Jefe 2','a','014800','Nick (Bateman), Dale (Day) y Kurt (Sudeikis) deciden lanzar su propio negocio. Pero un inversor muy listillo echa a perder sus planes.','gpXVSjCUw5I','comedia');
insert into Pelicula values(4,'Gloria del Pacífico','c','014000','Narra las acciones en la toma del morro de Arica','atimcSKKJxU','historico');
insert into Pelicula values(5,'Interestelar','b','024900','Narra las aventuras de un grupo de exploradores que hacen uso de un agujero de gusano recientemente descubierto','NVw3DnN9WoA','Ciencia Ficcion');

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table Horario(
pkHorario int PRIMARY KEY auto_increment,
hora varchar(10)
) CHARSET=utf8;

insert into Horario values(1,'3:00');
insert into Horario values(2,'3:00');
insert into Horario values(3,'5:30');
insert into Horario values(4,'8:00');

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table Sala(
pkSala int PRIMARY KEY auto_increment,
nroSala int not null,
nroAsientos int not null
) CHARSET=utf8;

insert into Sala values(1,1,60);
insert into Sala values(2,2,100);
insert into Sala values(3,3,50);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table Funcion(
pkFuncion int PRIMARY KEY auto_increment,
fkPelicula int not null,
fkSala int not null,
fkHorario int not null,
FOREIGN KEY (fkPelicula) REFERENCES Pelicula (pkPelicula),
FOREIGN KEY (fkSala) REFERENCES Sala (pkSala),
FOREIGN KEY (fkHorario) REFERENCES Horario (pkHorario)) CHARSET=utf8;

insert into Funcion values(1,1,1,1);
insert into Funcion values(2,2,3,3);
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table Reserva(
pkReserva int PRIMARY KEY auto_increment,
fkUsuario int not null,
fkFuncion int not null,
fechareserva varchar(40),
monto double,
FOREIGN KEY (fkFuncion) REFERENCES Funcion (pkFuncion),
FOREIGN KEY (fkUsuario) REFERENCES Usuario (pkUsuario)) CHARSET=utf8;

insert into Reserva values (1,2,1,'11/12/14',125.0);
insert into Reserva values (2,2,1,'11/12/14',125.0);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
