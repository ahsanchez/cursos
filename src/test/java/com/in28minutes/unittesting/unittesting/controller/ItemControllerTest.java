package com.in28minutes.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.ItemController;
import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ItemBusinessService businessService;
    
    @Test
    public void dummyItem_basic() throws Exception{
        RequestBuilder request =
                MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON_VALUE);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"quantity\":100,\"price\":10,\"name\":\"Ball\",\"id\":1}"))
                .andReturn();
    }
    
    @Test
    public void itemFromBusinessService_basic() throws Exception{
        
        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item 2", 10, 10));
        
        RequestBuilder request =
                MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON_VALUE);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, \"name\": \"Item 2\", price:10, quantity: 10}"))
                .andReturn();
    }
    
}
