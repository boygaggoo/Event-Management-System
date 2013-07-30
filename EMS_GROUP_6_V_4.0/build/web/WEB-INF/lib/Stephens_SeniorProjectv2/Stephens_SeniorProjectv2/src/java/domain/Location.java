package domain;

/**
 *
 * @author Stephen
 */
public class Location {

    private String id;
    private String address;
    private String buildingAbbrev;
    private String roomNumber;
    private String fullName;

    public Location(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildingAbbrev() {
        return buildingAbbrev;
    }

    public void setBuildingAbbrev(String buildingAbbrev) {
        this.buildingAbbrev = buildingAbbrev;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return id + "  " + address + "  " + fullName + "  " + roomNumber;

    }
}
