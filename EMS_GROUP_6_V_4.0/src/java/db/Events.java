package db;

import java.sql.*;
import domain.Event;
import domain.Location;
import domain.Person;
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
            cmd = "SELECT EVENTCOST FROM COST WHERE IDEVENT =" + id;
            conn.createStatement();
            rs = stat.executeQuery(cmd);
            rs.next();
            String location = getLocation(e);
            e.setLocation(location);
            String organizer = getOrganizer(e);
            e.setOrganizer(organizer);

            e.setCost(rs.getDouble(1));
            e.setProfit(getProfit(e));
            e.setRevenue(getRevenue(e));


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

    public static boolean removeEvent(Event e) {
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String event_id = e.getId();
            int iEvent_id = Integer.parseInt(event_id);
            String cmd = "DELETE FROM EMS.ATTENDING WHERE EVENTID =" + iEvent_id;

            Statement stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);

            cmd = "DELETE FROM EMS.COST WHERE IDEVENT =" + iEvent_id;

            stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);

            cmd = "DELETE FROM EMS.ORGANIZING WHERE EVENTID =" + iEvent_id;

            stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);

            cmd = "DELETE FROM EMS.RESERVATION WHERE IDEVENT =" + iEvent_id;

            stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);


            cmd = "DELETE FROM EMS.EVENT WHERE IDEVENT =" + iEvent_id;
            stat = conn.createStatement();
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

    public static List<String> getEvents() {
        //returns all of the events in the database
        conn = null;
        List<String> eventList = new ArrayList<String>();
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select IDEVENT, EVENTNAME, EVENT_DATE, STARTTIME FROM EVENT";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            while (rs.next()) {
                String id = rs.getString(1);
                id += " " + rs.getString(2);
                id += " " + rs.getString(3);
                id += " " + rs.getString(4);
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

    public static String getOrganizer(Event e) {
        //gets the organizer of an event
        String g = e.getId();
        conn = null;
        String client = "";

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select CLIENTID FROM ORGANIZING WHERE EVENTID=" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);


            rs.next();
            int clientID = rs.getInt(1);
            String cmd2 = "Select NAME_FIRST, NAME_LAST, EMAIL FROM CLIENT WHERE client_id=" + clientID;
            Statement stat2 = conn.createStatement();
            ResultSet rs2 = stat2.executeQuery(cmd2);
            rs2.next();
            client = rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3);
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
        return client;
    }

    public static String getLocation(Event l) {
        //get the location of an event
        String g = l.getId();
        int t = Integer.parseInt(g);
        conn = null;
        String location = "";

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select location_id FROM reservation WHERE IDEVENT=" + t;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            rs.next();
            int location_id = rs.getInt(1);
            String cmd2 = "Select BUILDING, ADDRESS, ROOM FROM LOCATION WHERE LOCATION_ID=" + location_id;
            Statement stat2 = conn.createStatement();
            ResultSet rs2 = stat2.executeQuery(cmd2);
            rs2.next();
            location = rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3);

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
        return location;
    }

    public static double getRevenue(Event e) {
        //calculates the profit from an event.
        double r = 0;
        String g = e.getId();
        conn = null;

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "SELECT COUNT(PERSON_ID) FROM attending WHERE eventid =" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            rs.next();
            int numPeople = rs.getInt(1);
            cmd = "SELECT ADMISSIONCOST, EVENTCOST FROM COST WHERE IDEVENT =" + g;
            stat = conn.createStatement();
            rs = stat.executeQuery(cmd);
            rs.next();
            double admission = rs.getDouble(1);
            //double moneyOut = rs.getDouble(2);
            r = numPeople * admission;
            // r = moneyIn - moneyOut;

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

        return r;
    }

    public static double getProfit(Event e) {
        //calculates the profit from an event.
        double p = 0;
        String g = e.getId();
        conn = null;

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "SELECT COUNT(PERSON_ID) FROM attending WHERE eventid =" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);
            rs.next();
            int numPeople = rs.getInt(1);
            cmd = "SELECT ADMISSIONCOST, EVENTCOST FROM COST WHERE IDEVENT =" + g;
            stat = conn.createStatement();
            rs = stat.executeQuery(cmd);
            rs.next();
            double admission = rs.getDouble(1);
            double moneyOut = rs.getDouble(2);
            double moneyIn = numPeople * admission;
            p = moneyIn - moneyOut;

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

        return p;
    }

    public static List<Person> getGuests(Event e) {
        //get a list of guests of an event
        String g = e.getId();
        conn = null;
        List<Person> personList = new ArrayList<Person>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select PERSON_ID FROM ATTENDING WHERE EVENTID=" + g;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                rs.next();
                int personID = rs.getInt(1);
                String cmd2 = "Select * FROM PERSON WHERE person_id=" + personID;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                rs2.next();
                String sPersonID = Integer.toString(personID);
                Person p = new Person(sPersonID);
                p.setEmail(rs2.getString(3));
                p.setFirstName(rs2.getString(4));
                p.setMiddleName(rs2.getString(5));
                p.setLastName(rs2.getString(6));
                personList.add(p);

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

    public static boolean addEvent(String STARTTIME, String ENDTIME, String DESCRIPTION, String EVENTNAME, String Event_Date, String Event_Cost, String Admission) {
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
            if (!STARTTIME.equals("")) {
                cmd += "'" + STARTTIME + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!ENDTIME.equals("")) {
                cmd += "'" + ENDTIME + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!Event_Date.equals("")) {
                cmd += "'" + Event_Date + "')";
            } else {
                cmd += "NULL)";
            }

            Statement stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);
            if (!Event_Cost.equals("") || !Admission.equals("")) {
                cmd = "SELECT MAX(IDEVENT) FROM EMS.EVENT";
                stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(cmd);
                rs.next();
                int idevent = rs.getInt(1);

                cmd = "INSERT INTO EMS.COST (IDEVENT, ADMISSIONCOST, EVENTCOST) VALUES (" + idevent + ",";
                if (!Admission.equals("")) {
                    cmd += Admission + ", ";
                } else {
                    cmd += "NULL, ";
                }
                if (!Event_Cost.equals("")) {
                    cmd += Event_Cost + ")";
                } else {
                    cmd += "NULL)";
                }
                
                stat = conn.createStatement();
                rowsUpdated = stat.executeUpdate(cmd);


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
        if (rowsUpdated > 0) {
            success = true;
        }

        return success;
    }

    public Events() {
    }
}
