
create table Jury
(
	codeJury integer not null check(codeJury >= 0),
	nbMembreJury integer not null check(nbMembreJury >= 25 and nbMembreJury <= 35),
	primary key (codeJury)
);


create table Cirque
(
	codeCirque integer not null check(codeCirque >= 0),
	nomCirque varchar(20) not null,
	primary key (codeCirque)
);

create table Artiste
(
	codeArtiste integer not null check(codeArtiste >= 0),
	codeCirque integer not null,
	nomArtiste varchar(20) not null,
	prenomArtiste varchar(20) not null,
	dateNaissanceArtiste date not null,
	adresseArtiste varchar(100) not null,
	primary key(codeArtiste),
	foreign key (codeCirque) references Cirque(codeCirque)
);

create table Theme
(
	theme varchar(20) not null check(theme in ('Magie', 'Acrobatie', 'Dressage', 'Clown', 'Contorsionniste', 'Danse', 'Dextérité', 'Orchestre')),
	primary key (theme)
);

create table Festival
(
	codeFestival integer not null check(codeFestival >= 0),
	codeJury integer not null,
	primary key (codeFestival),
	foreign key (codeJury) references Jury(codeJury)
);

create table ArtisteParticipant
(
	codeArtiste int  not null, 
	foreign key (codeArtiste) references Artiste(codeArtiste),
	primary key (codeArtiste)
);

create table ArtistePrincipal
(
	codeArtiste integer  not null, 
	NumTelPrincipal varchar(20) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	primary key (codeArtiste)
);

create table ArtisteExpert
(
	codeArtiste integer  not null, 
	NumTelExpert varchar(20) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	primary key (codeArtiste)
);

create table ArtisteOrganisateur
(     
      codeArtiste integer not null,
      codeFestival integer not null,
      foreign key (codeArtiste) references Artiste(codeArtiste),
      foreign key (codeFestival) references Festival(codeFestival),
	primary key (codeArtiste, codeFestival)
);

create table Numero
(
	codeNumero integer not null check(codeNumero >= 0),
	TitreNumero varchar(50) not null,
	ResumeNumero varchar(1000) not null,
	DureeNumero integer not null check(DureeNumero<= 40 and DureeNumero >=20),
	NbArtisteNumero integer not null check (NbArtisteNumero > 0),
	EstCreation varchar(5) not null check(EstCreation in ('true', 'false')),
	primary key(codeNumero),
	codeArtiste integer not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	theme varchar(20) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste)
);
	
create table Spectacle
(
	codeSpectacle integer  not null check(codeSpectacle >= 0),
	jourSpectacle date not null,
	heureDebut integer not null check(heureDebut >= 0),
	heureFin integer not null,
	check(heureFin > heureDebut and heureFin < heureDebut + 3*60),
	prixSpectacle real not null check(prixSpectacle >= 0),
	codeArtiste integer not null,
	theme varchar(20) not null,
	codeFestival integer not null,
	primary key (codeSpectacle),
	foreign key (codeArtiste) references Artiste(codeArtiste),
	foreign key (theme) references Theme(theme),
	foreign key (codeFestival) references Festival(codeFestival)
);

create table NumeroAccepte
(
	codeNumero integer not null,
	codeSpectacle integer not null,
	HeureNumero integer not null check(heureNumero >= 0),
	foreign key (codeNumero) references Numero(codeNumero),
	foreign key (codeSpectacle) references Spectacle(codeSpectacle),
	primary key (codeNumero, codeSpectacle)
);

create table EstSurnomme
(
	codeArtiste integer not null,
	pseudo varchar(20) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	primary key (pseudo)
);

create table EstExpertEn
(
	codeArtiste integer not null,
	theme varchar(20) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	foreign key (theme) references Theme(theme),
	primary key (codeArtiste, theme)
);

create table AppartientA
(
	codeArtiste integer not null,
	codeJury integer not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	foreign key (codeJury) references Jury(codeJury),
	primary key (codeArtiste, codeJury)
);

create table ParticipeA
(
	codeArtiste integer not null,
	codeNumero integer not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	foreign key (codeNumero) references Numero(codeNumero),
	primary key (codeArtiste, codeNumero)
);

create table Evaluation
(
	codeArtiste integer not null,
	codeNumero integer not null,
	evaluation varchar(1000) not null,
	note integer not null check(note >= 0 and note <= 10),
	foreign key (codeArtiste) references Artiste(codeArtiste),
	foreign key (codeNumero) references Numero(codeNumero),
	primary key (codeArtiste, codeNumero)
);

create table Login
(
	codeArtiste integer not null,
	motDePasse varchar(25) not null,
	foreign key (codeArtiste) references Artiste(codeArtiste),
	primary key (codeArtiste)
);
