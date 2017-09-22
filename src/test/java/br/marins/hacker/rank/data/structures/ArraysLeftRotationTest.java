package br.marins.hacker.rank.data.structures;

import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.IOUtils.write;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;

public class ArraysLeftRotationTest {

  private ArraysLeftRotation sut = new ArraysLeftRotation();

  @Test
  public void indexRotatedElement_oneRotation() {
    testNumberOfRotations(1, 0, 1, 5);
    testNumberOfRotations(2, 1, 1, 5);
    testNumberOfRotations(0, 4, 1, 5);
  }

  @Test
  public void indexRotatedElement_twoRotation() {
    testNumberOfRotations(2, 0, 2, 5);
    testNumberOfRotations(0, 3, 2, 5);
    testNumberOfRotations(1, 4, 2, 5);
  }

  private void testNumberOfRotations(int index, int expectedNewIndex, int numberOfRotations,
      int arrayLenght) {
    int newIndex2 = sut.indexRotatedElement(index, numberOfRotations, arrayLenght);
    assertThat(newIndex2, equalTo(expectedNewIndex));
  }

  @Test
  public void oneRotation() throws Exception {
    InputStream input = input("5 1\n", "0 1 2 3 4");

    String[] result = sut.rotateLeft(input);

    assertThat(result, arrayContaining("1", "2", "3", "4", "0"));
  }

  @Test
  public void twoRotation() throws Exception {
    InputStream input = input("5 2\n", "0 1 2 3 4");

    String[] result = sut.rotateLeft(input);

    assertThat(result, arrayContaining("2", "3", "4", "0", "1"));
  }

  @Test
  public void forRotations() throws Exception {
    InputStream input = input("5 4\n", "1 2 3 4 5");

    String[] result = sut.rotateLeft(input);

    assertThat(result, arrayContaining("5", "1", "2", "3", "4"));
  }

  @Test
  public void fiveRotations() throws Exception {
    InputStream input = input("5 5\n", "1 2 3 4 5");

    String[] result = sut.rotateLeft(input);

    assertThat(result, arrayContaining("1", "2", "3", "4", "5"));
  }

  @Test
  public void manualTestPrint() throws Exception {
    InputStream input = input("5 4\n", "1 2 3 4 5");

    String[] result = sut.rotateLeft(input);

    sut.print(result);
  }

  private InputStream input(String line1, String line2) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printer = new PrintStream(out);

    write(line1, printer, defaultCharset());
    write(line2, printer, defaultCharset());

    printer.close();
    out.close();

    return new ByteArrayInputStream(out.toByteArray());
  }
}