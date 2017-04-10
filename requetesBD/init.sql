--set autocommit off
alter session set nls_date_format='dd/MM/yyyy';
insert into typeCompte Values ('Expert');
insert into typeCompte Values ('Admin');
insert into CompteUtilisateur Values (42,'balek', 'Expert'); 
insert into Cirque Values ( 75, 'Cirque Zabatta');
insert into Cirque Values ( 4, 'Cirque politique');
Insert into Artiste Values (42, 75, 'Le clown', 'Bozo', '09/04/1995', '677 rue du président Coty');
Insert into Artiste Values (45, 4, 'Fillon', 'François', '19/04/1242', 'Chez Yvonne');
Insert into Artiste Values (46, 4, 'Sarkozy', 'Nicolas', '01/01/0001', 'Chez mami Bettencourt');
Insert into Artiste Values (47, 4, 'Poutou', 'Philippe', '04/02/1975', 'À l usine');
Insert into ArtisteExpert Values (47, '1');
Insert into ArtisteParticipant Values (46);
Insert into ArtistePrincipal Values (46, '+33657846910');
-- Et là c'est le drame
--Insert into ArtistePrincipal Values (45, 'BUG');
insert into Theme values ('Clown');
Insert into jury values (1, 25);
Insert into Festival values (75, 1);
Insert into spectacle values (4, '06/04/1347', 14, 16, 500, 42, 'Clown', 75);
Insert into Numero values (15, 'Numero2', 'Titre numéro pas trop long', 20, 5, 'true', 46,'Clown');
Insert into EstExpertEn values (47, 'Clown');
Insert into Evaluation values (47, 15, 'commentaire constructif', 7);
