package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser stateCensusAnalyser;
    private String Correctpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\IndiaStateCensusData";
    private String Wrongpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\test\\java\\com\\bridgelabz\\StateCensusAnalyserTest.java";
    private String Wrongfiletype = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\test\\java\\com\\bridgelabz\\StateCensusAnalyserTest.java";

    @BeforeAll
    public void setup() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = stateCensusAnalyser.loadData(Correctpath);
        Assertions.assertEquals(18, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(Wrongpath);
        }
        catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.ExceptionType.Wrongfile,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(Wrongfiletype);
        }
        catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(e.type,CustomException.ExceptionType.Wrongfiletype);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception() {
        try {
            stateCensusAnalyser.loadData(Correctpath);
        }
        catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongfiledelimiter);
        }
    }
}