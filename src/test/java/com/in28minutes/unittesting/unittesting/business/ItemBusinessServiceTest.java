package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
    
    @InjectMocks
    ItemBusinessService business;
    
    @Mock
    ItemRepository repository;
    
    @Test
    public void retrieveHardcodedItem_basic(){
        Item item = business.retrieveHardcodedItem();
        assertEquals(0, item.getValue());
    }
    
    @Test
    public void retrieveAllItems_basic(){
        when(repository.findAll())
                .thenReturn(Arrays.asList(new Item(2, "Item 2", 10, 10), new Item(3, "Item 3", 1, 10)));
        List<Item> items = business.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(10, items.get(1).getValue());
    }
    
}
