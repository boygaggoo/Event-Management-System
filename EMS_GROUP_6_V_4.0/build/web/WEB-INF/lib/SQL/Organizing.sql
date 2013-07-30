create table organizing
( eventid  integer    references event(idevent)
, clientid integer references client(client_id)
, constraint organizing_pk primary key (eventid, clientid)
);

Insert into EMS.Organizing(eventid, clientid) 
                        values(1, 3000);
Insert into EMS.Organizing(eventid, clientid) 
                        values(2, 3001);
Insert into EMS.Organizing(eventid, clientid) 
                        values(3, 3002);
Insert into EMS.Organizing(eventid, clientid) 
                        values(4, 3003);
Insert into EMS.Organizing(eventid, clientid) 
                        values(5, 3004);