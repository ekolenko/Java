package homework_3;

/** 
 *  Написать программу, показывающую последовательность 
 *  действий для игры “Ханойская башня” 
 */

public class Program_1 {

    public static void hanoi(String from, String to, String buf, int count) {

        if (count > 1)
            hanoi(from, buf, to, count - 1);
        System.out.printf("%s >> %s%n", from, to);
        if (count > 1)
            hanoi(buf, to, from, count - 1);

    }

    public static void main(String[] args) {

        hanoi("1", "3", "2", 4);

    }

}
