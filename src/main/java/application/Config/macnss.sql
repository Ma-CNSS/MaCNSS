DROP DATABASE IF EXISTS macnss;

CREATE DATABASE macnss;

\c macnss;

CREATE TYPE Status AS ENUM ('INPROGRESS', 'APPROVED', 'DECLINED');
CREATE TYPE Type AS ENUM ('mMEDICAL', 'OPTIC', 'AESTHETIC');

CREATE TABLE admins (
                        Id serial primary key,
                        FirstName varchar(50) not null,
                        LastName varchar(50) not null,
                        Email varchar(50) unique not null,
                        Password varchar(50) not null
);
CREATE TABLE agents (
                        Id serial primary key,
                        FirstName varchar(50) not null,
                        LastName varchar(50) not null,
                        Email varchar(50) unique not null,
                        Password varchar(50) not null
);

CREATE TABLE doctypes (
                          Id serial primary key,
                          Name varchar(50) not null,
                          RefundRate int not null
);

CREATE TABLE documents (
                           Id serial primary key,
                           Price float not null,
                           DocType int references doctypes(id)
);

CREATE TABLE categories (
                            Id serial primary key,
                            Name varchar(50) not null
);

CREATE TABLE medicins (
                          Id serial primary key,
                          Name varchar(50) not null,
                          Doz varchar(50) not null,
                          DozUnit varchar(50) not null,
                          Form text not null,
                          Presentation text not null,
                          PPV float not null,
                          PH float not null,
                          Price float not null,
                          PG char not null,
                          Category int references categories(id)
);

CREATE TABLE patients (
                          Id serial primary key,
                          CIN varchar(20) not null,
                          Name varchar(50) not null,
                          Email varchar(50) unique not null
);

CREATE TABLE cases (
                       Id serial primary key,
                       Price float not null,
                       Type Type not null,
                       Status Status not null,
                       Patient int references patients(id)
);