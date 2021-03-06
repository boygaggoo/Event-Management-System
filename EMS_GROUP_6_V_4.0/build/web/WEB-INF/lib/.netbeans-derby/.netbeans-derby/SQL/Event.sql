USE EMS;

DROP TABLE IF EXISTS EVENT;

CREATE table EMS.EVENT (
    idevent     INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
				STARTTIME VARCHAR(25) DEFAULT NULL, 
				ENDTIME VARCHAR(25) DEFAULT NULL,
                DESCRIPTION VARCHAR(255) DEFAULT NULL, 
				EVENTNAME VARCHAR(45) DEFAULT NULL);
ALTER TABLE event
DROP COLUMN startttime;

ALTER TABLE event
DROP COLUMN endtime;

ALTER TABLE event
ADD starttime varchar(25);	

ALTER TABLE event
ADD endtime varchar(25);

ALTER TABLE event
ADD event_date varchar(25);

INSERT INTO EMS.EVENT (DESCRIPTION, EVENTNAME, STARTTIME, ENDTIME, EVENT_DATE) VALUES ('2015-10-11 16:15:00.0', 
                        '2015-10-11 17:00:00.0', '16th Birthday Party', 'Birthday Party');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-12 10:00:00.0',
                        '2015-10-10 10:30:00.0', 'Club Meeting', 'ACM Meeting');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-13 09:30:00.0',
                        '2015-10-13 12:15:00.0', 'Rock Concert', 'Garage Band Rock Concert');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-16 10:30:00.0', 
                        '2015-10-16 13:45:00.0', DEFAULT, 'Spring Opera Performance');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-17 09:30:00.0', 
                        '2015-10-17 12:00:00.0', 'POLITICS', 'Presidential Speech');
                        




		
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-11 16:15:00.0', 
                        '2015-10-11 17:00:00.0', '16th Birthday Party', 'Birthday Party');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-12 10:00:00.0',
                        '2015-10-10 10:30:00.0', 'Club Meeting', 'ACM Meeting');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-13 09:30:00.0',
                        '2015-10-13 12:15:00.0', 'Rock Concert', 'Garage Band Rock Concert');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-16 10:30:00.0', 
                        '2015-10-16 13:45:00.0', DEFAULT, 'Spring Opera Performance');
                        
INSERT INTO EMS.EVENT (STARTTIME, ENDTIME, DESCRIPTION, EVENTNAME) VALUES ('2015-10-17 09:30:00.0', 
                        '2015-10-17 12:00:00.0', 'POLITICS', 'Presidential Speech');
                        
