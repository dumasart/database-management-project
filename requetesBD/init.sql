
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
insert into Artiste values (5, 2, 'x', 'professeur', '12/04/1957', 'cerebro');
insert into Artiste values (6, 3, 'chirac', 'jacques', '01/10/1917', 'mangez des pommes');
insert into Artiste values (7, 1, 'de sel', 'avalanche', '12/07/1997', 'lol4ever');
insert into Artiste values (8, 2, 'biatch', 'b2o', '12/05/1987', 'la street');
insert into Artiste values (9, 3, 'musk', 'elen', '12/11/1987', 'pluton');
insert into Artiste values (10, 1, 'mcdo', 'christina', '12/01/1987', 'gymnase est');
insert into Artiste values (11, 2, 'le pen', 'marine', '12/08/1987', 'algerie');
insert into Artiste values (12, 3, 'et malou', 'tintin', '12/05/1987', 'republique democratique du congo');
insert into Artiste values (13, 1, 'salt', 'bae', '12/09/1987', 'internet');
insert into Artiste values (14, 2, 'kong', 'donkey', '12/04/1987', 'bananaland');
insert into Artiste values (15, 3, 'bal', 'jean', '12/12/1987', 'groland');
insert into Artiste values (16, 1, 'et ramzie', 'eric', '12/11/1987', '93');
insert into Artiste values (17, 2, 'ramsay', 'gordon', '12/05/1987', 'dans ta cuisine');
insert into Artiste values (18, 3, 'T', 'MS', '12/07/1987', 'dans ta mere');
insert into Artiste values (19, 1, 'mussolini', 'hitler', '14/03/1945', 'troisieme reich');
insert into Artiste values (20, 2, 'dover', 'ben', '28/02/1916', 'minnesota');
insert into Artiste values (21, 3, 'enis', 'p', '01/02/1954', 'peanutcity');
insert into Artiste values (22, 1, 'et morty', 'rick', '06/01/1984', 'earth #448');
insert into Artiste values (23, 2, 'astley', 'rick', '12/10/1975', 'never gonna give you up');
insert into Artiste values (24, 3, 'mouse', 'mickey', '11/06/1998', 'mickeyville');
insert into Artiste values (25, 1, 'judas', 'judor', '09/08/1954', 'la haye');
insert into Artiste values (26, 2, 'condom', 'jesus', '26/03/1918', 'nowhere');
insert into Artiste values (27, 3, 'norris', 'chuck', '30/11/1956', 'walter texas ranger city');
insert into Artiste values (28, 1, 'terminator', 'x263', '16/10/1975', 'i ll be back');
insert into Artiste values (29, 2, 'croft', 'lara', '29/12/1969', 'temple of doom');
insert into Artiste values (30, 3, 'snow', 'jon', '28/06/1981', 'king s landing');
insert into Artiste values (31, 1, 'sider', 'justin', '02/04/1963', 'fdp');
insert into Artiste values (32, 2, 'bolton', 'ramsay', '13/08/1971', 'in a barn');
insert into Artiste values (33, 3, 'white', 'walter', '07/10/1913', 'albuqerque texas bitch');
insert into Artiste values (34, 1, 'simpsons', 'homer', '24/12/1973', 'springfield');
insert into Artiste values (35, 2, 'cockburn', 'heath', '10/05/1925', 'new mexico');
insert into Artiste values (36, 3, 'litoris', 'mike', '06/11/1994', 'in your mom');
insert into Artiste values (37, 1, 'the', 'witcher', '12/07/1931', 'steam');
insert into Artiste values (38, 2, 'coty', 'rene', '10/09/1929', 'elysee');
Insert into Artiste Values (42, 75, 'Le clown', 'Bozo', '09/04/1995', '677 rue du président Coty');
Insert into Artiste Values (45, 4, 'Fillon', 'François', '19/04/1242', 'Chez Yvonne');
Insert into Artiste Values (46, 4, 'Sarkozy', 'Nicolas', '01/01/0001', 'Chez mami Bettencourt');
Insert into Artiste Values (47, 4, 'Poutou', 'Philippe', '04/02/1975', 'À l usine');

