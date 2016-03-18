import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class QuickSortDriver
{
	//Arguments: "E:\\CS6301 - Implementation of advanced data structures & algorithms\\HW\\Short Project 0\\data.txt"
	public static int iSize = 20;
    private static int iPhase = 0;
    private static long lStartTime;
    private static long lEndTime; 
    private static long lElapsedTime;
    
	public static void main(String[] args) 
	{
		int[] iArray = new int[iSize];
		QuickSort qsQuickSort = new QuickSort();
		DualPivotQuickSort qsTwoPivot = new DualPivotQuickSort();
		
		//No file passed as argument then generate random numbers as array elements and sort them
		if(args.length == 0)
		{
			Random rRandomGenerator = new Random();
			int iTemp = rRandomGenerator.nextInt(10 * iSize);
			for(int i=0; i<iSize; i++) 
			{
				iArray[i] = rRandomGenerator.nextInt(10 * iSize);
			}
		}
		else
		{
			//Read data from a file
			try
			{
				File fInputFile = new File(args[0]);
				Scanner sc = new Scanner(fInputFile);
				int iIndex = -1;
				System.out.println("Reading from file...");	
				while(sc.hasNext())
				{
					iIndex = iIndex + 1;
					iArray[iIndex] = sc.nextInt();
				}				
			}
			catch(Exception e)
			{				
				System.err.println("Error while reading from file...");	
			}
		}
		//System.out.println("Array Before sorting...");
		/*for(int i=0; i<iSize; i++) 
		{
			System.out.println(iArray[i]);	
		}*/
		
		qsQuickSort.iArray = iArray;
		qsTwoPivot.iArray = iArray;
		
		//Quick Sort - Generic
		System.out.println("Using Quick Sort to order " + iSize + " elements...");
		timer();
		QuickSort.quickSort(0,iArray.length-1);
		timer();
		System.out.println();
		System.out.println("Sorted Array: Generic Quick Sort");
		for(int i=0; i<iSize; i++) 
		{
			System.out.println(qsQuickSort.iArray[i]);	
		}
		System.out.println();
		//Quick Sort - Dual Pivot
		iPhase = 0;
		System.out.println("Using Quick Sort - Dual Pivot to order " + iSize + " elements...");
		timer();
		qsTwoPivot.sortData(0,iArray.length-1);
		timer();
		System.out.println();
		System.out.println("Sorted Array: Dual Pivot Quick Sort");
		for(int i=0; i<iSize; i++) 
		{
			System.out.println(qsTwoPivot.iArray[i]);	
		}
	}

	//Using code from Professor as made available in class to record time
	public static void timer()
    {
		if(iPhase == 0) 
		{			
			lStartTime = System.currentTimeMillis();
			iPhase = 1;	
		}
		else 
		{
			lEndTime = System.currentTimeMillis();
	        lElapsedTime = lEndTime - lStartTime;
	        System.out.println("Time: " + lElapsedTime + " msec.");
	        memory();
	        iPhase = 0;   
        }
    }

	//Using code from Professor as made available in class to record memory usage
    public static void memory() 
    {
        long lMemAvailable = Runtime.getRuntime().totalMemory();
        long lMemUsed = lMemAvailable - Runtime.getRuntime().freeMemory();   
        System.out.println("Memory: " + lMemUsed/1000000 + " MB / " + lMemAvailable/1000000 + " MB.");
    }
}
