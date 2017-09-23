package br.marins.hacker.rank.algorithms;

import static br.marins.hacker.rank.util.TestUtil.assertResult;
import static br.marins.hacker.rank.util.TestUtil.input;

import java.io.InputStream;
import java.util.List;
import org.junit.Test;

public class BubbleSortTest {

  private BubbleSort sut = new BubbleSort();

  @Test
  public void sampleTest1_alreadySorted() throws Exception {
    InputStream input = input("3", "1 2 3");

    List<String> result = sut.sort(input);

    assertResult(result,
        "[1, 2, 3]",
        "Array is sorted in 0 swaps.",
        "First Element: 1",
        "Last Element: 3");
  }

  @Test
  public void sampleTest2_reversedOrder() throws Exception {
    InputStream input = input("3", "3 2 1");

    List<String> result = sut.sort(input);

    assertResult(result,
        "[1, 2, 3]",
        "Array is sorted in 3 swaps.",
        "First Element: 1",
        "Last Element: 3");
  }

  @Test
  public void oneElementArray() throws Exception {
    InputStream input = input("1", "1");

    List<String> result = sut.sort(input);

    assertResult(result,
        "[1]",
        "Array is sorted in 0 swaps.",
        "First Element: 1",
        "Last Element: 1");
  }

  @Test
  public void twoElementArray() throws Exception {
    InputStream input = input("2", "2 1");

    List<String> result = sut.sort(input);

    assertResult(result,
        "[1, 2]",
        "Array is sorted in 1 swaps.",
        "First Element: 1",
        "Last Element: 2");
  }
}