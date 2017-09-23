package br.marins.hacker.rank.algorithms;

import static br.marins.hacker.rank.util.TestUtil.assertResult;
import static br.marins.hacker.rank.util.TestUtil.input;

import java.io.InputStream;
import java.util.List;
import org.junit.Test;

public class BinarySearchIceCreamParlorTest {

  private BinarySearchIceCreamParlor sut = new BinarySearchIceCreamParlor();

  @Test
  public void sampleTest1() throws Exception {
    InputStream input = input(
        "1",
        "4",
        "5",
        "1 4 5 3 2");

    List<String> result = sut.calculateBestChoice(input);

    assertResult(result,
        "1 4");
  }

  @Test
  public void sampleTest2() throws Exception {
    InputStream input = input(
        "1",
        "4",
        "4",
        "2 2 4 3");

    List<String> result = sut.calculateBestChoice(input);

    assertResult(result,
        "1 2");
  }

  @Test
  public void originalSampleTest() throws Exception {
    InputStream input = input(
        "2",
        "4",
        "5",
        "1 4 5 3 2",
        "4",
        "4",
        "2 2 4 3");

    List<String> result = sut.calculateBestChoice(input);

    assertResult(result,
        "1 4",
        "1 2");
  }
}