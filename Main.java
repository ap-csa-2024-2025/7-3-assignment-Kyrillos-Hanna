import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    ArrayList<String> arr1 = new ArrayList<String>();
    ArrayList<Integer> arr2 = new ArrayList<Integer>();
    ArrayList<Integer> arr3 = new ArrayList<Integer>();

    arr1.add("dogs");
    arr1.add("monkeys");
    arr1.add("cats");

    arr2.add(2);
    arr2.add(5);
    arr2.add(7);
    arr2.add(5);

    arr3.add(1);
    arr3.add(5);
    arr3.add(9);
    arr3.add(5);
    arr3.add(1);


    System.out.println(arr1);
    shiftLeft(arr1);
    System.out.println(arr1);

    printStatistics(arr2);
    printStatistics(arr3);
  }

  public static void shiftLeft(ArrayList<String> arr)
  {
    String first = arr.get(0);
    arr.remove(0);
    arr.add(first);
  }

  public static void printStatistics(final ArrayList<Integer> arr)
  {
    int sum = 0;
    boolean multipleModes = false;
    double average = 0;
    int modeCounter = 0;
    int mode = 0;

    for (int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
      int tempMode = 1;
      for (int k = i+1; k < arr.size(); k++) {
        if (arr.get(i).equals(arr.get(k))) {
          tempMode++;
        }
      }

      if (tempMode > modeCounter) {
        modeCounter = tempMode;
        mode = arr.get(i);
        multipleModes = false;
      } else if (tempMode == modeCounter && !multipleModes) {
        multipleModes = true;
      }
      

    }

    average = (double) sum / arr.size();

    System.out.println("Sum: " + sum);
    System.out.println("Average: " + average);
    if (!multipleModes) {
      System.out.println("Mode: " + mode);
    } else {
      System.out.println("Mode: no singular mode");
    }

  }
}
