package br.marins.hacker.rank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;
    BubbleSort sorter = new BubbleSort();

    List<String> result = sorter.sort(in);

    sorter.print(result);
  }

  public List<String> sort(InputStream input) throws IOException {
    int values[] = getValues(input);
    int numberOfSwaps = 0;
    int numberOfValues = values.length;

    for (int i = 0; i < numberOfValues - 1; i++) {
      boolean swapped = false;
      for (int j = i + 1; j < numberOfValues; j++) {
        int valueJ = values[j];
        int valueI = values[i];
        if (valueJ < valueI) {
          swap(values, i, j);
          numberOfSwaps++;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }
    }

    return result(values, numberOfSwaps);
  }

  private void print(List<String> result) {
    for (int i = 1; i < result.size(); i++) {
      System.out.println(result.get(i));
    }
  }

  private List<String> result(int[] values, int numberOfSwaps) {
    List<String> result = new ArrayList<>();
    result.add(Arrays.toString(values));
    result.add(String.format("Array is sorted in %s swaps.", numberOfSwaps));
    result.add(String.format("First Element: %s", values[0]));
    result.add(String.format("Last Element: %s", values[values.length - 1]));
    return result;
  }

  private void swap(int[] values, int i, int j) {
    int valueI = values[i];
    int valueJ = values[j];

    values[i] = valueJ;
    values[j] = valueI;
  }

  private int[] getValues(InputStream input) throws IOException {
    List<String> lines = doReadLines(input);
    String[] values = lines.get(1).split(" ");
    return toInt(values);
  }

  private int[] toInt(String[] values) {
    int[] intValues = new int[values.length];

    for (int i = 0; i < values.length; i++) {
      intValues[i] = Integer.parseInt(values[i]);
    }

    return intValues;
  }

  private List<String> doReadLines(InputStream input) throws IOException {
    List<String> lines = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

    String line;
    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }

    return lines;
  }
}
