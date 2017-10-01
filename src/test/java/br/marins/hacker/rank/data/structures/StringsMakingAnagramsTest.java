package br.marins.hacker.rank.data.structures;

import static br.marins.hacker.rank.util.TestUtil.input;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class StringsMakingAnagramsTest {

  private StringsMakingAnagrams sut = new StringsMakingAnagrams();

  @Test
  public void sampleTest() throws Exception {
    int numberNeeded = sut.numberNeededToRemove(input("cde", "abc"));

    assertThat(numberNeeded, equalTo(4));
  }

  @Test
  public void sampleTest_differentSizes_firstBigger() throws Exception {
    int numberNeeded = sut.numberNeededToRemove(input("cdef", "abc"));

    assertThat(numberNeeded, equalTo(5));
  }

  @Test
  public void sampleTest_differentSizes_secondBigger() throws Exception {
    int numberNeeded = sut.numberNeededToRemove(input("cde", "abcf"));

    assertThat(numberNeeded, equalTo(5));
  }

  @Test
  public void alreadyAnagram() throws Exception {
    int numberNeeded = sut.numberNeededToRemove(input("bacdc", "dcbac"));

    assertThat(numberNeeded, equalTo(0));
  }
}