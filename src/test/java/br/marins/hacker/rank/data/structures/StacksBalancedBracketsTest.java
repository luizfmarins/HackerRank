package br.marins.hacker.rank.data.structures;

import static br.marins.hacker.rank.data.structures.StacksBalancedBrackets.NO;
import static br.marins.hacker.rank.data.structures.StacksBalancedBrackets.YES;
import static br.marins.hacker.rank.util.TestUtil.assertResult;
import static br.marins.hacker.rank.util.TestUtil.input;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.InputStream;
import java.util.List;
import org.junit.Test;

public class StacksBalancedBracketsTest {

  private StacksBalancedBrackets sut = new StacksBalancedBrackets();

  @Test
  public void hackerRank_sampleTestCase() throws Exception {
    InputStream input = input(
        "3",
        "{[()]}",
        "{[(])}",
        "{{[[(())]]}}");

    List<String> result = sut.isBalanced(input);

    assertResult(result,
        YES,
        NO,
        YES);
  }

  @Test
  public void firstBracketIsClosing() throws Exception {
    InputStream input = input(
        "1",
        "}}");

    List<String> result = sut.isBalanced(input);

    assertResult(result, NO);
  }

  @Test
  public void hackerRank_testCase0() throws Exception {
    InputStream input = input(
        "5",
        "}][}}(}][))]",
        "[](){()}",
        "()",
        "({}([][]))[]()",
        "{)[](}]}]}))}(())(");

    List<String> result = sut.isBalanced(input);

    assertResult(result,
        NO,
        YES,
        YES,
        YES,
        NO);
  }

  @Test
  public void differentNumberOfBrackets() throws Exception {
    InputStream input = input(
        "1",
        "(){");

    List<String> result = sut.isBalanced(input);

    assertResult(result, NO);
  }
}
