package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    return checkBSTLeft(root.left, root.data, Integer.MIN_VALUE)
      && checkBSTRight(root.right, root.data, Integer.MAX_VALUE);
  }

  private boolean checkBSTRight(Node node, int father, int maxValue) {
    if (node == null) {
      return true;
    }

    int minValue = father;

    if (father > node.data) {
      return false;
    }

    if (node.data < minValue) {
      return false;
    }

    if (node.data > maxValue) {
      return false;
    }

    return checkBSTLeft(node.left, node.data, minValue)
        && checkBSTRight(node.right, node.data, maxValue);
  }

  private boolean checkBSTLeft(Node node, int father, int minValue) {
    if (node == null) {
      return true;
    }

    int maxValue = father;

    if (father < node.data) {
      return false;
    }

    if (node.data < minValue) {
      return false;
    }

    if (node.data > maxValue) {
      return false;
    }

    return checkBSTLeft(node.left, node.data, minValue)
        && checkBSTRight(node.right, node.data, maxValue);
  }
}

class Node {

  int data;

  Node left;

  Node right;
}