package br.marins.hacker.rank.data.structures;

import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringsMakingAnagrams {

  public int numberNeeded(InputStream in) throws IOException {
    List<String> lines = readLines(in);
    String a = lines.get(0);
    String b = lines.get(1);
    return numberNeeded(a, b);
  }

  private int numberNeeded(String a, String b) {
    List<Character> str1 = asList(a.toCharArray());
    List<Character> str2 = asList(b.toCharArray());

    sort(str1);
    sort(str2);

    return calculateNumberNeeded(str1, str2);
  }

  private List<Character> asList(char[] chars) {
    List<Character> list = new ArrayList<>();

    for (int i = 0; i < chars.length; i++) {
      list.add(chars[i]);
    }

    return list;
  }

  private int calculateNumberNeeded(List<Character> str1, List<Character> str2) {
    for(int i = 0; i < str1.size(); i++) {
      char char1 = str1.get(i);
      int index = binarySearch(str2, char1);
      if (index >= 0) {
        str1.remove(i);
        str2.remove(index);
      }
    }

    return str1.size() + str2.size();
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
}