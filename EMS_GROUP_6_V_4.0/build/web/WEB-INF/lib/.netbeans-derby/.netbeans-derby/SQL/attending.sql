create table attending
( eventid  integer    references event(idevent)
, person_id integer references person(idperson)
, constraint attending_pk primary key (eventid, person_id)
);

Insert into EMS.attending(eventid, person_id) 
                        values(1, 2000);
Insert into EMS.attending(eventid, person_id) 
                        values(1, 2014);
Insert into EMS.attending(eventid, person_id) 
                        values(1, 2012);
Insert into EMS.attending(eventid, person_id) 
                        values(2, 2001);
Insert into EMS.attending(eventid, person_id) 
                        values(2, 2005);
Insert into EMS.attending(eventid, person_id) 
                        values(2, 2007);
Insert into EMS.attending(eventid, person_id) 
                        values(3, 2002);
Insert into EMS.attending(eventid, person_id) 
                        values(3, 2009);
Insert into EMS.attending(eventid, person_id) 
                        values(3, 2010);
Insert into EMS.attending(eventid, person_id) 
                        values(4, 2003);
Insert into EMS.attending(eventid, person_id) 
                        values(4, 2017);
Insert into EMS.attending(eventid, person_id) 
                        values(5, 2004);