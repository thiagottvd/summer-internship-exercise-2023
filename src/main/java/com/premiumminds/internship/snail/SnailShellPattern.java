package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    int matrixLength = matrix[0].length;
    return executorService.submit( ()-> (matrixLength == 0) ? new int[0] : getSnailShellPattern(matrix, matrixLength));
  }

  /**
   * Method to get snail-shell pattern for a given NxN matrix.
   *
   * @param matrix matrix of numbers to go through.
   * @param matrixLength the matrix length.
   * @return order array of values thar represent a snail shell pattern.
   */
  private int[] getSnailShellPattern(int[][] matrix, int matrixLength) {
    int[] snailShellPattern = new int[matrixLength * matrixLength];
    int leftBound = 0;
    int rightBound = matrixLength - 1;
    int topBound = 0;
    int bottomBound = matrixLength - 1;
    int arrayIndex = 0;

    while (leftBound <= rightBound && topBound <= bottomBound) {
      for (int j = leftBound; j <= rightBound; j++) {
        snailShellPattern[arrayIndex++] = matrix[topBound][j];
      }
      topBound++;
      for (int i = topBound; i <= bottomBound; i++) {
        snailShellPattern[arrayIndex++] = matrix[i][rightBound];
      }
      rightBound--;
      for (int j = rightBound; j >= leftBound; j--) {
        snailShellPattern[arrayIndex++] = matrix[bottomBound][j];
      }
      bottomBound--;
      for (int i = bottomBound; i >= topBound; i--) {
        snailShellPattern[arrayIndex++] = matrix[i][leftBound];
      }
      leftBound++;
    }
    return snailShellPattern;
  }

}
