package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    return checkBSTLeft(root.left, Integer.MIN_VALUE, root.data)
        && checkBSTRight(root.right, root.data, Integer.MAX_VALUE);
  }

  private boolean checkBSTLeft(Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }

    if (violateMinMaxValues(node, minValue, maxValue)) {
      return false;
    }

    return checkBSTLeft(node.left, minValue, node.data)
        && checkBSTRight(node.right, node.data, maxValue);
  }

  private boolean checkBSTRight(Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }

    if (violateMinMaxValues(node, minValue, maxValue)) {
      return false;
    }

    return checkBSTLeft(node.left, minValue, node.data)
        && checkBSTRight(node.right, node.data, maxValue);
  }

  private boolean violateMinMaxValues(Node node, int minValue, int maxValue) {
    return node.data <= minValue || node.data >= maxValue;
  }
}

class Node {

  int data;

  Node left;

  Node right;
}