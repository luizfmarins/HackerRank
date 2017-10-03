package br.marins.hacker.rank.data.structures;

import static br.marins.hacker.rank.util.TestUtil.input;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import org.junit.Test;

public class HashTablesRansomNoteTest {

  private HashTablesRansomNote sut = new HashTablesRansomNote();

  @Test
  public void sampleTest() throws Exception {
    InputStream input = input(
        "6 4",
        "give me one grand today night",
        "give one grand today"
    );

    assertCanUseTheMagazine(input);
  }

  @Test
  public void missingOneWord() throws Exception {
    InputStream input = input(
        "6 4",
        "give me one today night",
        "give one grand today"
    );

    assertCanNotUseTheMagazine(input);
  }

  @Test
  public void sameWordUsedTwoTimes_onlyOneTimeAvailableInMagazine() throws Exception {
    InputStream input = input(
        "6 4",
        "give me one grand today night",
        "give one one grand today"
    );

    assertCanNotUseTheMagazine(input);
  }

  @Test
  public void sameWordUsedTwoTimes_bolthAvailableInMagazine() throws Exception {
    InputStream input = input(
        "6 4",
        "give me one grand one today night",
        "give one one grand today"
    );

    assertCanUseTheMagazine(input);
  }

  private void assertCanUseTheMagazine(InputStream input) throws Exception {
    boolean canUseTheMagazine = sut.canUseTheMagazine(input);

    assertTrue(canUseTheMagazine);
  }

  private void assertCanNotUseTheMagazine(InputStream input) throws Exception {
    boolean canUseTheMagazine = sut.canUseTheMagazine(input);

    assertFalse(canUseTheMagazine);
  }

}
