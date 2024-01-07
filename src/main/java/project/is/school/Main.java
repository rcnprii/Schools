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
        db.AverageExpenditureByCountries();

        // Вывод учебного заведения с заданными критериями
        db.SchoolsByCriteria();

        // Расчет среднего количества студентов по странам
        db.calculateAverageStudentsByCountry();
        db.close();
    }
}
