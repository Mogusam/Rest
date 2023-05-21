package org.jgmp;

import java.time.LocalDate;

import org.jgmp.service.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"org.jgmp.service", "org.jgmp.controller"})
public class DemoApplication {

    @Autowired
    private EventRepository repository;

    public static void main(String[] args) {
        var res = SpringApplication.run(DemoApplication.class, args);

    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("Init DB !");
        Event s = Event.builder()
                .id(2)
                .place("hall")
                .eventType("lecture")
                .title("Sleeping")
                .speaker("William murray")
                .dateTime(LocalDate.MAX).build();
        repository.save(s);
    }

}
