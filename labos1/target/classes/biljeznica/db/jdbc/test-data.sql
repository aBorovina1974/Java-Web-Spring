INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Ivo','Ivi�','iivic','password', true);
INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Marko','Marki�','mmarkic','password', true);
INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Pero','Peri�','pperic','password', true);
INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Adminko','Admini�','admin','password', true);
INSERT INTO user_role (username, role)
VALUES ('iivic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('mmarkic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('pperic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO biljeznica(naziv, opis)
VALUES('Web aplikacije u Javi', 'Bilje�ke s predavanja iz kolegija web aplikacije u
Javi');
INSERT INTO biljeznica(naziv, opis)
VALUES('Razvoj aplikacija na Android platformi', 'Bilje�ke s predavanja kolegija razvoj
aplikacija na Android platformi');
INSERT INTO biljeznica(naziv, opis)
VALUES('Napredne teme ra�unalnih mre�a', 'Bilje�ke s predavanja napredne teme
ra�unalnih mre�a');
INSERT INTO biljeska(naslov, tekst, korisnik, biljeznica)
VALUES('Testni naslov', 'Testni tekst', 'iivic', 'Web aplikacije u Javi');