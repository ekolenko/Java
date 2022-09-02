package homewrok_1;

import java.util.ArrayList;

/**
 * Задача. Рекурсивно найти все маршруты из a -> b , если действие k1 означает
 * увеличить в с раз, а действие k2 - прибавить d.
 */
public class program {

    static ArrayList<String> arr = new ArrayList<String>();

    static void findWay(int a, int b, int c, int d, String way) {

        if (a == b) {
            arr.add(way);
            return;
        } else if (a > b) {
            return;
        } else {
            findWay(a * c, b, c, d, way + "k1 ");
            findWay(a + d, b, c, d, way + "k2 ");
        }

    }

    static String minWay(ArrayList<String> arr) {

        String minWay = arr.get(0);

        for (String elem : arr) {

            if (elem.length() < minWay.length()) minWay = elem;

        }
        return minWay;
    }

    public static void main(String[] args) {

        int a = 6;
        int b = 78;
        int c = 3;
        int d = 5;
        findWay(a, b, c, d, "");

        if (arr.isEmpty())
            System.out.println("Маршруты не найдены!");
        else {

            StringBuilder strOut = new StringBuilder();

            strOut.append("Все доступные маршруты:\n\n");

            for (String elem : arr) {

                strOut.append(elem);
                strOut.append("\n");

            }

            strOut.append("\n");

            strOut.append("Самый быстрый маршрут:\n\n");
            strOut.append(minWay(arr));
            System.out.println(strOut);
        }
    }
}