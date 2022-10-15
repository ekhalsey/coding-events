package org.launchcode.codingevents.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    private int id;
    private static int nextId = 1;

    public Event(){};
    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        this.contactEmail = contactEmail;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

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
