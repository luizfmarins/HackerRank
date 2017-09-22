package br.marins.hacker.rank.util;

import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.IOUtils.write;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TestUtil {

  private TestUtil() {
  }

  public static InputStream input(String line1, String... nextLines) throws IOException {
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
