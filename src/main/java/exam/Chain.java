package exam;

import java.io.IOException;
import java.util.Scanner;

public class Chain {

    public static int division() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите числитель: ");
        int numerator = sc.nextInt();
        System.out.print("Введите знаменатель: ");
        int denominator = sc.nextInt();
        try {
            return numerator % denominator;
        }catch (ArithmeticException ex){
            throw new IOException("Пользователь ввёл 0 в качестве знаменателя", ex);
        }
    }


    public static int division1() throws Throwable {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите числитель: ");
        int numerator = sc.nextInt();
        System.out.print("Введите знаменатель: ");
        int denominator = sc.nextInt();
        try {
            return numerator % denominator;
        }catch (ArithmeticException ex){
            throw ex.initCause(new IOException("Пользователь ввёл 0 в качестве знаменателя", ex));
        }
    }

    public static int example(int[] numerators, int[] denominators){
        int rez = 0;
        for (int i = 0; i < numerators.length; i++){
            try{
                rez += numerators[i] % denominators[i];
            }catch (ArithmeticException aex){
                aex.initCause(new IOException("Знаменатель " + i +" равен нулю"));
                throw aex;
            }catch (IndexOutOfBoundsException iex){
                iex.initCause(new IOException("Количество числителей не равно количеству знаменателей"));
                throw iex;
            }
        }
        return rez;
    }

    public static void main(String[] args) throws Throwable {
        int[] num = new int[] {143, 245, 398, 454, 599};
        int[] den = new int[] {5, 12, 54, 22, 43};
        System.out.println(example(num, den));
    }
}
