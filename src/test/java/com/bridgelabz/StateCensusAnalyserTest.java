package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser stateCensusAnalyser;
    private String  path="C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\main\\java\\com\\bridgelabz\\StateCensusAnalyser.java";

    @BeforeAll
    public void setup() {
        stateCensusAnalyser=new StateCensusAnalyser();
    }

    @Test
    void checkDataIsLoaded() {
        int size=stateCensusAnalyser.loadData(path);
        System.out.println(size);
        Assertions.assertEquals(30,size);
    }
}