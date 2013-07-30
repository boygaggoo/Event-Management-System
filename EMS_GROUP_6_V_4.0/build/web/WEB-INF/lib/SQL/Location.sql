CREATE TABLE Location
(
location_id INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1000, INCREMENT BY 1),
abbreviation varchar(5) NOT NULL,
building varchar(50),
Address varchar(50),
room varchar(10),
PRIMARY KEY (location_id)
)

CREATE table EMS.Location (
    location_id          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1000, INCREMENT BY 1),
    abbreviation    VARCHAR(5), 
    building   VARCHAR(30),
    address  VARCHAR(100),
    room       VARCHAR(20) )


INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('GD', 'GEORGIA DOME', '1 Georgia Dome Dr  Atlanta, GA 30313-1504', 'SUITE C');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('SS', 'Springhill Suites Kennesaw', '3399 Town Point Drive  Kennesaw, GA 30144', 'CONFERENCE ROOM');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('CE', 'COBB ENERGY CENTER', '2800 Cobb Galleria Parkway  Atlanta, GA 30339-3109', 'CONFERENCE ROOM');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('ST', 'STILLWELL THEATRE', '1000 Chastain Rd at Kennesaw State University Kennesaw, GA 30144', 'LOBBY');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('CA', 'CHASTAIN AMPHITHEATRE', '1280 Peachtree Street Northeast  Atlanta, GA 30309', NULL);

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('KSU', 'KENNESAW STATE UNIVERSITY', '1000 Chastain Rd at Kennesaw State University Kennesaw, GA 30144', 'FITNESS CENTER');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('GSU', 'GEORGIA STATE UNIVERSITY', '50 Decatur Street Southeast  Atlanta, GA 30303-2924', 'STUDENT CENTER');

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('PA', 'PHILIPS ARENA', '1 Philips Dr  Atlanta, GA 30303', NULL);

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('RL', 'RED LOBSTER', '	2626 George Busbee Parkway  Kennesaw, GA 30144', NULL);

INSERT INTO location (ABBREVIATION, BUILDING, address, ROOM) VALUES ('WH', 'WHITE HOUSE', '1600 Pennsylvania Avenue NW Washington, DC 20500', 'CONFERENCE ROOM');
