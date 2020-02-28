package assign1;
/**
 * @author Chance Engstrom 
 * Class ID: 132
 * Assignment: 2
 * Contains methods to manipulate a integer array with an initial size of 10
 */
public class SimpleList
{
	private int list[];
	private int count;
	public int maxSize;
	/**
	 * Constructor: Initialize private variables
	 */
	public SimpleList()
	{
		maxSize = 10;
		list = new int[maxSize];
		count = 0;
	}
	/**
	 * Adds integer to list
	 * @param num integer to be added
	 */
	public void add(int num)
	{
		if(count > 0)
		{
			if(count != maxSize)
			{
				count++;
				int size = count - 1;
				list[size] = num;
				for(int index = 0;index < size;index++)//Pushes array elements back
				{
					int temp = list[index];//Swap last element with current index
					list[index] = list[size];
					list[size] = temp;
				}
			}
			else
			{
				maxSize = maxSize + maxSize/2;//Increase array size by 50%
				int[] newList = new int[maxSize];
				for(int index = 0; index<count;index++)
				{
					newList[index] = list[index];
				}
				list = newList;
				count++;
				int size = count - 1;
				list[size] = num;
				for(int index = 0;index < size;index++)//Pushes array elements back
				{
					int temp = list[index];//Swap last element with current index
					list[index] = list[size];
					list[size] = temp;
				}
			}
		}
		else
		{
			list[count] = num;
			count++;
		}
	}
	/**
	 * removes integer from list if found
	 * @param num integer to be removed
	 */
	public void remove(int num)
	{
		int emptyIndex = search(num);

		if(emptyIndex != -1)
		{
			int size = count-1;
			list[emptyIndex] = 0;
			count--;
			for(int index = emptyIndex;index < count; index++)//Pushes elements forward
			{
				int temp = list[index];
				list[index] = list[size];
				list[size] = temp;
			}
			if(maxSize != 0 || maxSize != 1)
			{
				int percentageOccupied = (count * 100)/maxSize;
				if(percentageOccupied < 25)
				{
					int sizeToDecrease = (maxSize/4);
					if(sizeToDecrease == 0)
						sizeToDecrease = 1;
					maxSize = maxSize - sizeToDecrease;
					
					int[] newList = new int[maxSize];
					for(int index = 0; index<count;index++)
					{
						newList[index] = list[index];
					}
					list = newList;
				}
			}
		}
	}
	/**
	 * Gets number of elements in array
	 * @return number of elements in array
	 */
	public int count()
	{
		return count;
	}
	/**
	 * Returns list into a string
	 */
	public String toString()
	{
		String output = "";
		for(int index = 0; index < count; index++)
		{
			output += String.valueOf(list[index]) + " ";
		}
		output = output.trim();
		return output;
	}
	/**
	 * Search for an integer in the array
	 * @param num integer to be searched for
	 * @return index if found -1 if not found
	 */
	public int search(int num)
	{
		for(int index = 0; index<count; index++)
		{
			int currentNum = list[index];
			if(currentNum == num)
			{
				return(index);
			}
		}
		return -1;
	}
}