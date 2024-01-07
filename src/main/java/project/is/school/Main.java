package project.is.school;

import project.is.school.dto.Schools;

import java.util.List;

public class Main {
    public static void main (String[] args) throws Exception{
        Parser parse = new Parser();
        List<Schools> school = parse.parseCsv("Школы.csv");
        //System.out.println(parse.parseCsv("Школы.csv"));

        database db = new database();
        db.openConnection("is");
        db.saveSchools(school);

        // Вывод среднего значения расходов
        db.printAverageExpenditureByCountries();

        // Вывод учебного заведения с заданными критериями
        db.printSchoolsWithCriteria();

        // Расчет    среднего количества студентов по странамecho "# Project_schools_java" >> README.md
        db.calculateAverageStudentsByCountry();
        db.close();
    }
}
