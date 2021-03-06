package org.example;


import org.junit.jupiter.api.Test;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.util.List;

@Configuration
@Profile("test")
public class TestDBInitializer {

    private final dummyRepository DummyRepository;

    public TestDBInitializer(dummyRepository Dummyrepository) {
        this.DummyRepository = Dummyrepository; }


    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        DummyRepository.saveAll(
                List.of(
                        new dummy("shit"),
                        new dummy("shitagain")
                )
        );
    }
}
