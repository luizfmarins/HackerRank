package br.marins.hacker.rank.util;

import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.IOUtils.write;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class TestUtil {

  private TestUtil() {
  }

  public static InputStream input(String... lines) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printer = new PrintStream(out);

    for (int i = 0; i < lines.length; i++) {
      write(lines[i] + "\n", printer, defaultCharset());
    }

    printer.close();
    out.close();

    return new ByteArrayInputStream(out.toByteArray());
  }

  public static void assertResult(List<String> result, String... expected) {
    assertThat(result, hasSize(expected.length));

    for (int i = 0; i < result.size(); i++) {
      assertThat((i + 1) +"", result.get(i), equalTo(expected[i]));
    }
  }
}
