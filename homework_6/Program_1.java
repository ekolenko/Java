/*
 * Реализовать печать бинарного дерева в скобочной форме: 1(3(31,511(202,nil)),2(4,5))
 *
 * Реализовать несколько обходов дерева. https://en.wikipedia.org/wiki/Tree_traversal
 */

public class Program_1 {

  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<>(1);
    tree.left = new Tree<>(2);
    tree.right = new Tree<>(3);
    tree.left.left = new Tree<>(4);
    tree.left.right = new Tree<>(5);
    tree.right.left = new Tree<>(6);
    tree.right.right = new Tree<>(7);

    System.out.println();
    Printer.preorder(tree, "");
    System.out.println("\n--------------------------\n");
    Printer.inorder(tree, "");
    System.out.println("\n--------------------------\n");
    Printer.postorder(tree, "");
    System.out.println();
    Printer.bracketsPrint(tree);
  }
}

class Tree<T> {
  T value;
  Tree<T> left;
  Tree<T> right;

  public Tree(T v) {
    value = v;
  }
}

class Printer {

  public static <T> void preorder(Tree<T> node, String space) {
    if (node == null) return; else {
      System.out.printf("%s%s%n", space, node.value);
      preorder(node.left, space + "  ");
      preorder(node.right, space + "  ");
    }
  }

  public static <T> void inorder(Tree<T> node, String space) {
    if (node == null) return; else {
      inorder(node.left, space + "  ");
      System.out.printf("%s%s%n", space, node.value);
      inorder(node.right, space + "  ");
    }
  }

  public static <T> void postorder(Tree<T> node, String space) {
    if (node == null) return; else {
      postorder(node.left, space + "  ");
      postorder(node.right, space + "  ");
      System.out.printf("%s%s%n", space, node.value);
    }
  }

  public static <T> void bracketsPrint(Tree<T> node) {
    StringBuilder str = new StringBuilder();
    System.out.println(brackets(node, str));
  }

  static <T> StringBuilder brackets(Tree<T> node, StringBuilder str) {
    if (node == null) {
      str.append("nil");
      return str;
    } else {
      str.append(node.value);

      if (node.left != null || node.right != null) {
        str.append("(");
        brackets(node.left, str);
        str.append(",");
        brackets(node.right, str);
        str.append(")");
      }
    }

    return str;
  }
}
