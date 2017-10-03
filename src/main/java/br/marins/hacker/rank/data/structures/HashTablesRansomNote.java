package br.marins.hacker.rank.data.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTablesRansomNote {

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    HashTablesRansomNote note = new HashTablesRansomNote();
    boolean canUseTheMagazine = note.canUseTheMagazine(in);

    System.out.println(canUseTheMagazine ? "Yes" : "No");
  }

  public boolean canUseTheMagazine(InputStream input) throws IOException {
    List<String> lines = readLines(input);
    String[] wordsMagazine = getWordsMagazine(lines);
    String[] wordsNote = getWordsNote(lines);

    return canUseTheMagazine(wordsNote, wordsMagazine);
  }

  private boolean canUseTheMagazine(String[] wordsNote, String[] wordsMagazine) {
    Map<String, Integer> magazineWordsAmount = getWordsAmount(wordsMagazine);

    for (String w : wordsNote) {
      Integer availableAmount = magazineWordsAmount.get(w);

      if (isAvailable(availableAmount)) {
        return false;
      }

      availableAmount--;
      magazineWordsAmount.put(w, availableAmount);
    }

    return true;
  }

  private boolean isAvailable(Integer availableAmount) {
    return availableAmount == null || availableAmount < 1;
  }

  private Map<String, Integer> getWordsAmount(String[] words) {
    Map<String, Integer> wordsAmount = new HashMap<>();

    for (String w : words) {
      Integer amount = wordsAmount.get(w);
      amount = amount == null ? 1 : amount + 1;
      wordsAmount.put(w, amount);
    }

    return wordsAmount;
  }

  private String[] getWordsMagazine(List<String> lines) {
    return lines.get(1).split(SEPARATOR);
  }

  private String[] getWordsNote(List<String> lines) {
    return lines.get(2).split(SEPARATOR);
  }

  private List<String> readLines(InputStream input) throws IOException {
    List<String> lines = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

    String line;
    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }

    return lines;
  }

  public static final String SEPARATOR = " ";
}