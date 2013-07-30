package db;

import domain.Event;
import domain.Location;
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
public class Locations {

    private static Connection conn;
    private static String url = "jdbc:derby://localhost/ems;user=ems;password=ems";

    public Locations() {
    }

    public static boolean addLocation(String address, String buildingAbbrev, String roomNumber, String fullName) {
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "INSERT INTO EMS.LOCATION(ABBREVIATION, BUILDING, ADDRESS, ROOM ) VALUES (";
            if (buildingAbbrev != null) {
                cmd += "'" + buildingAbbrev + "',";
            } else {
                cmd += "NULL, ";
            }
            if (fullName != null) {
                cmd += "'" + fullName + "',";
            } else {
                cmd += "NULL, ";
            }
            if (address != null) {
                cmd += "'" + address + "',";
            } else {
                cmd += "NULL, ";
            }
            if (roomNumber != null) {
                cmd += "'" + roomNumber + "');";
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

    public static List<String> getLocations() {
        //returns a list of all the locations
        conn = null;
        List<String> locationList = new ArrayList<String>();

        try {

            conn = DriverManager.getConnection(url);
            String cmd = "Select BUILDING FROM LOCATION";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {

                String building = rs.getString(1);
                locationList.add(building);

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

    public static Location getLocation(String buildingName) {
        //returns the location information for building name
        conn = null;
        Location l = null;

        try {
            buildingName.toLowerCase();
            conn = DriverManager.getConnection(url);
            String cmd = "SELECT * FROM LOCATION WHERE BUILDING =" + "'" + buildingName + "'";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            rs.next();
            String id = rs.getString(1);
            String abbrev = rs.getString(2);
            String building = rs.getString(3);
            String room = rs.getString(4);
            String address = rs.getString(5);

            l = new Location(id);
            l.setAddress(address);
            l.setFullName(building);
            l.setBuildingAbbrev(abbrev);
            l.setRoomNumber(room);

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
        return l;
    }

    public static List<Event> getLocationReservations(Location l) {
        //returns a list of events at the location
        String id = l.getId();
        conn = null;
        List<Event> list = new LinkedList<Event>();
        try {

            conn = DriverManager.getConnection(url);

            String cmd = "SELECT idevent FROM reservations WHERE location_id =" + "'" + id + "'";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(cmd);

            while (rs.next()) {
                String eventid = rs.getString(1);
                String cmd2 = "SELECT * FROM EVENT WHERE IDEVENT =" + eventid;
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(cmd2);
                rs2.next();
                Event e = new Event(eventid);
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

    public static boolean saveLocation(Location l) {
        boolean success = false;
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "UPDATE location SET abbreviation='" + l.getBuildingAbbrev()
                    + "',building='" + l.getFullName() + "',address='" + l.getAddress() + "',room='" + l.getRoomNumber()
                    + "'WHERE location_id = '" + l.getId() + "'";

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

    public static String registerEventLocation(Event e, Location l) {
        String success = "An error has occurred.";
        int rowsUpdated = 0;
        try {

            conn = DriverManager.getConnection(url);
            String cmd = "INSERT INTO RESERVATION VALUES(" + e.getId() + ",'" + l.getId() + "')";

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
