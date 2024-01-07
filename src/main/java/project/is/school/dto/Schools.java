package project.is.school.dto;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class Schools {
    private Integer id;
    private Integer district;
    private String school;
    private String country;
    private String grades;
    private Integer students;
    private Double teachers;
    private Long calworks;
    private Long lunch;
    private Long computer;
    private Long expenditure;
    private Long income;
    private Long english;
    private Long read;
    private Long math;

    public Schools(String[] csvLine){
        this.id = Integer.parseInt(csvLine[0]);
        this.district = Integer.parseInt(csvLine[1]);
        this.school = csvLine[2];
        this.country = csvLine[3];
        this.grades = csvLine[4];
        this.students = Integer.parseInt(csvLine[5]);
        if (!StringUtils.isEmpty(csvLine[6])){
            this.teachers = Double.parseDouble(csvLine[6]);
        }
        if (!StringUtils.isEmpty(csvLine[7])){
            this.calworks = Long.parseLong(csvLine[7].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[8])){
            this.lunch = Long.parseLong(csvLine[8].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[9])){
            this.computer = Long.parseLong(csvLine[9].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[10])){
            this.expenditure = Long.parseLong(csvLine[10].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[11])){
            this.income = Long.parseLong(csvLine[11].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[12])){
            this.english = Long.parseLong(csvLine[12].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[13])){
            this.read = Long.parseLong(csvLine[13].replaceAll("\\.", ""));
        }
        if (!StringUtils.isEmpty(csvLine[14])){
            this.math = Long.parseLong(csvLine[14].replaceAll("\\.", ""));
        }

    }
}
