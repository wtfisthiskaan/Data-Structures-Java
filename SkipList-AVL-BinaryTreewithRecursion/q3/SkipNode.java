
import java.util.Random;

class SkipNode<N extends Comparable<? super N>> {

  N data;
  @SuppressWarnings("unchecked")
  SkipNode<N>[] next = (SkipNode<N>[]) new SkipNode[4];
        /**
   * SkipNode Cons.
   * @param data is data to be added.
   * 
  */
  SkipNode(N data) {
    this.data = data;
  }
          /**
   * refreshAfterDelete func.
   * @param level is level of wanted list.
   * 
  */
  void refreshAfterDelete(int level) {
    SkipNode<N> current = this;
    while (current != null && current.getNext(level) != null) {
      if (current.getNext(level).data == null) {
        SkipNode<N> successor = current.getNext(level).getNext(level);
        current.setNext(successor, level);
        return;
      }

      current = current.getNext(level);
    }
  }
    /**
   * setNext func.
   * @param next node to be set.
   * @param level is level of lists.
   * 
  */
  void setNext(SkipNode<N> next, int level) {
    this.next[level] = next;
  }
      /**
   * getNext func.
   * @param level is level of lists.
   * 
  */
  SkipNode<N> getNext(int level) {
    if(level>=next.length)
      return null;
    return this.next[level];
  }
        /**
   * search func.
   * @param data is level of lists.
   * @param level is level of lists.
   * @param print is level of lists.
   * 
  */
  SkipNode<N> search(N data, int level, boolean print) {
    //if (print) {
      //System.out.print("Searching for: " + data + " at ");
      //print(level);

    //}

    SkipNode<N> result = null;
    SkipNode<N> current = this.getNext(level);
    while (current != null && current.data.compareTo(data) < 1) {
      if (current.data.equals(data)) {
        result = current;
        break;
      }

      current = current.getNext(level);
    }

    return result;
  }
          /**
   * insert func.
   * @param skipNode is level of lists.
   * @param level is level of lists.
   * 
  */
  void insert(SkipNode<N> skipNode, int level) {
    if(level==next.length)
      level--;
    SkipNode<N> current = this.getNext(level);
    if (current == null) {
      this.setNext(skipNode, level);
      return;
    }

    if (skipNode.data.compareTo(current.data) < 1) {
      this.setNext(skipNode, level);
      skipNode.setNext(current, level);
      return;
    }

    while (current.getNext(level) != null && current.data.compareTo(skipNode.data) < 1 &&
      current.getNext(level).data.compareTo(skipNode.data) < 1) {

      current = current.getNext(level);
    }

    SkipNode<N> successor = current.getNext(level);
    current.setNext(skipNode, level);
    skipNode.setNext(successor, level);
  }
          /**
   * print func.
   * @param level is level of lists.
   * 
  */
  void print(int level) {
    if(level>=next.length)
      return;
    System.out.print("level " + level + ": [ ");
    int length = 0;
    SkipNode<N> current = this.getNext(level);
    while (current != null) {
      length++;
      System.out.print(current.data + " ");
      current = current.getNext(level);
    }

    System.out.println("], length: " + length);
  }

}