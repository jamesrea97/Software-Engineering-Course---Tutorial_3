package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class ListTest {

  List testList = new List();

  @Test
  public void failsIfListIsNotEmptyWhenInitialized() {
    assertThat("List is initialized nonempty.", testList.getList().isEmpty(), is(true));
  }

  @Test
  public void failsToAddToList() {
    Integer i = 1234;
    assertThat("Item cannot be stored as a String", testList.addToList(i), is(true));
    String t = "Test";
    assertThat("Item cannot be stored as a String.", testList.addToList(t), is(true));
  }

  @Test
  public void failsToRetrieveItemFromListAsIndexIsOutOfBound() {
    testList.addToList(123);
    assertThat("Item was not retrieved", testList.retrieveItems(0), is("123"));
    assertThat("Items was not retrieved", testList.retrieveItems(-1), is("No item at that index"));
    assertThat("Items was not retrieved", testList.retrieveItems(1), is("No item at that index"));
  }

  @Test
  public void failsIfRecentestItemIsNotFirstInList() {
    testList.addToList(123);
    testList.addToList("Test");
    assertThat("Item was not retrieved", testList.retrieveItems(0), is("Test"));
  }

  @Test
  public void failsIfAddedItemIsNotAlreadyInList() {
    testList.addToList("Apple");
    testList.addToList("Rea");
    testList.addToList("Banana");
    assertThat("List has duplication in items", testList.addToList("Rea"), is(true));
  }
}
