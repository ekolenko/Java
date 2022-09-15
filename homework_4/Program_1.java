import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Написать программу, определяющую правильность расстановки скобок в выражении.
 */
public class Program_1 {

    static void initDict(HashMap<Character, Character> dict) {

        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
    }

    static int checkStr(String str) {

        LinkedList<Character> stck = new LinkedList<Character>();
        HashMap<Character, Character> dict = new HashMap<Character, Character>();

        initDict(dict);

        int n = str.length();

        for (int i = 0; i < n; i++) {

            Character chr = str.charAt(i);

            if (dict.containsValue(chr)) {
                stck.addLast(chr);
            } else if (dict.containsKey(chr)) {
                if (!stck.isEmpty() && stck.getLast() == dict.get(chr)) {
                    stck.removeLast();
                } else {
                    return i;
                }
            }
        }

        if (stck.isEmpty())
            return 0;

        return n;
    }

    static void printErrorPos(int pos) {

        StringBuilder strOut = new StringBuilder();

        for (int i = 0; i < pos; i++) {
            strOut.append(' ');
        }
        strOut.append('^');
        strOut.append("\nВ выражении допущена ошибка!");

        System.out.println(strOut);
    }

    public static void main(String[] args) {

        System.out.println("Введите выражение:");
        Scanner scnr = new Scanner(System.in);       

        int checked = checkStr(scnr.nextLine());
        scnr.close();

        if (checked > 0)
            printErrorPos(checked);
        else
            System.out.println(
                    "Выражение корректно");
        
    }
}
