import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * Реализовать волновой алгоритм
 */

public class Program_11 {

  public static class Field {
    int count, countRow, countCol;

    Node[] nodes;
    char[] display;

    public Field(int row, int col) {
      this.count = row * col;
      this.countRow = row;
      this.countCol = col;
    }

    public void genField() {
      this.nodes = new Node[this.count];
      this.display = new char[this.count];

      for (int i = 0; i < this.count; i++) {
        this.nodes[i] = new Node(i, this);
        display[i] = ' ';
      }

      for (int i = 0; i < 40; i++) {
        int id = new Random().nextInt(this.count);
        nodes[id].blocked = true;
        display[id] = '▢';
      }
    }

    public void printField() {
      for (int i = 0; i < this.countRow; i++) {
        for (int j = 0; j < this.countCol; j++) {
          System.out.print(display[i * countCol + j]);
        }
        System.out.println();
      }
    }

    public void printPath(ArrayList<Integer> path, int startPoint, int stopPoint) {

      for (Integer id : path) {

        display[id] = '*';

      }

      display[startPoint] = 'A';
      display[stopPoint] = 'B';

      printField();

    }
  }

  public static class Node {
    int id;

    boolean blocked;
    boolean visited;

    int wave;

    static int count;
    static int n;
    Field field;

    public Node(int id, Field field) {
      this.id = id;
      this.field = field;
      this.visited = false;
      this.blocked = false;
    }

    public ArrayList<Integer> getNear() {
      ArrayList<Integer> nearNodeId = new ArrayList<Integer>();

      if (this.id % this.field.countCol != 0)
        nearNodeId.add(this.id - 1);
      if ((this.id + 1) % this.field.countCol != 0)
        nearNodeId.add(this.id + 1);
      if (this.id / this.field.countCol != 0)
        nearNodeId.add(
            this.id - this.field.countCol);
      if (this.id / this.field.countCol != this.field.countRow - 1)
        nearNodeId.add(this.id + this.field.countCol);

      return nearNodeId;
    }
  }

  public static void waveStep(Node node, int step) {
    if (node == node.field.nodes[18])
      return;
    else if (node.visited == true)
      return;
    else
      node.wave = step;
    node.visited = true;
    for (int id : node.getNear()) {
      waveStep(node.field.nodes[id], step + 1);
    }
  }

  public static void main(String[] args) {
    Field field = new Field(10, 30);

    field.genField();

    int startPoint = 6;
    int stopPoint = 295;

    Node stopNode = field.nodes[stopPoint];
    stopNode.blocked = false;

    Deque<Node> deque = new LinkedList<Node>();

    Node startNode = field.nodes[startPoint];
    startNode.visited = true;
    startNode.blocked = false;

    deque.add(startNode);

    while (!deque.isEmpty()) {
      Node node = deque.pop();

      for (int id : node.getNear()) {
        Node tmpNode = field.nodes[id];

        if (!tmpNode.visited && !tmpNode.blocked) {
          tmpNode.visited = true;
          tmpNode.wave = node.wave + 1;

          if (id == stopPoint) {
            deque.clear();
            break;
          }

          deque.add(tmpNode);
        }
      }
    }

    ArrayList<Integer> path = new ArrayList<Integer>();

    int nextId = stopPoint;

    while (nextId != startPoint) {
      Node lastNode = field.nodes[nextId];

      for (int id : lastNode.getNear()) {
        Node tmpNode = field.nodes[id];

        if (!tmpNode.blocked &&
            tmpNode.visited &&
            lastNode.wave == tmpNode.wave + 1) {
          nextId = tmpNode.id;
          path.add(nextId);
          break;
        }
      }
    }

    System.out.println();

    field.printPath(path, startPoint, stopPoint);

    System.out.println();
  }
}
