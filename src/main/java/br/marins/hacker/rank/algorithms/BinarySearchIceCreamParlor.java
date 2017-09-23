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

  public static final int TRIP_OFFSET = 3;

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    BinarySearchIceCreamParlor flavorChoice = new BinarySearchIceCreamParlor();
    List<String> result = flavorChoice.calculateBestChoice(in);

    result.forEach(r -> System.out.println(r));
  }

  public List<String> calculateBestChoice(InputStream input) throws IOException {
    List<String> lines = readLines(input);

    int numberOfTrips = getNumberOfTrips(lines);
    List<Integer> moneyPerTrip = getMoney(lines, numberOfTrips);


    List<List<Integer>> flavorsPerTrip = getFlavors(lines, numberOfTrips);

    return doCalculateBestChoice(moneyPerTrip, flavorsPerTrip);
  }

  private List<String> doCalculateBestChoice(List<Integer> moneyPerTryp, List<List<Integer>> flavorsPerTrip) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < flavorsPerTrip.size(); i++) {
      Integer money = moneyPerTryp.get(i);
      List<Integer> flavors = flavorsPerTrip.get(i);

      String chosenFlavors = calculateChosenFlavors(money, flavors);
      result.add(chosenFlavors);
    }
    return result;
  }

  private String calculateChosenFlavors(int money, List<Integer> flavors) {
    int[] chosenFlavors = new int[2];

    for (int i = 0; i < flavors.size() - 1; i++) {
      for (int j = i + 1; j < flavors.size(); j++) {
        int flavorsValue = flavors.get(i) + flavors.get(j);
        if (money == flavorsValue) {
          chosenFlavors[0] = i;
          chosenFlavors[1] = j;
          break;
        }
      }
    }

    return result(chosenFlavors[0], chosenFlavors[1]);
  }

  private List<List<Integer>> getFlavors(List<String> lines, int numberOfTrips) {
    List<List<Integer>> flavorPerTrip = new ArrayList<>();

    int valuesIndex = 3;

    for (int i = 0; i < numberOfTrips; i++) {
      List<Integer> flavors = extractFlavors(lines, valuesIndex);
      flavorPerTrip.add(flavors);
      valuesIndex += TRIP_OFFSET;
    }

    return flavorPerTrip;
  }

  private List<Integer> extractFlavors(List<String> lines, int valuesIndex) {
    return stream(lines.get(valuesIndex).split(" "))
          .map(v -> Integer.parseInt(v))
          .collect(toList());
  }

  private List<Integer> getMoney(List<String> lines, int numberOfTrips) {
    List<Integer> moneyPerTrip = new ArrayList<>();
    int moneyIndex = 1;

    for (int i = 0; i < numberOfTrips; i++) {
      Integer money = extractMoney(lines, moneyIndex);
      moneyPerTrip.add(money);
      moneyIndex += TRIP_OFFSET;
    }

    return moneyPerTrip;
  }

  private Integer extractMoney(List<String> lines, int moneyIndex) {
    return Integer.valueOf(lines.get(moneyIndex));
  }

  private String result(int flavor1, int flavor2) {
    flavor1++;
    flavor2++;

    List<Integer> flavors = asList(flavor1, flavor2).stream()
        .sorted()
        .collect(toList());

    return String.valueOf(flavors.get(0))
        + " "
        + String.valueOf(flavors.get(1));
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
}