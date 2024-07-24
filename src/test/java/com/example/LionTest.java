package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LionTest {

    private FelineFood feline;
    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        feline = mock(FelineFood.class);
        lionMale = new Lion("Самец", feline);
        lionFemale = new Lion("Самка", feline);
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionConstructorException() throws Exception {
        new Lion("Используйте допустимые значения пола животного - самей или самка", feline);
    }

    @Test
    public void testGetKittens() {
        when(feline.getKittens()).thenReturn(3);
        Assert.assertEquals(3, lionMale.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertEquals(expectedFood, lionMale.getFood());
    }
}