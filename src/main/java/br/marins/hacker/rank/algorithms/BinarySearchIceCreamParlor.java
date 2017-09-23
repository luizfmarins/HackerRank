package br.marins.hacker.rank.algorithms;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchIceCreamParlor {

  public List<String> calculateBestChoice(InputStream input) throws IOException {
    List<String> lines = readLines(input);
    List<String> values = getValues(lines);

    int money = getMoney(values);
    List<Integer> flavors = getFlavors(lines);

    int flavor1 = 0;
    int flavor2 = 0;

    for (int i = 0; i < flavors.size() - 1; i++) {
      for (int j = i + 1; j < flavors.size(); j++) {
        int flavorsValue = flavors.get(i) + flavors.get(j);
        if (money == flavorsValue) {
          flavor1 = i;
          flavor2 = j;
          break;
        }
      }
    }

    return result(flavor1, flavor2);
  }

  private List<Integer> getFlavors(List<String> lines) {
    return stream(lines.get(3).split(" "))
        .map(v -> Integer.parseInt(v))
        .collect(toList());
  }

  private int getMoney(List<String> values) {
    return Integer.parseInt(values.get(0));
  }

  private List<String> result(int flavor1, int flavor2) {
    flavor1++;
    flavor2++;

    List<Integer> flavors = asList(flavor1, flavor2).stream()
        .sorted()
        .collect(toList());

    return asList(String.valueOf(flavors.get(0))
        + " "
        + String.valueOf(flavors.get(1)));
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

  private int getNumberOfTrips(List<String> lines) {
    return Integer.parseInt(getMetadata(lines));
  }

  private String getMetadata(List<String> lines) {
    return lines.get(0);
  }

  private List<String> getValues(List<String> lines) {
    List<String> values = new ArrayList<>();

    for (int i = 1; i <= 3; i++) {
      values.add(lines.get(i));
    }

    return values;
  }
}