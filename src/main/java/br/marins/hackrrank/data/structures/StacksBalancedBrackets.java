package br.marins.hackrrank.data.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StacksBalancedBrackets {

  public static final String YES = "YES";
  public static final String NO = "NO";
  private static final String OPEN_BRACKETS = "{[(";

  private Stack<String> stack;

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    StacksBalancedBrackets balancedBrackets = new StacksBalancedBrackets();
    List<String> result = balancedBrackets.isBalanced(in);

    result.forEach(r -> System.out.println(r));
  }

  public List<String> isBalanced(InputStream input) throws IOException {
    List<String> lines = readLines(input);
    List<String> values = getValues(lines);
    List<String> ret = new ArrayList<>();

    values.forEach(v -> ret.add(isBalanced(v)));

    return ret;
  }

  private String isBalanced(String value) {
    stack = new Stack<>();
    char[] chars = value.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      String currentBracket = String.valueOf(chars[i]);
      if (isOpenBracket(currentBracket)) {
        stack.push(currentBracket);
      } else if (!matchesPreviousBracket(currentBracket)) {
        return NO;
      }
    }

    return stack.isEmpty() ? YES : NO;
  }

  private boolean isOpenBracket(String bracket) {
    return OPEN_BRACKETS.contains(bracket);
  }

  private boolean matchesPreviousBracket(String currentBracket) {
    if (stack.isEmpty()) {
      return false;
    }

    String openBracket = stack.pop();

    return "(".equals(openBracket) && ")".equals(currentBracket)
        || "[".equals(openBracket) && "]".equals(currentBracket)
        || "{".equals(openBracket) && "}".equals(currentBracket);
  }

  private List<String> getValues(List<String> lines) {
    List<String> values = new ArrayList<>();

    for (int i = 1; i <= getNumberOfLines(lines); i++) {
      values.add(lines.get(i));
    }

    return values;
  }

  private int getNumberOfLines(List<String> lines) {
    return Integer.parseInt(getMetadata(lines));
  }

  private String getMetadata(List<String> lines) {
    return lines.get(0);
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
