package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/events")
public class EventController {
    //private static Map<String,String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model ) {
        model.addAttribute("events", EventData.getAll()); //calling static method of class
        return "events/index";
//        events.put("Menteaship","A fun meetup for connecting with mentors");
//        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
//        events.put("Javascripty", "An imaginary meetup for Javascript developers");
//        model.addAttribute("events", events);
//        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if (errors.hasErrors()){
                return "events/create";
        }
        EventData.addEvent(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) { //model isnt model in MVC
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.removeEvent(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getName() + " (id= " + eventToEdit.getId() + ")";
        model.addAttribute("title", title);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(@RequestParam int eventId, @RequestParam(required = false) String name, @RequestParam(required = false) String description) {
        Event eventToEdit = EventData.getById(eventId);
        if (name != "") {
            eventToEdit.setName(name);
        }
        if (description != "") {
            eventToEdit.setDescription(description);
        }
        return "redirect:";
    }
}
