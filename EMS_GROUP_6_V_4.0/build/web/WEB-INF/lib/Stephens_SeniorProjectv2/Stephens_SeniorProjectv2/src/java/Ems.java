
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
    private List<String> locationList = new LinkedList<String>();
    private List<Event> attendingList = new LinkedList<Event>();
    private List<Event> organizingList = new LinkedList<Event>();
    private Event selectedEvent;
    private Location selectedLocation;
    private int selectedEventId;
    private Person selectedPerson;
    private Client selectedClient;
    private String selectedPersonName;
    private String selectedClientName;
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
    
    
    private String message = "";

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Location getSelectedLocation() {
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

        String first = selectedPersonName.substring(0, x);
        String last = selectedPersonName.substring(x + 1);
        Person p = db.Persons.getPerson(first, last);
        this.setSelectedPerson(p);
        return selectedPerson;
    }

    public void setSelectedPerson(Person slectedPerson) {
        this.selectedPerson = slectedPerson;
    }

    public int getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(int selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public Event getSelectedEvent() {
        Event e = db.Events.getEvent(selectedEventId);
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
            message = db.Persons.registerPerson(selectedEvent, selectedPerson);
        } else {
            message = "User is already registered.";
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
}
