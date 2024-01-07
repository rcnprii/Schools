package project.is.school;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import project.is.school.dto.Schools;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

//    public static void main (String[] args) throws Exception {
//        Parser parse = new Parser();
//        System.out.println(parse.parseCsv("Школы.csv"));
//    }

    public List<Schools> parseCsv(String filename) throws IOException, CsvException{
        List<String[]> lines = readAllLines(Path.of(filename));
        return lines.stream().map(Schools::new).collect(Collectors.toList());
    }

    public List<String[]> readAllLines(Path filePath)
            throws IOException, CsvException {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                var headers = csvReader.readNext();
                System.out.println("Skipped headers:" + Arrays.toString(headers));
                return csvReader.readAll();
            }
        }
    }

}
