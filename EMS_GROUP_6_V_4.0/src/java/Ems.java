
import domain.Client;
import javax.faces.bean.ManagedBean;
import domain.Event;
import domain.Person;
import domain.Location;
import java.util.List;
import java.util.LinkedList;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stephen
 */
@ManagedBean
@SessionScoped
public class Ems {

    private List<String> eventList = new LinkedList<String>();
    private List<String> personList = new LinkedList<String>();
    private List<String> clientList = new LinkedList<String>();
    private List<String> locationList = new LinkedList<String>();
    private List<Event> attendingList = new LinkedList<Event>();
    private List<Person> eventAttendingList = new LinkedList<Person>();
    private List<Event> organizingList = new LinkedList<Event>();
    private Event selectedEvent;
    private Location selectedLocation;
    private String selectedEventId;
    private Person selectedPerson;
    private Client selectedClient;
    private String selectedPersonName;
    private String selectedClientName;
    private String selectedLocationName;
    private String selectedPersonString = "No User Selected";
    private String selectedEventString = "No Event Selected";
    private String selectedLocationString = "No Location Selected";
    private String inputPersonUpdateEmail;
    private String inputPersonUpdatePassword;
    private String inputPersonUpdatePasswordRe;
    private String inputPersonFirstName;
    private String inputPersonLastName;
    private String inputPersonMiddleName;
    private String inputClientUpdateEmail;
    private String inputClientUpdatePassword;
    private String inputClientUpdatePasswordRe;
    private String inputClientFirstName;
    private String inputClientLastName;
    private String inputClientMiddleName;
    private String inputLocationAddress;
    private String inputLocationBuildingAbbrev;
    private String inputLocationRoomNumber;
    private String inputLocationFullName;
    private String inputEventDescription;
    private String inputEventStartTime;
    private String inputEventEndTime;
    private String inputEventDate;
    private String inputEventName;
    private String inputEventCost;
    private String inputEventAdmission;
    private String inputEventLocation;
    private String message = ""; /*this message goes on every webpage and can be
     *manipulated to show all the possible messages 
     *we wish to display.
     */
    private String selectedLocationId;


    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInputEventAdmission() {
        return inputEventAdmission;
    }

    public void setInputEventAdmission(String inputEventAdmission) {
        this.inputEventAdmission = inputEventAdmission;
    }

    public String getInputEventCost() {
        return inputEventCost;
    }

    public void setInputEventCost(String inputEventCost) {
        this.inputEventCost = inputEventCost;
    }

    public String getInputClientFirstName() {
        return inputClientFirstName;
    }

    public void setInputClientFirstName(String inputClientFirstName) {
        this.inputClientFirstName = inputClientFirstName;
    }

    public String getInputClientLastName() {
        return inputClientLastName;
    }

    public void setInputClientLastName(String inputClientLastName) {
        this.inputClientLastName = inputClientLastName;
    }

    public String getInputClientMiddleName() {
        return inputClientMiddleName;
    }

    public void setInputClientMiddleName(String inputClientMiddleName) {
        this.inputClientMiddleName = inputClientMiddleName;
    }

    public String getInputClientUpdateEmail() {
        return inputClientUpdateEmail;
    }

    public void setInputClientUpdateEmail(String inputClientUpdateEmail) {
        this.inputClientUpdateEmail = inputClientUpdateEmail;
    }

    public String getInputClientUpdatePassword() {
        return inputClientUpdatePassword;
    }

    public void setInputClientUpdatePassword(String inputClientUpdatePassword) {
        this.inputClientUpdatePassword = inputClientUpdatePassword;
    }

    public String getInputClientUpdatePasswordRe() {
        return inputClientUpdatePasswordRe;
    }

    public void setInputClientUpdatePasswordRe(String inputClientUpdatePasswordRe) {
        this.inputClientUpdatePasswordRe = inputClientUpdatePasswordRe;
    }

    public String getInputLocationAddress() {
        return inputLocationAddress;
    }

    public void setInputLocationAddress(String inputLocationAddress) {
        this.inputLocationAddress = inputLocationAddress;
    }

    public String getInputLocationBuildingAbbrev() {
        return inputLocationBuildingAbbrev;
    }

    public void setInputLocationBuildingAbbrev(String inputLocationBuildingAbbrev) {
        this.inputLocationBuildingAbbrev = inputLocationBuildingAbbrev;
    }

    public String getInputLocationFullName() {
        return inputLocationFullName;
    }

