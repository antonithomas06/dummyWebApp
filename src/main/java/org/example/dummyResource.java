package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/resources/dummy")
public class dummyResource {
    private final dummyRepository DummyRepository;

    public dummyResource(dummyRepository DummyRepository) {
        this.DummyRepository = DummyRepository;
    }

    @GetMapping
    public List<dummy> retrieveAll() {
        return DummyRepository.findAll();
    }
}
