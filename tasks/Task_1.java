package tasks;

import java.util.ArrayList;

public class Task_1 {

    static ArrayList<String> arr = new ArrayList<String>();
    static int MaxLength = 0;

    public static void main(String[] args) {

        int[] a = { 1, 3 , 4, 0, 3, 1, 3, 3, 3, 4, 7, 8 ,5, 6, 6, 7, 8};
        int[] b = { 2, 1, 3, 5, 3, 5, 6, 7, 4, 8, 9 };

        solve(a, b, 0, 0, "");

        for (String elem : arr) {

            System.out.println(elem);

        }

        System.out.println(maxWay(arr));

    }

    public static void solve(int[] a, int[] b, int i, int j, String way)

    {
        if (i == a.length - 1 || j == b.length - 1) {

            if (MaxLength < (way + a[i]).length()) {

        
            arr.add(way + a[i]);
            MaxLength = (way + a[i]).length();

            }

            return;

        } else if (i == a.length || j == b.length) {

            return;
        }

        else {

            if (a[i] == b[j]) {

                solve(a, b, i + 1, j + 1, way + a[i]);

            } else {
                solve(a, b, i + 1, j, way);
                solve(a, b, i, j + 1, way);
            }
        }

    }

    static String maxWay(ArrayList<String> arr) {

        String maxWay = arr.get(0);

        for (String elem : arr) {

            if (elem.length() > maxWay.length())
                maxWay = elem;

        }
        return maxWay;
    }
}