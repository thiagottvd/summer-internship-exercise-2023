package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
}