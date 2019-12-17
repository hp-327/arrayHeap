package p9_package;

public class ArrayHeapClass
{
	private int arrayCapacity;
	private int arraySize;
	int DEFAULT_ARRAY_CAPACITY = 10;
	private boolean displayFlag;
	private StudentClass[] heapArray;
	
	/**
	 * Default constructor sets up array management 
	 * conditions and default display flag setting
	 */
	public ArrayHeapClass()
	{
		arrayCapacity = DEFAULT_ARRAY_CAPACITY;
		arraySize = 0;
		displayFlag = false;
		heapArray = new StudentClass[arrayCapacity];
	}
	/**
	 * Copy constructor copies array and array management 
	 * conditions and default display flag setting
	 * @param copied - ArrayHeapClass object to be copied
	 */
	public ArrayHeapClass(ArrayHeapClass copied)
	{
		this.arrayCapacity = copied.arrayCapacity;
		this.arraySize = copied.arraySize;
		this.displayFlag = copied.displayFlag;
		heapArray = new StudentClass[arrayCapacity];
		int index;
		for (index=0; index<arraySize; index++)
		{
			this.heapArray[index]= new StudentClass (copied.heapArray[index]);
		}
	}
	/**
	 * Accepts StudentClass item and adds it to heap
	 * Note: uses bubbleUpArrayHeap to resolve unbalanced 
	 * heap after data addition
	 * Note: Always checks for resize before adding data
	 * @param newItem - StudentClass item to be added
	 */
	void addItem(StudentClass newItem)
	{
		checkForResize();
		if (displayFlag)
		{
			System.out.println("Adding new student: " +  newItem);
		}
		heapArray[arraySize] = newItem;
		arraySize++;
		bubbleUpArrayHeap(arraySize-1);
	}
	/**
	 * Recursive operation to reset data in the correct 
	 * order for the max heap after new data addition
	 * @param currentIndex - index of current item being assessed, 
	 * and moved up as needed
	 */
	private void bubbleUpArrayHeap(int currentIndex)
	{
		if(currentIndex > 0)
		{
			int parentIndex = (currentIndex-1)/2;
			StudentClass parentData = heapArray[parentIndex];
			StudentClass currentData = heapArray[currentIndex];
			if(currentData.compareTo(parentData) > 0)
			{
				if (displayFlag)
				{
					System.out.println("	- Bubble up:");
					System.out.println("     - Swapping parent: " + 
					parentData.toString()+ "with child: " + 
							currentData.toString());
				}
				heapArray[parentIndex] = heapArray[currentIndex];
				heapArray[currentIndex] = parentData;
				bubbleUpArrayHeap(parentIndex);
			}
		}
	}
	
	/**
	 * Automatic resize operation used prior to any new 
	 * data addition in the heap
	 * Note: Tests for full heap array, and resizes to twice 
	 * the current capacity as required
	 */
	private void checkForResize()
	{
		if (arraySize == arrayCapacity)
		{
			arrayCapacity = arrayCapacity*2;
			StudentClass[] tempArray = new StudentClass[arrayCapacity];
			int index;
			for (index=0; index<arraySize; index++)
			{
				tempArray[index]= heapArray[index];
			}
			heapArray = tempArray;
		}
		
	}
	/**
	 * Tests for empty heap
	 * @return: boolean result of test
	 */
	public boolean isEmpty()
	{
		return arraySize == 0; 
	}
	/**
	 * Removes StudentClass item from top of max heap\
	 * Note: Uses trickleDownArrayHeap to resolve unbalanced 
	 * heap after data removal
	 * @returnStudentClass item removed
	 */
	public StudentClass removeItem()
	{
		StudentClass temp = null;
		if(arraySize>0)
		{
			temp = heapArray[0];
			if (displayFlag)
			{
				System.out.println("Removing student: " + heapArray[0].name);
			}
			arraySize--;
			heapArray[0] = heapArray[arraySize];
			trickleDownArrayHeap(0);
		}
		return temp; 
	}
	/**
	 * Utility method to set the display flag for displaying internal
	 *  operations of the heap bubble and trickle operations
	 * @param setState - flag used to set the state to display, or not
	 */
	public void setDisplayFlag(boolean setState)
	{
		displayFlag = setState;
	}
	/**
	 * Dumps array to screen as is, no filtering or management
	 */
	public void showArray()
	{
		int index;
		for (index = 0; index == arraySize; index++)
		{
			System.out.println(heapArray[index].toString());
		}
	}
	
	/**
	 * Recursive operation to reset data in the correct order 
	 * for the max heap after data removal
	 * @param currentIndex- index of current item being assessed, 
	 * and moved down as required
	 */
	private void trickleDownArrayHeap(int currentIndex)
	{
		int rightChildIndex = (currentIndex*2)+2;
		int leftChildIndex = (currentIndex*2)+1;
		StudentClass parentData = heapArray[currentIndex];
		StudentClass rightChild, leftChild;
		if (rightChildIndex < arraySize)
		{
			rightChild = heapArray[rightChildIndex];
			leftChild = heapArray[leftChildIndex];
			
			if ( rightChild.compareTo(parentData) > 0 && 
					rightChild.compareTo(leftChild) > 0 )
			{
				if (displayFlag)
				{
					System.out.println("	- Trickle down:");
					System.out.println("		- Swapping Parent: " + 
					parentData + " with right child: " + rightChild);
				}
				heapArray[currentIndex] = rightChild;
				heapArray[rightChildIndex] = parentData;
				trickleDownArrayHeap(rightChildIndex);
			}
		}
		if (leftChildIndex<arraySize)
		{
			leftChild = heapArray[leftChildIndex];
			parentData = heapArray[currentIndex];
			if (leftChild.compareTo(parentData)>0)
			{
				if (displayFlag)
				{
					System.out.println("	- Trickle down:");
					System.out.println("		- Swapping Parent: " + 
					parentData + " with left child: " + leftChild);
				}
				heapArray[currentIndex] = leftChild;
				heapArray[leftChildIndex] = parentData;
				trickleDownArrayHeap(leftChildIndex);
			}
		}
	}
	
}


























