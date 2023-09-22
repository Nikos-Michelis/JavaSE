package com.nick.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void swapTest() {
        int [] array = {1,2,3,4};
        try{
            Main.swap(array, 0,2);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bound");
        }
        assertEquals(array[0], 3);
        assertEquals(array[2], 1);
    }
}