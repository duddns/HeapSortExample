package example;

public class HeapSort {

  public static int[] sort(int[] data) {
    if (null == data) {
      return null;
    }
    
    if (0 == data.length) {
      return data;
    }
    
    if (1 == data.length) {
      return data;
    }
    
    if (2 == data.length) {
      if (data[1] < data[0]) {
        data[0] = data[0] + data[1];
        data[1] = data[0] - data[1];
        data[0] = data[0] - data[1];
      }
      return data;
    }
    
    data = makeHeapTree(data);
    
    data = heapSort(data);
    
    return data;
  }
  
  private static int[] makeHeapTree(int[] data) {
    for (int index = 1; index < data.length; index++) {
      int parent = (index - 1) / 2;
      if (data[index] > data[parent]) {
        moveToParent(data, index, parent);
      }
    }
    
    return data;
  }
  
  private static int[] moveToParent(int[] data, int index, int parent) {
    if (0 > parent) {
      return data;
    }
    
    if (data[index] > data[parent]) {
      swap(data, index, parent);

      index = parent;
      parent = (index - 1) / 2;
      
      return moveToParent(data, index, parent);
    }
    
    return data;
  }
  
  private static int[] heapSort(int[] data) {
    int last = data.length - 1;
    while (0 < last) {
      swap(data, 0, last);
      
      last--;
      
      if (0 == last) {
        if (data[1] < data[0]) {
          data = swap(data, 0, 1);
        }
      } else {
        data = sortToChild(data, 0, last);
      }
    }
    return data;
  }
  
  private static int[] sortToChild(int[] data, int start, int end) {
    int leftChild = 2 * start + 1;
    int rightChild = 2 * start + 2;
    
    if (end < leftChild || end < rightChild) {
      return data;
    }
    
    int child = (data.length - 1 < rightChild) ? leftChild
        : (data[leftChild] < data[rightChild]) ? rightChild : leftChild;
    
    if (data[start] < data[child]) {
      swap(data, start, child);
      
      return sortToChild(data, child, end);
    }
    
    return data;
  }
  
  private static int[] swap(int[] data, int from, int to) {
    data[from] = data[from] + data[to];
    data[to] = data[from] - data[to];
    data[from] = data[from] - data[to];
    
    return data;
  }
}
