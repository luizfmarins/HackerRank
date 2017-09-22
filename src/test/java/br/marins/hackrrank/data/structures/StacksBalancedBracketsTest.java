package br.marins.hackrrank.data.structures;

import static br.marins.hackrrank.data.structures.StacksBalancedBrackets.NO;
import static br.marins.hackrrank.data.structures.StacksBalancedBrackets.YES;
import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.IOUtils.write;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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

  private void assertResult(List<String> result, String... expected) {
    for (int i = 0; i < result.size(); i++) {
      assertThat((i + 1) +"", result.get(i), equalTo(expected[i]));
    }
  }

  private InputStream input(String line1, String... nextLines) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printer = new PrintStream(out);

    write(line1 + "\n", printer, defaultCharset());
    for (int i = 0; i < nextLines.length; i++) {
      write(nextLines[i] + "\n", printer, defaultCharset());
    }

    printer.close();
    out.close();

    return new ByteArrayInputStream(out.toByteArray());
  }

}
