package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    @NotBlank(message = "name is required")
    @Size(min=3, max=50, message = "name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message="email is required")
    @Email(message = "Invalid Email. Try again.")
    private String contactEmail;

    @NotBlank(message= "this field is required")
    private String location;

    @AssertTrue
    private boolean registrationRequired;

    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    private EventType type;

    private int id;
    private static int nextId = 1;

    public Event(){
        this.id = nextId;
        nextId++;
    };

    public Event(String name, String description, String contactEmail, String location, boolean registrationRequired, int numberOfAttendees, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.numberOfAttendees = numberOfAttendees;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getContactEmail() {return contactEmail;}
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {return id;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public boolean isRegistrationRequired() {return registrationRequired;}
    public void setRegistrationRequired(boolean registrationRequired) {this.registrationRequired = registrationRequired;}

    public int getNumberOfAttendees() {return numberOfAttendees;}
    public void setNumberOfAttendees(int numberOfAttendees) {this.numberOfAttendees = numberOfAttendees;}

    public EventType getType() {return type;}

    public void setType(EventType type) {this.type = type;}

    @Override
    public String toString() {
        return "toString is:" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
