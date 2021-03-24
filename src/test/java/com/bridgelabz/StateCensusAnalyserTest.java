package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser stateCensusAnalyser;
    private String Correctpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\IndiaStateCensusData";
    private String Wrongpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\test\\java\\com\\bridgelabz\\StateCensusAnalyserTest.java";

    @BeforeAll
    public void setup() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    @Test
    void checkDataIsLoaded() throws CustomException {
        int size = stateCensusAnalyser.loadData(Correctpath);
        System.out.println(size);
        Assertions.assertEquals(28, size);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(Wrongpath);
        }
        catch (CustomException e) {
            throw new CustomException("Wrong path");
        }
    }
}