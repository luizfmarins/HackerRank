package br.marins.hackrrank.data.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArraysLeftRotation {

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    ArraysLeftRotation arrays = new ArraysLeftRotation();
    String[] values = arrays.rotateLeft(in);

    arrays.print(values);
  }

  public String[] rotateLeft(InputStream input) throws IOException {
    List<String> lines = doReadLines(input);

    int numberOfRotations = getNumberOfRotations(lines);

    String[] values = getValues(lines);
    String[] rotated = new String[values.length];

    for (int i = 0; i < values.length; i++) {
      int indexRotatedElement = indexRotatedElement(i, numberOfRotations, values.length);
      rotated[indexRotatedElement] = values[i];
    }

    return rotated;
  }

  public void print(String[] values) {
    System.out.print(values[0]);

    for (int i = 1; i < values.length; i++) {
      System.out.print(" " + values[i]);
    }
  }

  protected int indexRotatedElement(int index, int numberOfRotations, int lenght) {
    int newIndex = index - numberOfRotations;
    if (newIndex < 0) {
      return newIndex + lenght;
    }
    return newIndex;
  }

  private int getNumberOfRotations(List<String> lines) {
    String[] metadata = getMetadata(lines);
    return Integer.valueOf(metadata[1]);
  }

  private String[] getMetadata(List<String> lines) {
    return lines.get(0).split(" ");
  }

  private String[] getValues(List<String> lines) {
    return lines.get(1).split(" ");
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