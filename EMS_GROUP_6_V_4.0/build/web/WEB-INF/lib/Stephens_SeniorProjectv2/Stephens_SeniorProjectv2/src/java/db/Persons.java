package db;

import domain.Event;
import domain.Person;
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
public class Persons {

    private static Connection conn;
    private static String url = "jdbc:derby://localhost/ems;user=ems;password=ems";

    public Persons() {
    }

    public static List<String> getPersons() {
        //get a list of all of the people in the database
        conn = null;
        List<String> personList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select NAME_FIRST, NAME_LAST FROM PERSON";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {

                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
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

    public static Person getPerson(String firstName, String lastName) {
        //get a specific person in the database
        conn = null;
        Person p = null;

        try {

            conn = DriverManager.getConnection(url);

            String cmd = "SELECT * FROM PERSON WHERE NAME_FIRST =" + "'" + firstName + "'" + " AND NAME_LAST =" + "'" + lastName + "'";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            rs.next();
            String id = rs.getString(1);
            String email = rs.getString(3);

            String middleName = rs.getString(5);

            p = new Person(id);
            p.setEmail(email);
            p.setFirstName(firstName);
            p.setMiddleName(middleName);
            p.setLastName(lastName);

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

    public static List<Event> getAttendingEvents(Person p) {
        //gets the events that the person is attending
        String id = p.getId();
        conn = null;
        List<Event> list = new LinkedList<Event>();
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "SELECT EVENTID FROM ATTENDING WHERE PERSON_ID =" + "'" + id + "'";
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

    public static boolean savePerson(Person p) {
        //update the person's information
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "UPDATE PERSON SET PASSWORD='" + p.getPassword()
                    + "',EMAIL='" + p.getEmail() + "',NAME_FIRST='" + p.getFirstName() + "',NAME_MIDDLE='" + p.getMiddleName()
                    + "',NAME_LAST='" + p.getLastName() + "'WHERE person_id = '" + p.getId() + "'";

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
    public static boolean addPerson(String password, String email, String name_first, String name_middle, String name_last) {
        //create a new person
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "Insert into EMS.Person(PASSWORD, EMAIL, NAME_FIRST, NAME_MIDDLE, NAME_LAST) VALUES (";
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
                cmd += "'" + name_last + "');";
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

    public static String registerPerson(Event e, Person p) {
        //register a person to attend an event
        String success = "An error has occurred.";
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "INSERT INTO ATTENDING VALUES(" + e.getId() + ",'" + p.getId() + "')";

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
}
