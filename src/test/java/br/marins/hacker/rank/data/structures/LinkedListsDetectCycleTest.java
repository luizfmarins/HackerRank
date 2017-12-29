package br.marins.hacker.rank.data.structures;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import br.marins.hacker.rank.data.structures.LinkedListsDetectCycle.Node;
import org.junit.Test;

public class LinkedListsDetectCycleTest {

  private static final Node EMPTY_LIST = null;

  private LinkedListsDetectCycle sut = new LinkedListsDetectCycle();

  @Test
  public void emptyList() {
    boolean hasCycle = sut.hasCycle(EMPTY_LIST);

    assertThat(hasCycle, is(false));
  }

  @Test
  public void onlyOneElement_noCycle() {
    boolean hasCycle = sut.hasCycle(new Node(1));

    assertThat(hasCycle, is(false));
  }

  @Test
  public void onlyOneElement_withCycle() {
    Node node = new Node(1);
    node.next = node;

    boolean hasCycle = sut.hasCycle(node);

    assertThat(hasCycle, is(true));
  }

  @Test
  public void twoElements_withCycle() {
    Node second = new Node(2);
    Node head = new Node(1, second);
    second.next = head;

    boolean hasCycle = sut.hasCycle(head);

    assertThat(hasCycle, is(true));
  }

  @Test
  public void treeElements_withCycle() {
    Node third = new Node(3);
    Node second = new Node(2, third);
    Node head = new Node(1, second);
    third.next = second;

    boolean hasCycle = sut.hasCycle(head);

    assertThat(hasCycle, is(true));
  }

  @Test
  public void avoidKeepingState() {
    twoElements_withCycle();
    onlyOneElement_noCycle();
  }

  @Test
  public void treeElements_duplicateData_noCycle() {
    Node third = new Node(2);
    Node second = new Node(2, third);
    Node head = new Node(1, second);

    boolean hasCycle = sut.hasCycle(head);

    assertThat(hasCycle, is(false));
  }
}