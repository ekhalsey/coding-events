package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName,
                              @RequestParam String eventDescription) {
        EventData.addEvent(new Event(eventName,eventDescription));
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) { //model isnt model in MVC
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

}
