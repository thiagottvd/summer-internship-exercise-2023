package com.premiumminds.internship.snail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   * <p>
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  }

  /**
   * Tests the snail shell pattern generation for an empty matrix.
   * By the rules, an empty matrix should be represented by [[]].
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPatternEmptyMatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] actual = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[0];
    assertArrayEquals(expected, actual);
  }

  /**
   * Tests the snail shell pattern generation for a 1x1 matrix.
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPatternSingleElementMatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] actual = count.get(10, TimeUnit.SECONDS);
    int[] expected = {1};
    assertArrayEquals(expected, actual);
  }

  /**
   * Tests the snail shell pattern generation for a 2x2 matrix.
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPattern2x2MatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 4, 3 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] actual = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4 };
    assertArrayEquals(expected, actual);
  }

  /**
   * Tests the snail shell pattern generation for a 3x3 matrix.
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPattern3x3MatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  /**
   * Tests the snail shell pattern generation for a 8x8 matrix.
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPattern8x8MatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
            { 1, 2, 3, 4, 5, 6, 7, 8 },
            { 28, 29, 30, 31, 32, 33, 34, 9 },
            { 27, 48, 49, 50, 51, 52, 35, 10 },
            { 26, 47, 60, 61, 62, 53, 36, 11 },
            { 25, 46, 59, 64, 63, 54, 37, 12 },
            { 24, 45, 58, 57, 56, 55, 38, 13 },
            { 23, 44, 43, 42, 41, 40, 39, 14 },
            { 22, 21, 20, 19, 18, 17, 16, 15 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] actual = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[64];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = i + 1;
    }
    assertArrayEquals(expected, actual);
  }

  /**
   * Tests the snail shell pattern generation for a 11x11 matrix.
   *
   * @throws InterruptedException if the thread was interrupted during the test.
   * @throws ExecutionException if an execution exception occurs during the test.
   * @throws TimeoutException if the test times out.
   */
  @Test
  public void snailShellPattern11x11MatrixTest()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
            { 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 12 },
            { 39, 72, 73, 74, 75, 76, 77, 78, 79, 50, 13 },
            { 38, 71, 96, 97, 98, 99, 100, 101, 80, 51, 14 },
            { 37, 70, 95, 112, 113, 114, 115, 102, 81, 52, 15 },
            { 36, 69, 94, 111, 120, 121, 116, 103, 82, 53, 16 },
            { 35, 68, 93, 110, 119, 118, 117, 104, 83, 54, 17 },
            { 34, 67, 92, 109, 108, 107, 106, 105, 84, 55, 18 },
            { 33, 66, 91, 90, 89, 88, 87, 86, 85, 56, 19 },
            { 32, 65, 64, 63, 62, 61, 60, 59, 58, 57, 20 },
            { 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21 }
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] actual = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[121];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = i + 1;
    }
    assertArrayEquals(expected, actual);
  }
}