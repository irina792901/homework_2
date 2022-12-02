import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * К калькулятору из предыдущего дз добавить логирование.
 */
public class Calculator_and_logging {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Calculator_and_logging.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        SimpleFormatter sf = new SimpleFormatter();
        ch.setFormatter(sf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double a = sc.nextFloat();
        logger.info(Double.toString(a));
        System.out.println("Введите операцию: /, *, -, +, //, %");
        String operation = sc.next().strip();
        logger.info(operation);
        double b;
        do {
            System.out.println("Введите второе число: ");
            b = sc.nextFloat();
            logger.info(Double.toString(b));
            if ((operation.equals("/") || operation.equals("//")) && b == 0) {
                String msg = "Делить на ноль нельзя!";
                System.out.println(msg);
                logger.warning(msg);
            }
        } while ((operation.equals("/") || operation.equals("//")) && b == 0);
        String msg_res = "Результат: ";
        System.out.print(msg_res);
        switch (operation) {
            case "/":
                System.out.println(a / b);
                logger.info(msg_res + Double.toString(a / b));
                break;
            case "*":
                System.out.println(a * b);
                logger.info(msg_res + Double.toString(a * b));
                break;
            case "-":
                System.out.println(a - b);
                logger.info(msg_res + Double.toString(a - b));
                break;
            case "+":
                System.out.println(a + b);
                logger.info(msg_res + Double.toString(a + b));
                break;
            case "//":
                System.out.println((int) a / b);
                logger.info(msg_res + Integer.toString((int) (a/b)));
            case "%":
                System.out.println(a % b);
                logger.info(msg_res + Double.toString(a % b));
        }
        sc.close();
    }
}

