public class DualPivotQuickSort
{
	public static int[] iArray;		
	public static void sortData(int iLowIndex, int iUpIndex)
	{	
		if(iUpIndex <= iLowIndex)
		{
			return;
		}
		else
		{
			int j = iUpIndex;
			int i = iLowIndex;
			
			//Making sure that iArray[i] <= iArray[j]
			if(iArray[i] > iArray[j])
			{
				swap(i,j);
			}		
			int iPivot1 = i+1;
			int iPivot2 = j-1;
			int iPivot3 = i+1;
			
			while(iPivot3 < iPivot2)
			{
				//Sorting in first sub array and finding the point where the array elements are out of order
				//going left to right
				if(iArray[iPivot3] < iArray[iPivot1])
				{
					swap(iPivot3,iPivot1);
					iPivot3++;
					iPivot1++;
				}
				//Sorting in second sub array and finding the point where the array elements are out of order
				//going right to left
				else if(iArray[iPivot2] < iArray[iPivot1])
				{
					swap(iPivot1,iPivot2);
					iPivot2--;
				}
				//If elements are in order - increment the since of the left sub array
				else
				{
					iPivot3++;
				}
			}	
			
			//End of algorithm
			//Swap A[p] with A[l-1]
			--iPivot1;
			swap(iLowIndex, iPivot1);
			//Swap A[j+1] with A[r]
			++iPivot2;
			swap(iUpIndex, iPivot2);
			
			//Now recursively sort each of the 3 sub arrays
			//Sub array from A[p] to A[l-1]
			sortData(iLowIndex, iPivot1-1);
	        if (iArray[iPivot1] < iArray[iPivot2])
	    	{
	        	//Sub array from A[l+1] to A[j-1]
	        	sortData(iPivot1+1, iPivot2-1);
	    	}
	      //Sub array from A[j+1] to A[r]
	        sortData(iPivot2+1, iUpIndex);
		}		
	}	
	
	public static void swap(int iIndex1, int iIndex2)
	{
		int iTemp = iArray[iIndex1];
		iArray[iIndex1] = iArray[iIndex2];
		iArray[iIndex2] = iTemp;		
	}
}
