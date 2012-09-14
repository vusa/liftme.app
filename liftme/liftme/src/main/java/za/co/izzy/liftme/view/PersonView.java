package za.co.izzy.liftme.view;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import za.co.izzy.liftme.bean.PersonFacade;
import za.co.izzy.liftme.bean.PlaceFacade;
import za.co.izzy.liftme.model.Person;
import za.co.izzy.liftme.model.Place;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author vusa
 */
@ManagedBean
@RequestScoped
public class PersonView {
    @EJB
    private PersonFacade personFacade;
    @EJB
    private PlaceFacade placeFacade;
    private Person person;
    private Place place;
    private MapModel emptyModel;

    /**
     * Creates a new instance of UsersView
     */
    public PersonView() {
        this.person = new Person();
        this.place = new Place();
        emptyModel = new DefaultMapModel();
    }

    public Person getPerson() {
        return person;
    }

    public Place getPlace(){
        return place;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void addMarker(ActionEvent actionEvent) {
        Marker marker = new Marker(new LatLng(place.getLat(), place.getLng()), place.getName());
        emptyModel.addOverlay(marker);

        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + place.getLat() + ", Lng:" + place.getLng()));
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getNumberOfUsers(){
        return personFacade.count();
    }
    
    public String createUser(){
        person.setFirstName(person.getDisplayName());
        person.setLastName(person.getDisplayName());
        personFacade.create(person);
        place.setOwner(person);
        placeFacade.create(place);
        return "person-created";
    }
    
    public String login(){
        Person authPerson = personFacade.authenticate(person.getEmail(), person.getPassword());
        if(authPerson == null){
            return  "login-failed";
        }
        person = authPerson;
        return "login-success";
    }
}
