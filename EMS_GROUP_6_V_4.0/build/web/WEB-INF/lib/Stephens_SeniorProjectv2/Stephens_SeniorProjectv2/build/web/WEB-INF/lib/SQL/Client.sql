CREATE table EMS.Client (
    client_id          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 3000, INCREMENT BY 1),
				PASSWORD VARCHAR(45) DEFAULT NULL, 
				EMAIL VARCHAR(45) DEFAULT NULL,
                NAME_FIRST VARCHAR(45) DEFAULT NULL, 
				NAME_MIDDLE VARCHAR(45) DEFAULT NULL, 
				NAME_LAST VARCHAR(45) DEFAULT NULL );
	
	
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'tester@acme.com',	'Rocco',	'John',	'Simpson');

Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'rfo@zenith.net',	'Rui',	'Jana',	'Foer');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'bmel@phish.net',	'Bee',	'Na',	'Mel');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'epra@nadir.com',	'Elli',	'Coulton',	'Prott');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'jsamp@spam.com',	'Jaiden',	'Potter',	'Simpson');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'ava@acme.com',	'Ava',	'Eve',	'Vanse');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'lkra@spam.com',	'Lane',	'Eli',	'Pramer');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'brawn@vogel.org',	'Isa',	'Fenix',	'Brawn ');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'dfar@vogel.org',	'Darry',	'Shamt',	'Farth');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password', 'ccl@spam.com',	'Clora',	'Cliana',	'Lark');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'kurby@zenith.net',	'Cassidy',	'ClarissA',	'Kurby');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'realmccoy@zenith.net',	'Bliza',	'Miles',	'McCoy');

Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'ycantu@phish.net',	'Yaylee',	'Elissa',	'Cantu');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'nagu@nadir.com',	'Naytasha',	'Stace',	'Agu');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'aash@nadir.com',	'Arielle',	'Jules',	'Ash');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'mckay@zenith.net',	'Jackson',	'Arms',	'McKay');
                    
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'tpar@zenith.net',	'Taygan',	'Rodolf',	'Park');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'jboy@vogel.org',	'James',	'Kendy',	'Boyd');

Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'droge@spam.com',	'Dem',	'Diet',	'Roge');
                        
Insert into EMS.Client(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) 
                        values('password',	'lwar@vogel.org',	'Lita',	'Lupe',	'Warn');