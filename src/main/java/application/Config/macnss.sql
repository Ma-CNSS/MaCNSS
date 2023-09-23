DROP DATABASE IF EXISTS macnss;

CREATE DATABASE macnss;

\c macnss;

CREATE TYPE Status AS ENUM ('in-progress', 'approved', 'declined');
CREATE TYPE Type AS ENUM ('medical', 'optic', 'estetic');

CREATE TABLE admins (
                        id serial primary key,
                        first_name varchar(50) not null,
                        last_name varchar(50) not null,
                        email varchar(50) unique not null,
                        password varchar(50) not null
);
CREATE TABLE agents (
                        id serial primary key,
                        first_name varchar(50) not null,
                        last_name varchar(50) not null,
                        email varchar(50) unique not null,
                        password varchar(50) not null
);

CREATE TABLE doctypes (
                          id serial primary key,
                          name varchar(50) not null,
                          refundRate int not null
);

CREATE TABLE documents (
                           id serial primary key,
                           price float not null,
                           doctype int references doctypes(id)
);

CREATE TABLE categories (
                            id serial primary key,
                            name varchar(50) not null
);

CREATE TABLE medicins (
                          id serial primary key,
                          name varchar(50) not null,
                          doz varchar(50) not null,
                          dozunit varchar(50) not null,
                          form text not null,
                          presentation text not null,
                          ppv float not null,
                          ph float not null,
                          price float not null,
                          pg char not null,
                          category int references categories(id)
);

CREATE TABLE patients (
                          id serial primary key,
                          cin varchar(20) not null,
                          name varchar(50) not null,
                          email varchar(50) unique not null
);

CREATE TABLE cases (
                       id serial primary key,
                       price float not null,
                       type Type not null,
                       status Status not null,
                       patient int references patients(id)
);