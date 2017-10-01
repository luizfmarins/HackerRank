package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    return checkBST(root.left, root.left.data, root.data, false)
        && checkBST(root.right, root.data, root.right.data, true);
  }

  private boolean checkBST(Node root, Integer minValue, Integer maxValue, boolean isRight) {
    if (root == null) {
      return true;
    }

    minValue = root.data < minValue ? root.data : minValue;
    maxValue = root.data > maxValue ? root.data : maxValue;

    if (root.left != null) {
      if (root.data < root.left.data) {
        return false;
      }

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
      if (root.data > root.right.data) {
        return false;
      }

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

    return checkBST(root.left, minValue, maxValue, false)
        && checkBST(root.right, minValue, maxValue, true);
  }
}

class Node {

  int data;

  Node left;

  Node right;
}