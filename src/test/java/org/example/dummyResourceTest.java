package org.example;


import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class dummyResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRetrieve() throws Exception {
        var requestBuilder =  MockMvcRequestBuilders
                .get("/resources/dummy")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform((RequestBuilder) requestBuilder)
                // variant 1: uses expect methods
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1));
    }

}
