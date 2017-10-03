package br.marins.hacker.rank.data.structures;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HashTablesRansomNote {

  public boolean canUseTheMagazine(InputStream input) throws IOException {
    List<String> lines = readLines(input);
    String[] wordsMagazine = getWordsMagazine(lines);
    String[] wordsNote = getWordsNote(lines);

    return canUseTheMagazine(wordsNote, wordsMagazine);
  }

  private boolean canUseTheMagazine(String[] wordsNote, String[] wordsMagazine) {
    List<String> listWordsNote = asList(wordsNote);
    List<String> listWordsMagazine = new ArrayList<>(asList(wordsMagazine));

    boolean isMissingWord = listWordsNote.stream().filter(w -> {
      return !listWordsMagazine.remove(w);
    }).findFirst().isPresent();

    return !isMissingWord;
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