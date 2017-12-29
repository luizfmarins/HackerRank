package br.marins.hacker.rank.data.structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListsDetectCycle {

  public boolean hasCycle(Node node) {
    Map<Integer, Set<Node>> nodesVisited = new HashMap<>();

    return hasCycle(node, nodesVisited);
  }

  private boolean hasCycle(Node node, Map<Integer, Set<Node>> nodesVisited) {
    if (node == null)
      return false;

    boolean isNewNode = add(nodesVisited, node);
    if (!isNewNode)
      return true;

    return hasCycle(node.next, nodesVisited);
  }

  private boolean add(Map<Integer, Set<Node>> nodes, Node node) {
    Set<Node> nodesWithSameData = getNodes(nodes, node.data);

    return nodesWithSameData.add(node);
  }

  private Set<Node> getNodes(Map<Integer, Set<Node>> nodes, int data) {
    if (!nodes.containsKey(data))
      nodes.put(data, new HashSet<Node>());

    return nodes.get(data);
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