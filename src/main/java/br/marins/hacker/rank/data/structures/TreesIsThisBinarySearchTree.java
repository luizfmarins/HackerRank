package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    if (root.left != null) {
      boolean isCorrect = checkBSTLeft(root.data, root.left, root.left.data, root.data);
      if (!isCorrect) {
        return false;
      }
    }
    if (root.right != null) {
      boolean isCorrect = checkBSTRight(root.data, root.right, root.data, root.right.data);
      if (!isCorrect) {
        return false;
      }
    }

    return true;
  }

  private boolean checkBSTRight(int father, Node root, Integer minValue, Integer maxValue) {
    if (root == null) {
      return true;
    }

    minValue = root.data < minValue ? root.data : minValue;
    maxValue = root.data > maxValue ? root.data : maxValue;

    if (father > root.data) {
      return false;
    }

    if (root.left != null) {
      if (minValue > root.left.data) {
        return false;
      }
    }

    if (root.right != null) {
      if (minValue > root.right.data) {
        return false;
      }
    }

    return checkBSTLeft(root.data, root.left, minValue, maxValue)
        && checkBSTRight(root.data, root.right, minValue, maxValue);
  }

  private boolean checkBSTLeft(int father, Node root, Integer minValue, Integer maxValue) {
    if (root == null) {
      return true;
    }

    minValue = root.data < minValue ? root.data : minValue;
    maxValue = root.data > maxValue ? root.data : maxValue;

    if (father < root.data) {
      return false;
    }

    if (root.left != null) {
      if (maxValue < root.left.data) {
        return false;
      }
    }

    if (root.right != null) {
      if (maxValue < root.right.data) {
        return false;
      }
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