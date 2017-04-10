--set autocommit off
alter session set nls_date_format='dd/MM/yyyy';

insert into typeCompte Values ('Expert');
insert into typeCompte Values ('Admin');

insert into CompteUtilisateur Values (42,'balek', 'Expert'); 

insert into Cirque Values ( 75, 'Cirque Zabatta');
insert into Cirque Values ( 4, 'Cirque politique');
insert into Cirque values (3,'AfroCircus');

Insert into Artiste Values (42, 75, 'Le clown', 'Bozo', '09/04/1995', '677 rue du président Coty');
Insert into Artiste Values (45, 4, 'Fillon', 'François', '19/04/1242', 'Chez Yvonne');
Insert into Artiste Values (46, 4, 'Sarkozy', 'Nicolas', '01/01/0001', 'Chez mami Bettencourt');
Insert into Artiste Values (47, 4, 'Poutou', 'Philippe', '04/02/1975', 'À l usine');

Insert into ArtisteExpert Values (47, '1');
insert into ArtisteExpert values (1, '06');
insert into ArtisteExpert values (2, '07');
insert into ArtisteExpert values (3, '08');
insert into ArtisteExpert values (4, '09');

Insert into ArtisteParticipant Values (46);

Insert into ArtistePrincipal Values (46, '+33657846910');
-- Et là c'est le drame
--Insert into ArtistePrincipal Values (45, 'BUG');
insert into Theme values ('Clown');
Insert into jury values (1, 25);
Insert into Festival values (75, 1);
Insert into spectacle values (4, '06/04/1347', 14, 16, 500, 42, 'Clown', 75);

Insert into Numero values (15, 'Numero2', 'Titre numéro pas trop long', 20, 5, 'true', 46,'Clown');
insert into Numero values (1,'Trapèzes','Bah on fait du trapèze pélo',30,3,'false',38,'Acrobatie');
insert into Numero values (2, 'Lions', 'cerceaux de feu', 25, 1, 'false', 37, 'Dressage');
insert into Numero values (3, 'ours', 'blah blah', 27, 1, 'false', 36, 'Dressage');
insert into Numero values (4, 'funambule', 'du lourd', 22, 1, 'false',35, 'Acrobatie');

Insert into EstExpertEn values (47, 'Clown');

Insert into Evaluation values (47, 15, 'commentaire constructif', 7);

insert into Evaluation values (1, 1, 'fou', 5);
insert into Evaluation values (2, 1, 'ouf', 8);
insert into Evaluation values (3, 1, 'excellent', 10);
insert into Evaluation values (4, 1, 'oui', 8);

insert into Evaluation values (1, 2, 'fou', 0);
insert into Evaluation values (2, 2, 'ouf', 5);
insert into Evaluation values (3, 2, 'excellent', 10);
insert into Evaluation values (4, 2, 'oui', 5);

insert into Evaluation values (1, 3, 'fou', 5);
insert into Evaluation values (2, 3, 'ouf', 8);
insert into Evaluation values (3, 3, 'excellent', 10);
insert into Evaluation values (4, 3, 'oui', 8);

insert into Evaluation values (1, 4, 'fou', 2);
insert into Evaluation values (2, 4, 'ouf', 4);
insert into Evaluation values (3, 4, 'excellent', 5);
insert into Evaluation values (4, 4, 'oui', 3);
