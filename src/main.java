import java.util.MissingFormatWidthException;
import java.util.Scanner;
import java.util.concurrent.Callable;

class Main {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        String input = null;
        Calculator.calc(input);
    }

    static class Calculator {
        static int number1;
        static int number2;
        static String operation;
        static Rome n1;
        static Rome n2;


        public static String calc(String input) throws Exception {
            System.out.println("Input");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] mas = str.split(" ");
            if( mas.length !=3) throw new Exception("Неверный формат ввода. ВВедите через пробел");
            Rome[] r1 = Rome.values();
            boolean flag = false;
            for (Rome el : r1) {
                if (el.name().equalsIgnoreCase(mas[0])) {
                    flag = true;
                }
            }

            if (flag) {
               try { n1 = Rome.valueOf(mas[0]);
                     n2 = Rome.valueOf(mas[2]);
                     operation = mas[1];
                     romeAction(n1, n2, operation);}
               catch  (IllegalArgumentException e)
                   { System.out.println("Неверный формат чисел");}
            } else {
               try{ number1 = Integer.parseInt(mas[0]);
                    operation = mas[1];
                    number2 = Integer.parseInt(mas[2]);
                    arabAction();}
               catch (NumberFormatException e){
                   System.out.println("Неверный формат числел");
               }
            }
            return input;
        }

            static void arabAction () throws Exception{
                System.out.println("Output");
            if (number1 > 0 && number1 <= 10 && number2 > 0 && number2 <= 10)
            throw new Exception("Числа вне диапазона");
            {

                    switch (operation) {
                        case "-":
                            System.out.println(number1 - number2);
                            break;
                        case "+":
                            System.out.println(number1 + number2);
                            break;
                        case "/":
                            System.out.println(number1 / number2);
                            break;
                        case "*":
                            System.out.println(number1 * number2);
                            break;
                        default:
                            throw new Exception("Нет такой операции");
                    }
                }
            }


        static void romeAction(Rome n1, Rome n2, String operation) throws Exception {
            System.out.println("Output");
        int result = 0;

            switch (operation) {
                case "+":
                    result = n1.getValue() + n2.getValue();

                    break;
                case "-":
                    result = n1.getValue() - n2.getValue();
                     if(result<=0); throw new Exception ("Нет отрицательных римских чисел");

                case "/":
                    result = n1.getValue() / n2.getValue();
                    break;
                case "*":
                    result = n1.getValue() * n2.getValue();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }

            Rome[] rome = Rome.values();
            for (Rome rome1 : rome) {
                if (rome1.value == result) {
                    System.out.println(rome1);
                }
            }
        }
    }
    }





