package project.is.school;

import project.is.school.dto.Schools;

import java.sql.*;
import java.util.List;

public class database {

    public static final String SAVE_SCHOOL = "INSERT INTO SCHOOLS (id, district,school, " +
            "country,grades,students,teachers,calworks,lunch,computer," +
            "expenditure,income,english,read,math) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    Connection conn;
    public void close() throws SQLException{
        conn.close();
    }
    public void openConnection(String dbFilname) throws SQLException {
        // db parameters
        String url = "jdbc:sqlite:"+dbFilname+ ".db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);
    }

    public void saveSchools(List<Schools> schoolsList) throws SQLException{
        try(PreparedStatement pstms = conn.prepareStatement(SAVE_SCHOOL)){
            for (Schools schools : schoolsList) {
                try {
                    pstms.setInt(1, schools.getId());
                    pstms.setInt(2, schools.getDistrict());
                    pstms.setString(3, schools.getSchool());
                    pstms.setString(4, schools.getCountry());
                    pstms.setString(5, schools.getGrades());
                    pstms.setInt(6, schools.getStudents());
                    pstms.setDouble(7, schools.getTeachers());
                    pstms.setLong(8, schools.getCalworks());
                    pstms.setLong(9, schools.getLunch());
                    pstms.setLong(10, schools.getComputer());
                    pstms.setLong(11, schools.getExpenditure());
                    pstms.setLong(12, schools.getIncome());
                    pstms.setLong(13, schools.getEnglish());
                    pstms.setLong(14, schools.getRead());
                    pstms.setLong(15, schools.getMath());
                    pstms.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //conn.commit();
            pstms.executeBatch();

        }
    }
    //задание 2
    public void printAverageExpenditureByCountries() {
        try {
            String query = "SELECT country, AVG(expenditure) as avg_expenditure " +
                    "FROM schools " +
                    "WHERE expenditure > 10 AND country IN ('Fresno', 'Contra Costa', 'El Dorado', 'Glenn') " +
                    "GROUP BY country;";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String country = resultSet.getString("country");
                        double averageExpenditure = resultSet.getDouble("avg_expenditure");

                        System.out.println("Country: " + country + ", Average Expenditure: " + averageExpenditure);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //задание 3

    public void printSchoolsWithCriteria() {
        try {
            String query = "SELECT * FROM schools " +
                    "WHERE students BETWEEN 5000 AND 7500 OR students BETWEEN 10000 AND 11000 " +
                    "ORDER BY math DESC " +
                    "LIMIT 1;";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String schoolName = resultSet.getString("school");
                        int students = resultSet.getInt("students");
                        long mathScore = resultSet.getLong("math");
                        System.out.println("Task 3:");
                        System.out.println("School ID: " + id);
                        System.out.println("School Name: " + schoolName);
                        System.out.println("Number of Students: " + students);
                        System.out.println("Math Score: " + mathScore);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void calculateAverageStudentsByCountry() {
        try {
            String query = "SELECT country, AVG(students) as avg_students " +
                    "FROM schools " +
                    "WHERE country IN ('Alameda', 'Fresno', 'Butte', 'Tulare', 'Los Angeles', 'Ventura', 'Merced', 'Kern', 'Riverside', 'Monterey') " +
                    "GROUP BY country;";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String country = resultSet.getString("country");
                        double averageStudents = resultSet.getDouble("avg_students");
                        System.out.println("Country: " + country + ", Average Students: " + averageStudents);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

