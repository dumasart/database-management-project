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
