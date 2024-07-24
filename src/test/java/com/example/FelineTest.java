package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgument() {
        Assert.assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline felineSpy = Mockito.spy(feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(felineSpy).getFood("Хищник");
        Assert.assertEquals(expectedFood, felineSpy.eatMeat());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, feline.getFood("Хищник"));
    }
}
