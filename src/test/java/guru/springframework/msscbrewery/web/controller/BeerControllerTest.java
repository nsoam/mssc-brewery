package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.service.BeerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.UUID;


import static javax.swing.UIManager.get;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {
    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setUp() {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getBeer() throws Exception{
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

//        mockMvc.perform(get("/api/v1/beer" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status.isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
//                .andExpect()
    }


}
