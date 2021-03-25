package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser censusAnalyser;
    private String IndianStateCensusDataCorrectpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\IndiaStateCensusData";
    private String Correctpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\IndiaStateCensusData";
    private String Wrongpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\test\\java\\com\\bridgelabz\\StateCensusAnalyserTest.java";
    private String Wrongfiletype = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\test\\java\\com\\bridgelabz\\StateCensusAnalyserTest.java";
    private String IndianStateCodeCorrectpath = "C:\\Users\\dell\\IdeaProjects\\IndianStatesCensusAnalyser\\IndiaStateCode.csv";

    @BeforeAll
    public void setup() {
        censusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCensusData(IndianStateCensusDataCorrectpath);
        Assertions.assertEquals(9, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException {
        try {
            censusAnalyser.loadStateCensusData(Wrongpath);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CustomException.ExceptionType.Wrongfile, e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException {
        try {
            censusAnalyser.loadStateCensusData(Wrongfiletype);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongfiletype);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception() {
        try {
            censusAnalyser.loadStateCensusData(IndianStateCensusDataCorrectpath);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongfiledelimiter);
        }
    }

    @Test
    public void given_wrong_header_should_throw_custom_exception() {
        try {
            censusAnalyser.loadStateCensusData(IndianStateCodeCorrectpath);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongheader);
        }
    }

    @Test
    public void given_correct_path_shold_return_count() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCodeData(IndianStateCodeCorrectpath);
        Assertions.assertEquals(18, numofEnteries);
    }

    @Test
    public void given_wrong_path_should_return_custom_exception() throws CustomException {
        try {
            censusAnalyser.loadStateCodeData(Wrongpath);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CustomException.ExceptionType.Wrongfile, e.type);
        }
    }

    @Test
    public void given_wrong_file_type_throw_custom_exception() throws CustomException {
        try {
            censusAnalyser.loadStateCodeData(Wrongfiletype);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongfiletype);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_exception() throws CustomException {
        try {
            censusAnalyser.loadStateCodeData(IndianStateCodeCorrectpath);
        }
        catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrongfiledelimiter);
        }
    }
}