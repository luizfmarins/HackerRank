package br.marins.hacker.rank.algorithms;

import java.io.InputStream;
import java.util.List;

public class BubbleSort {

  public List<String> sort(InputStream input) {
    int n = 0;
    int a[] = new int[0];
    for (int i = 0; i < n; i++) {
      // Track number of elements swapped during a single array traversal
      int numberOfSwaps = 0;

      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          swap(a[j], a[j + 1]);
          numberOfSwaps++;
        }
      }

      // If no elements were swapped during a traversal, array is sorted
      if (numberOfSwaps == 0) {
        break;
      }
    }

    return null;
  }

  private void swap(int i, int i1) {
  }
}
