package db;

import java.sql.*;
import domain.Event;
import domain.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen
 */
public class Events {

    private static String url = "jdbc:derby://localhost/ems;user=ems;password=ems";
    private static Connection conn;

    public static Event getEvent(int id) {
        //returns a specific event
        Event e = null;
        conn = null;

        try {
            conn = DriverManager.getConnection(url);
            String cmd = "SELECT * FROM EVENT WHERE IDEVENT=" + id;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            rs.next();
            e = new Event(rs.getString(1));
                e.setDate(rs.getString(6));
                e.setStartTime(rs.getString(4));
                e.setEndTime(rs.getString(5));
                e.setDescription(rs.getString(2));
                e.setEventName(rs.getString(3));


        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }

    public static List<String> getEvents() {
        //returns all of the events in the database
        conn = null;
        List<String> eventList = new ArrayList<String>();
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select IDEVENT FROM EVENT";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            while (rs.next()) {
                String id = rs.getString(1);

                eventList.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eventList;
    }

    public static List<String> getOrganizer(Event e) {
        //gets the organizer of an event
        String g = e.getId();
        conn = null;
        List<String> clientList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select CLIENTID FROM ORGANIZING WHERE EVENTID=" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                int clientID = rs.getInt(1);
                String cmd2 = "Select NAME_FIRST, NAME_LAST FROM CLIENT WHERE client_id=" + clientID;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                String firstName = rs2.getString(1);
                String lastName = rs2.getString(2);
                String name = firstName + " " + lastName;
                clientList.add(name);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientList;
    }
    
    public static List<String> getLocation(Location l) {
        //get the location of an event
        String g = l.getId();
        conn = null;
        List<String> locationList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select location_id FROM reservation WHERE IDEVENT=" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                int location_id = rs.getInt(1);
                String cmd2 = "Select BUILDING, ADDRESS, ROOM FROM LOCATION WHERE LOCATION_ID=" + location_id;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                String building = rs2.getString(1);
                String address = rs2.getString(2);
                String room = rs2.getString(3);
                String location = building + " " + room + " " + address;
                locationList.add(location);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return locationList;
    }

    public static List<String> getGuests(Event e) {
        //get a list of guests of an event
        String g = e.getId();
        conn = null;
        List<String> personList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select PERSONID FROM ATTENDING WHERE EVENTID=" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                int personID = rs.getInt(1);
                String cmd2 = "Select NAME_FIRST, NAME_LAST FROM PERSON WHERE person_id=" + personID;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                String firstName = rs2.getString(1);
                String lastName = rs2.getString(2);
                String name = firstName + " " + lastName;
                personList.add(name);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personList;
    }

    public static boolean addEvent(String STARTTIME, String ENDTIME, String DESCRIPTION, String EVENTNAME, String Event_Date) {
        //create a new event
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "INSERT INTO EMS.EVENT (DESCRIPTION, EVENTNAME, STARTTIME, ENDTIME, EVENT_DATE) VALUES (";
            if (!DESCRIPTION.equals("")) {
                cmd += "'" + DESCRIPTION + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!EVENTNAME.equals("")) {
                cmd += "'" + EVENTNAME + "',";
            } else {
                cmd += "NULL, ";
            }
            if (STARTTIME != null) {
                cmd += "'" + STARTTIME + "',";
            } else {
                cmd += "NULL, ";
            }
            if (ENDTIME != null) {
                cmd += "'" + ENDTIME + "',";
            } else {
                cmd += "NULL, ";
            }
            if (Event_Date != null) {
                cmd += "'" + Event_Date + "');";
            } else {
                cmd += "NULL);";
            }

            Statement stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);

        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rowsUpdated > 0) {
            success = true;
        }

        return success;
    }

    public Events() {
    }
}
