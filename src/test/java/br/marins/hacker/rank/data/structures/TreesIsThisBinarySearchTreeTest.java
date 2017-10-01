package br.marins.hacker.rank.data.structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreesIsThisBinarySearchTreeTest {

  private TreesIsThisBinarySearchTree sut = new TreesIsThisBinarySearchTree();

  @Test
  public void sampleTest() {
    Node tree = newNode(4,
        newNode(2,
            newNode(1),
            newNode(3)
        ),
        newNode(6,
            newNode(5),
            newNode(7)
        )
    );

    boolean isBinarySearch = sut.checkBST(tree);

    assertTrue(isBinarySearch);
  }

  @Test
  public void leftEqual() {
    Node tree = newNode(4,
        newNode(4,
            newNode(1),
            newNode(3)
        ),
        newNode(6,
            newNode(5),
            newNode(7)
        )
    );

    boolean isBinarySearch = sut.checkBST(tree);

    assertFalse(isBinarySearch);
  }

  @Test
  public void rightEqual() {
    Node tree = newNode(4,
        newNode(2,
            newNode(1),
            newNode(3)
        ),
        newNode(4,
            newNode(5),
            newNode(7)
        )
    );

    boolean isBinarySearch = sut.checkBST(tree);

    assertFalse(isBinarySearch);
  }

  @Test
  public void violateMaxValue_navigatingLeft() {
    Node tree = newNode(3,
        newNode(2,
            newNode(1),
            newNode(4)
        ),
        newNode(6,
            newNode(5),
            newNode(7)
        )
    );

    assertFalse(sut.checkBST(tree));
  }

  @Test
  public void violateMinValue_navigationRight() {
    Node tree = newNode(3,
        newNode(2),
        newNode(5,
            newNode(2),
            newNode(6)));

    assertFalse(sut.checkBST(tree));
  }

  @Test
  /**
   * Input:
   * 3
   * 1 2 3 4 5 6 7 8 9 10 11 13 12 14 15
   * Output:
   * No
   */
  public void test13() {
    Node tree = newNode(8,
        newNode(4,
            newNode(2,
                newNode(1),
                newNode(3)),
            newNode(6,
                newNode(5),
                newNode(7))),
        newNode(13,
            newNode(10,
                newNode(9),
                newNode(11)),
            newNode(14,
                newNode(12),
                newNode(15))));

    assertFalse(sut.checkBST(tree));
  }

  @Test
  public void twoLevels_binarySearch() {
    Node tree = newNode(3,
        newNode(2),
        newNode(6)
    );

    assertTrue(sut.checkBST(tree));
  }

  @Test
  public void twoLevels_notBinarySearch() {
    Node tree = newNode(3,
        newNode(6),
        newNode(2)
    );

    assertFalse(sut.checkBST(tree));
  }

  @Test
  public void oneLevel() {
    Node tree = newNode(3);


    assertTrue(sut.checkBST(tree));
  }

  private Node newNode(int data, Node left, Node right) {
    Node node = newNode(data);
    node.left = left;
    node.right = right;
    return node;
  }

  private Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    return node;
  }
}