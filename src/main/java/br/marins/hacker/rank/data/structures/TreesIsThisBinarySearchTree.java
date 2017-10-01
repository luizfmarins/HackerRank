package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    return checkBSTLeft(root.data, root.left, root.data, root.data)
      && checkBSTRight(root.data, root.right, root.data, root.data);
  }

  private boolean checkBSTRight(int father, Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }

    minValue = minValue < father ? father : minValue;
    maxValue = maxValue < father ? father : maxValue;

    if (father > node.data) {
      return false;
    }

    if (node.left != null && minValue > node.left.data) {
      return false;
    }

    if (node.right != null && minValue > node.right.data) {
      return false;
    }

    return checkBSTLeft(node.data, node.left, minValue, maxValue)
        && checkBSTRight(node.data, node.right, minValue, maxValue);
  }

  private boolean checkBSTLeft(int father, Node root, int minValue, int maxValue) {
    if (root == null) {
      return true;
    }

    minValue = minValue < father ? father : minValue;
    maxValue = maxValue < father ? father : maxValue;

    if (father < root.data) {
      return false;
    }

    if (root.left != null && maxValue < root.left.data) {
      return false;
    }

    if (root.right != null && maxValue < root.right.data) {
      return false;
    }

    return checkBSTLeft(root.data, root.left, minValue, maxValue)
        && checkBSTRight(root.data, root.right, minValue, maxValue);
  }
}

class Node {

  int data;

  Node left;

  Node right;
}