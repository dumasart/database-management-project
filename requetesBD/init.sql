
--set autocommit off
alter session set nls_date_format='dd/MM/yyyy';

insert into typeCompte Values ('Expert');
insert into typeCompte Values ('Admin');

insert into Cirque Values ( 75, 'Cirque Zabatta');
insert into Cirque Values ( 4, 'Cirque politique');
insert into Cirque values (3,'AfroCircus');
insert into Cirque values (1,'La ferme des animaux');
insert into Cirque values (2,'Pinder');

insert into Artiste values (1, 1, 'valjean', 'jean', '12/01/1987', 'bretagne sud revolutionnaire');
insert into Artiste values (2, 2, 'hugo', 'victor', '12/02/1987', 'bretagne sud libre');
insert into Artiste values (3, 3, 'poutine', 'vladimir', '12/05/1977', 'russie pour tous');
insert into Artiste values (4, 1, 'grey', 'jean', '06/08/1987', 'dans la foret');
insert into Artiste values (20, 5, 'nguyen', 'hai', '01/02/1923', 'dans la lune');
insert into Artiste values (21, 6, 'hoang', 'minh', '01/02/1943', 'dans le soleil');
insert into Artiste values (22, 7, 'cristiano', 'ba', '10/11/1973', 'dans le mars');
insert into Artiste values (23, 8, 'muoi', 'mot', '23/12/1992', 'dans la terre');
insert into Artiste values (24, 2, 'bui', 'hoang', '10/02/1984', 'dans la lune');
insert into Artiste values (35, 2, 'cockburn', 'heath', '10/05/1925', 'new mexico');
insert into Artiste values (36, 3, 'litoris', 'mike', '06/11/1994', 'in your mom');
insert into Artiste values (37, 1, 'the', 'witcher', '12/07/1931', 'steam');
insert into Artiste values (38, 2, 'coty', 'rene', '10/09/1929', 'elysee');
Insert into Artiste Values (42, 75, 'Le clown', 'Bozo', '09/04/1995', '677 rue du président Coty');
Insert into Artiste Values (45, 4, 'Fillon', 'François', '19/04/1242', 'Chez Yvonne');
Insert into Artiste Values (46, 4, 'Sarkozy', 'Nicolas', '01/01/0001', 'Chez mami Bettencourt');
Insert into Artiste Values (47, 4, 'Poutou', 'Philippe', '04/02/1975', 'À l usine');

insert into CompteUtilisateur Values (42,'balek', 'Expert');

Insert into ArtisteExpert Values (47, '02 20 30 21 02');
insert into ArtisteExpert values (1, '06 21 23 29 01');
insert into ArtisteExpert values (2, '07 32 21 23 42');
insert into ArtisteExpert values (3, '08 23 28 12 34');
insert into ArtisteExpert values (5, '09 45 23 19 23');
insert into ArtisteExpert values (6, '08 21 32 02 93');
insert into ArtisteExpert values (7, '06 23 82 91 29');
insert into ArtisteExpert values (8, '07 28 30 29 42');
insert into ArtisteExpert values (9, '08 33 92 00 32');
insert into ArtisteExpert values (10, '06 83 02 93 10');
insert into ArtisteExpert values (11, '03 29 43 90 02');
insert into ArtisteExpert values (12, '05 93 02 93 42');
insert into ArtisteExpert values (13, '06 34 39 23 04');
insert into ArtisteExpert values (14, '05 39 20 38 68');
insert into ArtisteExpert values (15, '06 79 48 03 95');
insert into ArtisteExpert values (16, '04 39 40 58 03');
insert into ArtisteExpert values (17, '04 83 03 94 05');
insert into ArtisteExpert values (18, '09 44 83 04 37');

Insert into ArtisteParticipant Values (46);
Insert into ArtisteParticipant Values (38);
Insert into ArtisteParticipant Values (37);
Insert into ArtisteParticipant Values (36);
Insert into ArtisteParticipant Values (35);

Insert into ArtistePrincipal Values (46, '+33657846910');
Insert into ArtistePrincipal Values (38, '+33657846910');
Insert into ArtistePrincipal Values (37, '+33657846910');
Insert into ArtistePrincipal Values (36, '+33657846910');
Insert into ArtistePrincipal Values (35, '+33657846910');

-- Et là c'est le drame
--Insert into ArtistePrincipal Values (45, 'BUG');
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