insert into CompteUtilisateur Values (42,'balek', 'Expert');
insert into CompteUtilisateur Values (1,'valak', 'Expert');
insert into CompteUtilisateur Values (2,'valak', 'Expert');
insert into CompteUtilisateur Values (4,'valak', 'Expert');
insert into CompteUtilisateur Values (5,'valak', 'Expert');
insert into CompteUtilisateur Values (6,'valak', 'Expert');
insert into CompteUtilisateur Values (7,'valak', 'Expert');
insert into CompteUtilisateur Values (8,'valak', 'Expert');
insert into CompteUtilisateur Values (9,'valak', 'Expert');
insert into CompteUtilisateur Values (10,'valak', 'Expert');
insert into CompteUtilisateur Values (11,'valak', 'Expert');
insert into CompteUtilisateur Values (12,'valak', 'Expert');
insert into CompteUtilisateur Values (13,'valak', 'Expert');
insert into CompteUtilisateur Values (14,'valak', 'Expert');
insert into CompteUtilisateur Values (15,'valak', 'Expert');
insert into CompteUtilisateur Values (16,'valak', 'Expert');
insert into CompteUtilisateur Values (17,'valak', 'Expert');
insert into CompteUtilisateur Values (18,'valak', 'Expert');
insert into CompteUtilisateur Values (19,'valak', 'Expert');
insert into CompteUtilisateur Values (20,'valak', 'Expert');
insert into CompteUtilisateur Values (21,'valak', 'Expert');
insert into CompteUtilisateur Values (22,'valak', 'Expert');
insert into CompteUtilisateur Values (23,'valak', 'Expert');
insert into CompteUtilisateur Values (24,'valak', 'Expert');
insert into CompteUtilisateur Values (25,'valak', 'Expert');
insert into CompteUtilisateur Values (26,'valak', 'Expert');
insert into CompteUtilisateur Values (27,'valak', 'Expert');
insert into CompteUtilisateur Values (28,'valak', 'Expert');
insert into CompteUtilisateur Values (29,'valak', 'Expert');
insert into CompteUtilisateur Values (30,'valak', 'Expert');
insert into CompteUtilisateur Values (31,'valak', 'Expert');
insert into CompteUtilisateur Values (32,'valak', 'Expert');
insert into CompteUtilisateur Values (33,'valak', 'Expert');
insert into CompteUtilisateur Values (34,'valak', 'Expert');
insert into CompteUtilisateur Values (35,'valak', 'Expert');
insert into CompteUtilisateur Values (36,'valak', 'Expert');
insert into CompteUtilisateur Values (37,'valak', 'Expert');
insert into CompteUtilisateur Values (38,'valak', 'Expert');


Insert into ArtisteExpert Values (47, '02 20 30 21 02');
Insert into ArtisteExpert Values (42, '02 20 30 21 99');
insert into ArtisteExpert values (1, '06 21 23 29 01');
insert into ArtisteExpert values (2, '07 32 21 23 42');
insert into ArtisteExpert values (3, '08 23 28 12 34');
insert into ArtisteExpert values (4, '08 23 12 12 34');
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
Insert into ArtisteParticipant Values (32);

Insert into ArtistePrincipal Values (46, '+33657846910');
Insert into ArtistePrincipal Values (38, '+33657846910');
Insert into ArtistePrincipal Values (37, '+33657846910');
Insert into ArtistePrincipal Values (36, '+33657846910');
Insert into ArtistePrincipal Values (35, '+33657846910');
Insert into ArtistePrincipal Values (32, '+33657845610');

-- Et là c'est le drame
--Insert into ArtistePrincipal Values (45, 'BUG');
Insert into jury values (1, 25);
Insert into Festival values (75, 1);
Insert into spectacle values (4, '06/04/1347', 14, 16, 500, 42, 'Clown', 75);

Insert into Numero values (15, 'NumeroBis', 'Titre numéro pas trop long', 20, 5, 'true', 46,'Clown');
insert into Numero values (1,'Trapèzes','Bah on fait du trapèze pélo',30,3,'false',38,'Acrobatie');
insert into Numero values (2, 'Lions', 'cerceaux de feu', 25, 1, 'false', 37, 'Dressage');
insert into Numero values (3, 'ours', 'blah blah', 27, 1, 'false', 36, 'Dressage');
insert into Numero values (4, 'funambule', 'du lourd', 22, 1, 'false',35, 'Acrobatie');
insert into Numero values (5, 'Licorne', 'blah blah blah', 32, 3, 'true',32, 'Contorsionniste');

insert into Numero values (6, 'Carte', 'blah blah blah', 28, 4, 'true',35, 'Magie');
insert into Numero values (7, 'Muahaha', 'blah blah blah', 31, 1, 'true',36, 'Acrobatie');
insert into Numero values (8, 'Muahihi', 'blah blah blah', 33, 12, 'false',36, 'Dressage');


Insert into EstExpertEn values (47, 'Clown');
Insert into EstExpertEn values (42, 'Acrobatie');
Insert into EstExpertEn values (1, 'Dressage');
Insert into EstExpertEn values (2, 'Acrobatie');
Insert into EstExpertEn values (3, 'Clown');
Insert into EstExpertEn values (4, 'Dressage');

Insert into Evaluation values (47, 15, 'commentaire constructif', 7);

insert into Evaluation values (1, 1, 'fou', 5);
insert into Evaluation values (2, 1, 'ouf', 8);
insert into Evaluation values (3, 1, 'excellent', 10);
insert into Evaluation values (4, 1, 'oui', 8);
insert into Evaluation values (42, 1, 'oui', 6);

insert into Evaluation values (1, 2, 'fou', 0);
insert into Evaluation values (2, 2, 'ouf', 5);
insert into Evaluation values (3, 2, 'excellent', 10);
insert into Evaluation values (4, 2, 'oui', 5);
insert into Evaluation values (42, 2, 'oui', 7);

insert into Evaluation values (1, 3, 'fou', 5);
insert into Evaluation values (2, 3, 'ouf', 8);
insert into Evaluation values (3, 3, 'excellent', 10);
insert into Evaluation values (4, 3, 'oui', 8);
insert into Evaluation values (42, 3, 'oui', 10);


insert into Evaluation values (1, 4, 'fou', 2);
insert into Evaluation values (2, 4, 'ouf', 4);
insert into Evaluation values (3, 4, 'excellent', 5);
insert into Evaluation values (4, 4, 'oui', 3);
insert into Evaluation values (42, 4, 'oui', 4);

commit;
