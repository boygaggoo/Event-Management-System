package db;

import domain.Event;
import domain.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen
 */
public class Clients {

    private static Connection conn;
    private static String url = "jdbc:derby://localhost/ems;user=ems;password=ems";

    public Clients() {
    }

    public static List<String> getClients() {
        //get all of the clients in the database

        conn = null;
        List<String> personList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select CLIENT_ID, NAME_FIRST, NAME_LAST FROM CLIENT";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                String client_id = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String name = client_id + " " + firstName + " " + lastName;
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
    
    public static boolean removeClient(Client c) {
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String client_id = c.getId();
            int iClient_id = Integer.parseInt(client_id);
            String cmd = "DELETE FROM EMS.ORGANIZING WHERE CLIENTID =" + iClient_id;

            Statement stat = conn.createStatement();
            rowsUpdated = stat.executeUpdate(cmd);
            
            cmd = "DELETE FROM EMS.CLIENT WHERE CLIENT_ID =" + iClient_id;
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

    public static Client getClient(int cid) {
        //get a specific client in the database
        conn = null;
        Client p = null;

        try {

            conn = DriverManager.getConnection(url);

            String cmd = "SELECT * FROM CLIENT WHERE CLIENT_ID=" + cid;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            rs.next();
            String id = rs.getString(1);
            String email = rs.getString(3);

            String middleName = rs.getString(5);

            p = new Client(id);
            p.setEmail(email);
            p.setFirstName(rs.getString(4));
            p.setMiddleName(middleName);
            p.setLastName(rs.getString(6));

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
    
    public static List<Event> getOrganizingEvents(Client p) {
        //get events that the client is organizing
        String id = p.getId();
        List<Event> list = new LinkedList<Event>();
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "SELECT EVENTID FROM ORGANIZING WHERE ClientId =" + id ;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                String eventId = rs.getString(1);
                String cmd2 = "SELECT * FROM EVENT WHERE IDEVENT =" + eventId;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                rs2.next();
                Event e = new Event(eventId);
                e.setDate(rs2.getString(6));
                e.setStartTime(rs2.getString(4));
                e.setEndTime(rs2.getString(5));
                e.setDescription(rs2.getString(2));
                e.setEventName(rs2.getString(3));
                e.setLocation(Events.getLocation(e));

                list.add(e);
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
        return list;
    }

    public static boolean saveClient(Client p) {
        //update client information
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "UPDATE Client SET PASSWORD='" + p.getPassword()
                    + "',EMAIL='" + p.getEmail() + "',NAME_FIRST='" + p.getFirstName() + "',NAME_MIDDLE='" + p.getMiddleName()
                    + "',NAME_LAST='" + p.getLastName() + "'WHERE IDCLIENT = '" + p.getId() + "'";

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

    public static String registerClient(Event e, Client p) {
        //register the client as organizing an event
        String success = "An error has occurred.";
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "INSERT INTO ORGANIZING VALUES(" + e.getId() + ",'" + p.getId() + "')";

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
            success = "Success!";
        }

        return success;
    }
    public static boolean addClient(String password, String email, String name_first, String name_middle, String name_last) {
        //create a new client
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "Insert into EMS.CLIENT(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) VALUES (";
            if (!password.equals("")) {
                cmd += "'" + password + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!email.equals("")) {
                cmd += "'" + email + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!name_first.equals("")) {
                cmd += "'" + name_first + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!name_middle.equals("")) {
                cmd += "'" + name_middle + "',";
            } else {
                cmd += "NULL, ";
            }
            if (!name_last.equals("")) {
                cmd += "'" + name_last + "')";
            } else {
                cmd += "NULL)";
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
}
