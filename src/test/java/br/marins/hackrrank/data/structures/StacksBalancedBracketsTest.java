package br.marins.hackrrank.data.structures;

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

  public static final String YES = "YES";
  public static final String NO = "NO";
  private StacksBalancedBrackets sut = new StacksBalancedBrackets();

  @Test
  public void test() throws Exception {
    InputStream input = input(
        "3",
        "{[()]}",
        "{[(])}",
        "{{[[(())]]}}");

    List<String> result = sut.isBalanced(input);

    assertThat(result.get(0), equalTo(YES));
    assertThat(result.get(1), equalTo(NO));
    assertThat(result.get(2), equalTo(YES));
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
