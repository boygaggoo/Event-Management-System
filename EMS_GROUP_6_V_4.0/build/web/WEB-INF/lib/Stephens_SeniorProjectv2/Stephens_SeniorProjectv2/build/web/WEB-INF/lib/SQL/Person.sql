USE EMS;

DROP TABLE IF EXISTS PERSON;

CREATE table EMS.Person (
    Person_id          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 2000, INCREMENT BY 1),
				PASSWORD VARCHAR(45) DEFAULT NULL, 
				EMAIL VARCHAR(45) DEFAULT NULL,
                NAME_FIRST VARCHAR(45) DEFAULT NULL, 
				NAME_MIDDLE VARCHAR(45) DEFAULT NULL, 
				NAME_LAST VARCHAR(45) DEFAULT NULL );


Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('w6Bf1sA8',	'rsimpson@acme.com',	'Rocco',	'John',	'Simpson');

Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('8Rq11Z4H',	'rfowler@zenith.net',	'Rubi',	'Johana',	'Fowler');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('263MrB0n',	'bmelton@phish.net',	'Ben',	'Nash',	'Melton');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('y33GuJKQ',	'epratt@nadir.com',	'Elliott',	'Colton',	'Pratt');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('AIiqR57x',	'jsampson@spam.com',	'Jaydon',	'Porter',	'Sampson');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('jhN6N7kO',	'avance@acme.com',	'Amaya',	'Evelyn',	'Vance');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('8F7h5zK3',	'lkramer@spam.com',	'Laney',	'Eliza',	'Kramer');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('NrJ0g91s',	'ibraun@vogel.org',	'Isabell',	'Phoenix',	'Braun ');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('168k6of7',	'dfarrell@vogel.org',	'Darryl',	'Shamar',	'Farrell');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('eRXKr3s', 'cclark@spam.com',	'Cora',	'Iliana',	'Clark');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('80xP85NO',	'kkirby@zenith.net',	'Kassidy',	'MarissA',	'Kirby');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('6nLq7Y66',	'bmccoy@zenith.net',	'Brisa',	'Miley',	'Mccoy');

Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('Dn9HcA69',	'hcantu@phish.net',	'Haylee',	'Eliza',	'Cantu');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('Y7JsAH5p',	'naguilar@nadir.com',	'Natasha',	'Stacy',	'Aguilar');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('7gT04oAr',	'aashley@nadir.com',	'Ariel',	'Julian',	'Ashley');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('T7GBU9P1',	'jmckay@zenith.net',	'Jaxson',	'Armani',	'Mckay');
                    
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('1TJ874Nc',	'tparker@zenith.net',	'Teagan',	'Rodolfo',	'Parker');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('c8hbbOSm',	'jboyer@vogel.org',	'Jameson',	'Kendall',	'Boyer');

Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('5h4n3eZ2',	'drogers@spam.com',	'Demetrius',	'Diego',	'Rogers');
                        
Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('2a1Y7Kme',	'lwarner@vogel.org',	'Lina',	'Guadalupe',	'Warner');