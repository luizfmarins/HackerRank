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
    List<Trip> trips = getTrips(input);

    return doCalculateBestChoice(trips).stream()
        .map(c -> c.getResult())
        .collect(toList());
  }

  private List<ChosenFlavors> doCalculateBestChoice(List<Trip> trips) {
    List<ChosenFlavors> result = new ArrayList<>();

    for (Trip trip : trips) {
      ChosenFlavors chosenFlavors = calculateChosenFlavors(trip);
      result.add(chosenFlavors);
    }

    return result;
  }

  private ChosenFlavors calculateChosenFlavors(Trip trip) {
    for (int i = 0; i < trip.getFlavorsSize() - 1; i++) {
      for (int j = i + 1; j < trip.getFlavorsSize(); j++) {
        int flavorsValue = trip.getFlavor(i) + trip.getFlavor(j);
        if (trip.getMoney() == flavorsValue) {
          return new ChosenFlavors(i, j);
        }
      }
    }

    throw new IllegalStateException();
  }

  private List<Trip> getTrips(InputStream in) throws IOException {
    List<String> lines = readLines(in);

    int numberOfTrips = getNumberOfTrips(lines);

    List<Integer> moneyPerTrip = getMoney(lines, numberOfTrips);
    List<List<Integer>> flavorsPerTrip = getFlavors(lines, numberOfTrips);

    List<Trip> trips = new ArrayList<>();
    for (int i = 0; i < numberOfTrips; i++) {
      trips.add(new Trip(moneyPerTrip.get(i), flavorsPerTrip.get(i)));
    }

    return trips;
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

class Trip {

  private final int money;
  private final List<Integer> flavors;

  public Trip(int money, List<Integer> flavors) {
    this.money = money;
    this.flavors = flavors;
  }

  public int getMoney() {
    return money;
  }

  public Integer getFlavor(int index) {
    return flavors.get(index);
  }

  public int getFlavorsSize() {
    return flavors.size();
  }

  @Override
  public String toString() {
    return money + "\n" + flavors;
  }
}

class ChosenFlavors {

  private final int flavor1;
  private final int flavor2;

  public ChosenFlavors(int flavor1, int flavor2) {
    this.flavor1 = flavor1;
    this.flavor2 = flavor2;
  }

  public String toString() {
    return getResult();
  }

  public String getResult() {
    int flavor1 = this.flavor1 + 1;
    int flavor2 = this.flavor2 + 1;

    List<Integer> flavors = asList(flavor1, flavor2).stream()
        .sorted()
        .collect(toList());

    return String.valueOf(flavors.get(0))
        + " "
        + String.valueOf(flavors.get(1));
  }
}