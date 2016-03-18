
public class QuickSort 
{	
	public static int[] iArray;	
	public static void quickSort(int iLowerIndex, int iUpperIndex)
	{
		if(iLowerIndex < iUpperIndex)
		{	
			int iPivot = partitionData(iLowerIndex, iUpperIndex);	
			if(iLowerIndex < (iPivot-1))
			{
				//Quick sort first half of the array
				quickSort(iLowerIndex, iPivot-1);
			}
			if(iUpperIndex > iPivot)
			{
				//Quick sort second half of the array
				quickSort(iPivot, iUpperIndex);	
			}			
		}		
	}
	
	private static int partitionData(int iLowIndex, int iUpIndex)
	{		
		int j = iUpIndex;
		int i = iLowIndex;
		int iTemp = 0;		
		//Taking the left most element in the array as the pivot
		int iPivot = iArray[i];		
		while(i <= j)
		{			
			//Go to next element as current element is in correct order wrt the pivot
			while(iArray[i] < iPivot)
			{				
				i++;				
			}
			//Go to next element as current element is in correct order wrt the pivot
			while(iArray[j] > iPivot)
			{				
				j--;				
			}			
			//Now this element is not in correct order with the pivot - lets swap this
			if(i <= j)
			{				
				iTemp = iArray[j];
				iArray[j] = iArray[i];
				iArray[i] = iTemp;				
				i++;
				j--;				
			}			
		}		
		return i;			
	}
}
