create table reservation
( idevent  integer    references event(idevent)
, location_id integer references client(idclient)
, constraint reservation_pk primary key (idevent, location_id)
);

Insert into EMS.reservation(idevent, location_id) 
                        values(1, 1008);
Insert into EMS.reservation(idevent, location_id) 
                        values(2, 1001);
Insert into EMS.reservation(idevent, location_id) 
                        values(3, 1007);
Insert into EMS.reservation(idevent, location_id) 
                        values(4, 1003);
Insert into EMS.reservation(idevent, location_id) 
                        values(5, 1009);
