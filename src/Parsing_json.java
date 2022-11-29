/**
 * (НЕОБЯЗАТЕЛЬНО) Дана json строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * <p>
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */
public class Parsing_json {
    public static void main(String[] args) {
        // Считываем json
        Object obj = new JSONParser().parse(jsonString);
        // Object obj = new JSONParser().parse(new FileReader("db.json"));
        // Кастим obj в JSONObject
        JSONObject jo = (JSONObject) obj;
        // Достаём фамилиюб оценку и предмет
        String lastName = (String) jo.get("Фамилия");
        System.out.println("Студент : " + lastName + " получил " + "оценка" + "по предмету");
/* Если бы был массив в самом объекте
        JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
        Iterator phonesItr = phoneNumbersArr.iterator();
        System.out.println("phoneNumbers:");
   Выводим в цикле данные массива
        while (phonesItr.hasNext()) {
            JSONObject test = (JSONObject) phonesItr.next();
            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
            */

        //TODO OR NOT TODO...
    }
}