    public void setInputLocationFullName(String inputLocationFullName) {
        this.inputLocationFullName = inputLocationFullName;
    }

    public String getInputLocationRoomNumber() {
        return inputLocationRoomNumber;
    }

    public void setInputLocationRoomNumber(String inputLocationRoomNumber) {
        this.inputLocationRoomNumber = inputLocationRoomNumber;
    }

    public String getInputPersonFirstName() {
        return inputPersonFirstName;
    }

    public void setInputPersonFirstName(String inputPersonFirstName) {
        this.inputPersonFirstName = inputPersonFirstName;
    }

    public String getInputPersonLastName() {
        return inputPersonLastName;
    }

    public void setInputPersonLastName(String inputPersonLastName) {
        this.inputPersonLastName = inputPersonLastName;
    }

    public String getInputPersonMiddleName() {
        return inputPersonMiddleName;
    }

    public void setInputPersonMiddleName(String inputPersonMiddleName) {
        this.inputPersonMiddleName = inputPersonMiddleName;
    }

    public String getInputPersonUpdateEmail() {
        return inputPersonUpdateEmail;
    }

    public void setInputPersonUpdateEmail(String inputPersonUpdateEmail) {
        this.inputPersonUpdateEmail = inputPersonUpdateEmail;
    }

    public String getInputPersonUpdatePassword() {
        return inputPersonUpdatePassword;
    }

    public void setInputPersonUpdatePassword(String inputPersonUpdatePassword) {
        this.inputPersonUpdatePassword = inputPersonUpdatePassword;
    }

    public String getInputPersonUpdatePasswordRe() {
        return inputPersonUpdatePasswordRe;
    }

    public void setInputPersonUpdatePasswordRe(String inputPersonUpdatePasswordRe) {
        this.inputPersonUpdatePasswordRe = inputPersonUpdatePasswordRe;
    }

