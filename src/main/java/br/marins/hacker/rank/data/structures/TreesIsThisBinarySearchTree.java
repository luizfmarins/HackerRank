package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    if (root.left != null) {
      boolean isRight = checkBST(root.data, root.left, root.left.data, root.data, false);
      if (!isRight) {
        return false;
      }
    }
    if (root.right != null) {
      boolean isRight = checkBST(root.data, root.right, root.data, root.right.data, true);
      if (!isRight) {
        return false;
      }
    }

    return true;
  }

  private boolean checkBST(int father, Node root, Integer minValue, Integer maxValue, boolean isRight) {
    if (root == null) {
      return true;
    }

    minValue = root.data < minValue ? root.data : minValue;
    maxValue = root.data > maxValue ? root.data : maxValue;

    if (!isRight) {
      if (father < root.data) {
        return false;
      }
    } else {
      if (father > root.data) {
        return false;
      }
    }

    if (root.left != null) {
      if (isRight) {
        if (minValue > root.left.data) {
          return false;
        }
      } else {
        if (maxValue < root.left.data) {
          return false;
        }
      }
    }

    if (root.right != null) {
      if (isRight) {
        if (minValue > root.right.data) {
          return false;
        }
      } else {
        if (maxValue < root.right.data) {
          return false;
        }
      }
    }

    return checkBST(root.data, root.left, minValue, maxValue, false)
        && checkBST(root.data, root.right, minValue, maxValue, true);
  }
}

class Node {

  int data;

  Node left;

  Node right;
}