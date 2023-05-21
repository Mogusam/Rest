package org.jgmp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.jgmp.Event;
import org.jgmp.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
        @RequestMapping("/event")
public class EventController {
    @Autowired
    private EventServiceImpl service;


    @GetMapping("/{Id}")
    public HttpEntity<Event> getById(@PathVariable("Id") Integer id) {
         var res =   service.getEvent(id);
         res.add(getLinkGetAll());
         res.add(getLinkDelete(id));
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Event> getAll(){
       return service.getAllEvents();
    }

    @GetMapping("/byTitle/{title}")
    public List<Event> getByTitle(@PathVariable("title") String title){
       return service.getAllEventsByTitle(title);
    }

    @PostMapping("/create")
    public HttpEntity<Event> create(@RequestBody Event event){
      var res =  service.createEvent(event);
      res.add(getLinkGet(res.getId()));
      res.add(getLinkDelete(res.getId()));
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public void update(@RequestBody Event event){
       service.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> delete(@PathVariable("id") Integer id){
         service.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private static Link getLinkGetAll() {
        return linkTo(methodOn(EventController.class).getAll()).withSelfRel().withName("get All");
    }

    private static Link getLinkDelete(Integer id) {
        return linkTo(methodOn(EventController.class)
                .delete(id))
                .withSelfRel()
                .withTitle("delete by Id");
    }

    private static Link getLinkCreate(Integer id) {
        return linkTo(methodOn(EventController.class).create(null)).withSelfRel();
    }
    private static Link getLinkGet(Integer id) {
        return linkTo(methodOn(EventController.class).getById(id))
                .withSelfRel()
                .withTitle("get Event by Id");
    }

}
