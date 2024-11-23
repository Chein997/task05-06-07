package com.chein.task7.test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import com.chein.task7.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTest {

    @Test
    @DisplayName("Добавление строки")
    public void addString(){
        Collection<String> collection = new Collection<>();
        collection.add("hello");
        collection.add("World!");

        assertNotNull(collection.findByValue("hello"));
        assertNotNull(collection.findByValue("World!"));
    }

    @Test
    @DisplayName("Добавление числа")
    public void addInteger(){
        Collection<Integer> collection = new Collection<>();
        collection.add(869);
        collection.add(324432);
        assertNotNull(collection.findByValue(869));
        assertNotNull(collection.findByValue(90294));
    }

    @Test
    @DisplayName("Удаление последнего элемента")
    public void deleteLastString(){
        Collection<String> collection = new Collection<>();
        collection.add("car");
        collection.add("map");
        collection.add("bag");
        collection.add("bread");
        collection.delete();
        assertEquals("bag", collection.getTail().value);
    }

    @Test
    @DisplayName("Удаление элемента по значению (строка)")
    public void deleteValueString(){
        Collection<String> collection = new Collection<>();
        collection.add("car");
        collection.add("map");
        collection.add("bag");
        collection.add("bread");
        collection.delete("bag");
        assertNull(collection.findByValue("bag"));
    }

    @Test
    @DisplayName("Удаление последнего элемента (число)")
    public void deleteLastInteger(){
        Collection<Integer> collection = new Collection<>();
        collection.add(2432);
        collection.add(21321);
        collection.add(12312);
        collection.add(123121);
        collection.delete();
        assertEquals(12312, collection.getTail().value);
    }

    @Test
    @DisplayName("Удаление элемента по значению (число)")
    public void deleteValueInteger(){
        Collection<Integer> collection = new Collection<>();
        collection.add(2432);
        collection.add(21321);
        collection.add(12312);
        collection.add(123121);
        collection.delete(123121);
        assertNull(collection.findByValue(123121));
    }

    @Test
    @DisplayName("Нахождение элемента в списке(строка)")
    public void findValueString(){
        Collection<String> collection = new Collection<>();
        collection.add("car");
        collection.add("map");
        collection.add("bag");
        collection.add("bread");
        assertNotNull(collection.findByValue("bag"));
    }

    @Test
    @DisplayName("Нахождение элемента в списке(число)")
    public void findValueInteger(){
        Collection<Integer> collection = new Collection<>();
        collection.add(2432);
        collection.add(21321);
        collection.add(12312);
        collection.add(123121);
        assertNotNull(collection.findByValue(12312));
    }




}
