package com.booleanuk.core;

import com.booleanuk.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CoreTest {

    private final PrintStream standardOut = System.out;
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return outputStreamCaptor.toString().trim();
    }

    @Test
    public void testMenuOptions() {
        Main main = new Main();

        main.menu();

        Assertions.assertEquals("Welcome to the menu \n Here are the different functions: \n  1. Choose random student \n 2. Output list of randomly chosen pairs \n 3. Output random list of peer groups \n 4. Current students", getOutput());

    }


/*    @Test
    public void testProgramRuns() {
        Main main = new Main();

        Main.main(new String[0]);
        provideInput("q");

        //Assertions.assertEquals("q", getOutput());


    }*/

    public void testGetRandomStudent() {
        Main main = new Main();

        String randomStudent = main.getRandomStudent();
    }

}
