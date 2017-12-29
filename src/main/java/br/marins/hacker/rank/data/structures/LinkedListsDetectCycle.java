package br.marins.hacker.rank.data.structures;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsDetectCycle {

  private final Set<Integer> nodesVisited = new HashSet<>();

  public boolean hasCycle(Node node) {
    if (node == null)
      return false;

    boolean isNewNode = nodesVisited.add(node.data);
    if (!isNewNode)
      return true;

    return hasCycle(node.next);
  }

  static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}