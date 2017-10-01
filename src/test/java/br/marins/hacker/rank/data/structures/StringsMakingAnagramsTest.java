package br.marins.hacker.rank.data.structures;

import static br.marins.hacker.rank.util.TestUtil.input;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import org.junit.Test;

public class StringsMakingAnagramsTest {

  private StringsMakingAnagrams sut = new StringsMakingAnagrams();

  @Test
  public void sampleTest() throws Exception {
    assertNumbersRemovedToMakeAnagram("cde", "abc", 4);
  }

  @Test
  public void sampleTest_differentSizes_firstBigger() throws Exception {
    assertNumbersRemovedToMakeAnagram("cdef", "abc", 5);
  }

  @Test
  public void sampleTest_differentSizes_secondBigger() throws Exception {
    assertNumbersRemovedToMakeAnagram("cde", "abcf", 5);
  }

  @Test
  public void alreadyAnagram() throws Exception {
    assertNumbersRemovedToMakeAnagram("bacdc", "dcbac", 0);
  }

  private void assertNumbersRemovedToMakeAnagram(String str1, String str2,
      int expectedNumbersRemoved) throws IOException {
    int numberNeeded = sut.numberNeededToRemove(input(str1, str2));

    assertThat(numberNeeded, equalTo(expectedNumbersRemoved));
  }
}