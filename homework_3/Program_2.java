package homework_3;

public class Program_2 {

    public static void makeHeap(int[] a, int i, int n) {

        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[max])
            max = l;
        if (r < n && a[r] > a[max])
            max = r;

        if (max != i) {
            int swap = a[i];
            a[i] = a[max];
            a[max] = swap;
            makeHeap(a, max, n);
        }

    }

    public static void makeSort(int[] a, int n) {

        for (int i = n; i >= 0; i--) {

            int swap = a[0];
            a[0] = a[i];
            a[i] = swap;
            makeHeap(a, 0, i);

        }
    }

    public static void printArray(int a[]) {

        StringBuilder strOut = new StringBuilder();

        strOut.append("[ ");

        for (int i : a) {
            strOut.append(i);
            strOut.append(" ");
        }

        strOut.append("]");

        System.out.println(strOut);

    }

    public static void main(String[] args) {

        int[] a = { 4, 6, 3, 3, 8, 5, 6, 1 };
        int n = a.length - 1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            makeHeap(a, i, n);
        }

        makeSort(a, n);

        printArray(a);

    }

}
