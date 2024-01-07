# Project_school_java (Школы)

#1) Класс Schools
Объект для хранения и представления данных о школах.
 Поля класса:
   - id: Идентификатор школы.
   - district: Идентификатор района.
   - school: Название школы.
   - country: Страна, к которой относится школа.
   - grades: Уровни классов, предоставляемые школой.
   - students: Количество студентов в школе.
   - teachers: Количество учителей.
   - calworks, lunch, computer, expenditure, income, english, read, math: Различные показатели школы
   
Конструктор public Schools(String[] csvLine):
Конструктор класса Schools , который принимает массив строк csvLine и используется для создания объекта Schools из Школы.csv.

#2) Класс Parser
Нужен для чтения данных из csv-файла и преобразования их в список объектов класса Schools. 
Метод `parseCsv`: Принимает имя файла в csv формате, читает все строки файла с помощью метода readAllLines, создвет новый объект класса `Schools`для каждой строки файла.
Метод `readAllLines`: Использует CSVReader для чтения всех строк из файла, пропускает первую строку, выводит их в консоль.

#3) Класс `database` 
Предоставляет возможность управление БД SQLite для сохранения данных о школах и выполнения заданных запросов. 
**Метод `close`:** Закрывает соединение с базой данных.
**Метод `openConnection`:** Открывает соединение с базой данных SQLite.
**Метод `saveSchools`:** Принимает список объектов `Schools` и использует  запрос для вставки данных о школах в БД.
**Метод `AverageExpenditureByCountries`:** Выполняет SQL-запрос, рассчитывающий средний расход по странам, где расход больше 10, и выводит результат в консоль.
**Метод `SchoolsByCriteria`:** Выполняет SQL-запрос, выбирая школу с определенными критериями.
**Метод `calculateAverageStudentsByCountry`:** Выполняет SQL-запрос, рассчитывающий среднее количество студентов по странам, и выводит результат в консоль.

