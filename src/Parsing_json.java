import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * НИЧЕГо НЕ РАБОТАЕТ!!!
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
        try(FileReader fr =new FileReader("db.json"))
        {
            Scanner data =new Scanner(fr);
            String json = data.nextLine();
            StringBuilder result = new StringBuilder();
            String[] pattern ={"Студент "," получил "," по предмету "};
            List<Integer> starts = new ArrayList<>();
            List<Integer> ends = new ArrayList<>();
            List<String> rows = new ArrayList<>();
            for (int i = 0; i < json.length(); i++) {
                if (json.charAt(i)=='{') starts.add(i);
                if (json.charAt(i)=='}') ends.add(i);
            }

            for (int i = 0; i < starts.size(); i++) {
                rows.add(json.substring(starts.get(i)+1, ends.get(i)));
                for (int j = 0; j < starts.size(); j++) {
                    result.append(pattern[j]);
                    result.append(sep(rows.get(i),j));
                }
                result.append('\n');
            }
            System.out.println(result);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static String sep(String str,int index)
    {
        String [] value = str.split(",");
        String [] subvalue = value[index].split(":");
        return (subvalue[1].replace("\"",""));
    }
}
//         //Считываем json
//        Object obj = new JSONParser().parse(jsonString);
//         Object obj = new JSONParser().parse(new FileReader("db.json"));
//        // Кастим obj в JSONObject
//        JSONObject jo = (JSONObject) obj;
//        // Достаём фамилию, оценку и предмет
//        String lastName = (String) jo.get("Фамилия");
//        System.out.println("Студент : " + lastName + " получил " + "оценка" + "по предмету");
///* Если бы был массив в самом объекте
//        JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
//        Iterator phonesItr = phoneNumbersArr.iterator();
//        System.out.println("phoneNumbers:");
//   Выводим в цикле данные массива
//        while (phonesItr.hasNext()) {
//            JSONObject test = (JSONObject) phonesItr.next();
//            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
//            */
//
//        TODO OR NOT TODO...

