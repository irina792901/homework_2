import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class Bubble_sort_and_logging {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Bubble_sort_and_logging.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
       // logger.log(level.WARNING, "Тестовое логирование");
        logger.info("I did it!");

        int[] array = new int[]{64, 42, 13, 41, 31, 53, 16, 24, 5, 47};
        System.out.println(Arrays.toString(array));
        boolean is_sorted = false;
        while (!is_sorted) {
            is_sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    is_sorted = false;
                    System.out.println(Arrays.toString(array));
                    logger.info(Arrays.toString(array));
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
