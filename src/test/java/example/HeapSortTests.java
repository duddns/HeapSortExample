package example;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapSortTests {

  @Test
  public void testSort1() {
    int[] input = { 1 };
    int[] expected = { 1 };
    
    int[] output = HeapSort.sort(input);
    assertArrayEquals(expected, output);
  }
  
  @Test
  public void testSort2() {
    int[] input = { 2, 1 };
    int[] expected = { 1, 2 };
    
    int[] output = HeapSort.sort(input);
    assertArrayEquals(expected, output);
  }
  
  @Test
  public void testSort3() {
    int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
    
    int[] output = HeapSort.sort(input);
    assertArrayEquals(expected, output);
  }
  
  @Test
  public void testSort4() {
    int[] input = { 77, 6, 9, 7, 1, 3, 2, 92, 55, 22, 5, 88, 33, 11, 8 };
    int[] expected = { 1, 2, 3, 5, 6, 7, 8, 9, 11, 22, 33, 55, 77, 88, 92 };
    
    int[] output = HeapSort.sort(input);
    assertArrayEquals(expected, output);
  }
}
