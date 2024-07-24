package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatTest {
    private Cat cat;
    private Feline feline;

    @Before
    public void setUp() {
        feline = mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Assert.assertEquals(expectedFood, cat.getFood());
    }
}