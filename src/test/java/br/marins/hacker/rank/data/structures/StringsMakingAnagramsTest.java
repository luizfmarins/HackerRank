package br.marins.hacker.rank.data.structures;

import static br.marins.hacker.rank.util.TestUtil.input;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class StringsMakingAnagramsTest {

  private StringsMakingAnagrams sut = new StringsMakingAnagrams();

  @Test
  public void sampleTest() throws Exception {
    int numberNeeded = sut.numberNeeded(input("cde", "abc"));

    assertThat(numberNeeded, equalTo(4));
  }
}