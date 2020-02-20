package ic.doc;

import java.util.LinkedList;

public class List {

  private LinkedList<String> items = new LinkedList<>();

  public LinkedList<String> getList() {
    return items;
  }

  public boolean addToList(Object o) {
    try {
      String s = o.toString();
      items.remove(s);
      items.addFirst(s);
      return true;
    } catch (ClassCastException cce) {
      return false;
    }
  }

  public String retrieveItems(int index) {
    try {
      return items.get(index);
    } catch (IndexOutOfBoundsException e) {
      return "No item at that index";
    }
  }
}
