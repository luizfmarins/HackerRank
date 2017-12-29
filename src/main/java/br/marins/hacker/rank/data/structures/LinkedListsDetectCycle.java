package br.marins.hacker.rank.data.structures;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsDetectCycle {

  public boolean hasCycle(Node node) {
    Set<Node> nodesVisited = new HashSet<>(); // TODO Node do not implement hashCode

    return hasCycle(node, nodesVisited);
  }

  private boolean hasCycle(Node node, Set<Node> nodesVisited) {
    if (node == null)
      return false;

    boolean isNewNode = nodesVisited.add(node);
    if (!isNewNode)
      return true;

    return hasCycle(node.next, nodesVisited);
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