    public Client getSelectedClient() {
        int x = 0;
        for (int i = 0; i < selectedClientName.length(); i++) {
            if ((selectedClientName.charAt(i)) == ' ') {
                x = i;
                break;
            }
        }

        String idNum = selectedClientName.substring(0, x);
        int selectedIntClientName = Integer.parseInt(idNum);
        Client p = db.Clients.getClient(selectedIntClientName);
        this.setSelectedClient(p);
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public String getSelectedClientName() {
        return selectedClientName;
    }

    public void setSelectedClientName(String selectedClientName) {
        this.selectedClientName = selectedClientName;
    }

    public String getSelectedLocationId() {
        return selectedLocationId;
    }

    public void setSelectedLocationId(String selectedLocationId) {
        this.selectedLocationId = selectedLocationId;
    }

    public Location getSelectedLocation() {
        int x = 0;
        for (int i = 0; i < selectedLocationId.length(); i++) {
            if ((selectedLocationId.charAt(i)) == ' ') {
                x = i;
                break;
            }
        }

        String idNum = selectedLocationId.substring(0, x);
        int selectedIntLocationId = Integer.parseInt(idNum);
        Location e = db.Locations.getLocation(selectedIntLocationId);
        this.setSelectedLocation(e);
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getSelectedLocationString() {
        return selectedLocationString;
    }

    public void setSelectedLocationString(String selectedLocationString) {
        this.selectedLocationString = selectedLocationString;
    }

    public String getInputFirstName() {
        return inputPersonFirstName;
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputPersonFirstName = inputFirstName;
    }

    public String getInputLastName() {
        return inputPersonLastName;
    }

    public void setInputLastName(String inputLastName) {
        this.inputPersonLastName = inputLastName;
    }

    public String getInputMiddleName() {
        return inputPersonMiddleName;
    }

    public void setInputMiddleName(String inputMiddleName) {
        this.inputPersonMiddleName = inputMiddleName;
    }

    public String getInputUpdateEmail() {
        return inputPersonUpdateEmail;
    }

    public void setInputUpdateEmail(String inputUpdateEmail) {
        this.inputPersonUpdateEmail = inputUpdateEmail;
    }

    public String getInputUpdatePassword() {
        return inputPersonUpdatePassword;
    }

    public void setInputUpdatePassword(String inputUpdatePassword) {
        this.inputPersonUpdatePassword = inputUpdatePassword;
    }

    public String getInputUpdatePasswordRe() {
        return inputPersonUpdatePasswordRe;
    }

    public void setInputUpdatePasswordRe(String inputUpdatePasswordRe) {
        this.inputPersonUpdatePasswordRe = inputUpdatePasswordRe;
    }

    public String getInputEventDate() {
        return inputEventDate;
    }

    public void setInputEventDate(String inputEventDate) {
        this.inputEventDate = inputEventDate;
    }

    public String getInputEventDescription() {
        return inputEventDescription;
    }

    public void setInputEventDescription(String inputEventDescription) {
        this.inputEventDescription = inputEventDescription;
    }

    public String getInputEventEndTime() {
        return inputEventEndTime;
    }

    public void setInputEventEndTime(String inputEventEndTime) {
        this.inputEventEndTime = inputEventEndTime;
    }

    public String getInputEventName() {
        return inputEventName;
    }

    public void setInputEventName(String inputEventName) {
        this.inputEventName = inputEventName;
    }

    public String getInputEventStartTime() {
        return inputEventStartTime;
    }

    public void setInputEventStartTime(String inputEventStartTime) {
        this.inputEventStartTime = inputEventStartTime;
    }

    /** Creates a new instance of Ems */
    public Ems() {
    }

    public String getSelectedLocationName() {
        return selectedLocationName;
    }

    public void setSelectedLocationName(String selectedLocationName) {
        this.selectedLocationName = selectedLocationName;
    }

    public String getInputEventLocation() {
        return inputEventLocation;
    }

    public void setInputEventLocation(String inputEventLocation) {
        this.inputEventLocation = inputEventLocation;
    }

    
    public List<Person> getEventAttendingList() {
        
        List<Person> list = db.Events.getGuests(selectedEvent);
        this.setEventAttendingList(list);
        return eventAttendingList;
    }

    public void setEventAttendingList(List<Person> eventAttendingList) {
        this.eventAttendingList = eventAttendingList;
    }

    public List<String> getClientList() {
        this.setMessage("");
        this.setClientList(this.getClients());
        return clientList;
    }

    public void setClientList(List<String> clientList) {
        this.clientList = clientList;
    }
    

    public List<String> getLocationList() {
        this.setMessage("");
        this.setLocationList(this.getLocations());
        return locationList;
    }

    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
    }

    public List<Event> getOrganizingList() {
        List<Event> list = db.Clients.getOrganizingEvents(selectedClient);
        this.setOrganizingList(list);
        return organizingList;
    }

    public void setOrganizingList(List<Event> organizingList) {
        this.organizingList = organizingList;
    }

    public List<Event> getAttendingList() {
        List<Event> list = db.Persons.getAttendingEvents(selectedPerson);
        this.setAttendingList(list);
        return attendingList;
    }

    public void setAttendingList(List<Event> attendingList) {
        this.attendingList = attendingList;
    }

    public String getSelectedEventString() {
        this.setSelectedEventString(selectedEvent.toString());
        return selectedEventString;
    }

    public void setSelectedEventString(String selectedEventString) {
        this.selectedEventString = selectedEventString;
    }

    public String getSelectedPersonString() {
        this.setSelectedPersonString(selectedPerson.toString());
        return selectedPersonString;
    }

    public void setSelectedPersonString(String selectedPersonString) {
        this.selectedPersonString = selectedPersonString;
    }

    public String getSelectedPersonName() {
        return selectedPersonName;
    }

    public void setSelectedPersonName(String selectedPersonName) {
        this.selectedPersonName = selectedPersonName;
    }

    public List<String> getPersonList() {
        this.setMessage("");
        this.setPersonList(this.getPersons());
        return personList;
    }

    public void setPersonList(List<String> personList) {
        this.personList = personList;
    }

    public Person getSelectedPerson() {
        int x = 0;
        for (int i = 0; i < selectedPersonName.length(); i++) {
            if ((selectedPersonName.charAt(i)) == ' ') {
                x = i;
                break;
            }
        }

        String idNum = selectedPersonName.substring(0, x);
        int selectedIntPersonName = Integer.parseInt(idNum);
        Person p = db.Persons.getPerson(selectedIntPersonName);
        this.setSelectedPerson(p);
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
    

    public String getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(String selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public Event getSelectedEvent() {
        int x = 0;
        for (int i = 0; i < selectedEventId.length(); i++) {
            if ((selectedEventId.charAt(i)) == ' ') {
                x = i;
                break;
            }
        }

        String idNum = selectedEventId.substring(0, x);
        int selectedIntEventId = Integer.parseInt(idNum);
        Event e = db.Events.getEvent(selectedIntEventId);
        this.setSelectedEvent(e);
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {

        this.selectedEvent = selectedEvent;
    }

    public List<String> getEventList() {
        this.setEventList(this.getEvents());
        return eventList;
    }

    public void setEventList(List<String> eventList) {
        this.eventList = eventList;
    }

    public List<String> getEvents() {
        return db.Events.getEvents();
    }

    public List<String> getPersons() {
        return db.Persons.getPersons();
    }

    public void doRegister() {
        if (!attendingList.contains(selectedEvent)) {
            message = db.Persons.registerPerson(selectedEvent, getSelectedPerson());
        } else {
            message = "User is already registered.";
        }
    }
    
    public void doReserve(){
        if(!organizingList.contains(selectedEvent)){
            message = db.Clients.registerClient(selectedEvent, selectedClient);
        } else {
            message = "Client has already registered this event.";
        }
    }
    public void newEvent(){
        boolean success = db.Events.addEvent(inputEventStartTime, inputEventEndTime, inputEventDescription, inputEventName, inputEventDate, inputEventCost, inputEventAdmission);
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void newLocation(){
        boolean success = db.Locations.addLocation(inputLocationBuildingAbbrev ,inputLocationFullName ,inputLocationAddress ,inputLocationRoomNumber  );
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void newClient(){
        if (!inputClientUpdatePassword.equals("") && !inputClientUpdatePasswordRe.equals("")) {
            if (inputClientUpdatePassword.equals(inputClientUpdatePasswordRe)) {
                boolean success = db.Clients.addClient(inputClientUpdatePassword, inputClientUpdateEmail, inputClientFirstName, inputClientMiddleName, inputClientLastName);
                if(success){
                    setMessage("Success!");
                } else {
                    setMessage("Error saving information.");
                }
            } else {
                setMessage("Passwords do not match.");
            }
        } else {
            setMessage("You must input a password");
        }
    }
    public void newPerson(){
        if (!inputPersonUpdatePassword.equals("") && !inputPersonUpdatePasswordRe.equals("")) {
            if (inputPersonUpdatePassword.equals(inputPersonUpdatePasswordRe)) {
                boolean success = db.Persons.addPerson(inputPersonUpdatePassword, inputPersonUpdateEmail, inputPersonFirstName, inputPersonMiddleName, inputPersonLastName);
                if(success){
                    setMessage("Success!");
                } else {
                    setMessage("Error saving information.");
                }
            } else {
                setMessage("Passwords do not match.");
            }
        } else {
            setMessage("You must input a password");
        }
    }
    
    public void deleteClient(){
        boolean success = db.Clients.removeClient(selectedClient);
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void deletePerson(){
        boolean success = db.Persons.removePerson(selectedPerson);
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void deleteLocation(){
        boolean success = db.Locations.removeLocation(selectedLocation);
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void deleteEvent(){
        boolean success = db.Events.removeEvent(selectedEvent);
        if(success){
            setMessage("Success!");
        } else {
            setMessage("Error saving information.");
        }
    }
    
    public void doSave() {
        if (!inputPersonUpdateEmail.equals("")) {
            selectedPerson.setEmail(inputPersonUpdateEmail);//Throwing Null Pointer Exception
        }
        if (!inputPersonUpdatePassword.equals("") && !inputPersonUpdatePasswordRe.equals("")) {
            if (inputPersonUpdatePassword.equals(inputPersonUpdatePasswordRe)) {
                selectedPerson.setPassword(inputPersonUpdatePassword);
            } else if (!inputPersonUpdatePassword.equals(inputPersonUpdatePasswordRe)) {
                this.setMessage("Password Mismatch!");
                return;
            }
        } else if (!inputPersonUpdatePassword.equals(inputPersonUpdatePasswordRe)) {
            this.setMessage("Password Mismatch!");
            return;
        }
        if (!inputPersonFirstName.equals("")) {
            selectedPerson.setFirstName(inputPersonFirstName);
        }
        if (!inputPersonLastName.equals("")) {
            selectedPerson.setLastName(inputPersonLastName);
        }
        if (!inputPersonMiddleName.equals("")) {
            selectedPerson.setMiddleName(inputPersonMiddleName);
        }
        boolean success = db.Persons.savePerson(selectedPerson);
        if (success) {
            setMessage("Success!");

        } else {
            setMessage("Error saving information.");
        }
    }

    private List<String> getLocations() {
        return db.Locations.getLocations();
    }

    private List<String> getClients() {
        return db.Clients.getClients();
    }
}
