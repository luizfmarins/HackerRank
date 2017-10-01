package br.marins.hacker.rank.data.structures;

public class TreesIsThisBinarySearchTree {

  boolean checkBST(Node root) {
    if (root == null) {
      return true;
    }

    if (root.left != null && root.data < root.left.data) {
      return false;
    }

    if (root.right != null && root.data > root.right.data) {
      return false;
    }

    return checkBST(root.left)
        && checkBST(root.right);
  }
}

class Node {
  int data;
  Node left;
  Node right;
}