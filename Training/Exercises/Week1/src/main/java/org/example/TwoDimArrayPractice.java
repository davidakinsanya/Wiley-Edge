package org.example;

public class TwoDimArrayPractice {
  public static void main(String[] args) {
    int north[] = {120, 150, 100, 80};
    int south[] = {100, 149, 123, 91};
    int east[] =  {123, 111, 102, 89};
    int west[] =  {171, 90, 90, 101};


    int regionsQtrs[][] = {north, south, east, west};

    // 1
    int[] regionProfit = new int[4];
    int mostProfit = regionProfit[0];

    for (int i = 0; i < regionsQtrs.length; i++) {
      int profitCount = 0;

      for (int j = 0; j < regionsQtrs[i].length; j++) {
        profitCount += regionsQtrs[i][j];
      }
      regionProfit[i] = profitCount;
    }

    for (int i = 1; i < regionProfit.length-1; i++) {
      if (regionProfit[i] > mostProfit) {
        mostProfit = regionProfit[i];
      }
    }

    System.out.println("1. " + mostProfit);


    // 2
    System.out.println("\n");
    System.out.println("2.");
    for (int i = 0; i < regionsQtrs.length; i++) {
      int mostPerQuarter = regionsQtrs[i][0];

      for (int j = 1; j < regionsQtrs[i].length; j++) {
        if (regionsQtrs[i][j] > mostPerQuarter) {
          mostPerQuarter = regionsQtrs[i][j];
        }
      }
      System.out.println("Region " + (i+1) + ": " + mostPerQuarter);
    }

    // 3
    System.out.println("\n");
    int profitTotal = 0;

    for (int i = 0; i < regionsQtrs.length; i++) {
      for (int j = 0; j < regionsQtrs[i].length; j++) {
       profitTotal += regionsQtrs[i][j];
     }
    }

    System.out.println("3. Total Profit: " + profitTotal);

    // 4



    // 5
    System.out.println("\n");
    System.out.println("5.");

    for (int i = 0; i < regionsQtrs.length; i++) {
      int totalPerQuarter = 0;
      for (int j = 0; j < regionsQtrs.length; j++) {
        totalPerQuarter += regionsQtrs[j][i];
      }
      System.out.println("Total for Q" + (i+1) + ": " + totalPerQuarter);
    }

  /*
  Find the
  1. Most profitable region
  2. Most profitable region/Qtr
  3. Overall total
  4. Deviation from Average Total per Region
  5. Grand Total Per Qtr
   */

  }
}
