package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    return checkBSTLeft(root.left, root.data)
      && checkBSTRight(root.right, root.data);
  }

  private boolean checkBSTRight(Node node, int father) {
    if (node == null) {
      return true;
    }

    int minValue = father;

    if (father > node.data) {
      return false;
    }

    if (node.left != null && minValue > node.left.data) {
      return false;
    }

    if (node.right != null && minValue > node.right.data) {
      return false;
    }

    return checkBSTLeft(node.left, node.data)
        && checkBSTRight(node.right, node.data);
  }

  private boolean checkBSTLeft(Node node, int father) {
    if (node == null) {
      return true;
    }

    int maxValue = father;

    if (father < node.data) {
      return false;
    }

    if (node.left != null && maxValue < node.left.data) {
      return false;
    }

    if (node.right != null && maxValue < node.right.data) {
      return false;
    }

    return checkBSTLeft(node.left, node.data)
        && checkBSTRight(node.right, node.data);
  }
}

class Node {

  int data;

  Node left;

  Node right;
}