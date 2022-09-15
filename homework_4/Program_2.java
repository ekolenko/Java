import java.util.Arrays;

public class Program_2 {

  public static int[] mergeSort(int[] a) {
    if (a.length == 1) return a;

    int[] l = mergeSort(Arrays.copyOfRange(a, 0, (a.length) / 2));
    int[] r = mergeSort(Arrays.copyOfRange(a, (a.length) / 2, a.length));

    int i = 0, j = 0, k = 0;
    int[] c = new int[l.length + r.length];

    while ((i < l.length) && (j < r.length)) {
      if (l[i] <= r[j]) {
        c[k] = l[i];
        i++;
        k++;
      } else {
        c[k] = r[j];
        j++;
        k++;
      }
    }

    while (i < l.length) {
      c[k] = l[i];
      i++;
      k++;
    }

    while (j < r.length) {
      c[k] = r[j];
      j++;
      k++;
    }

    return c;
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
    int[] a = { 5, 3, 7, 34, 5, 2, 9, 56, 65 };

    printArray(mergeSort(a));
  }
}
