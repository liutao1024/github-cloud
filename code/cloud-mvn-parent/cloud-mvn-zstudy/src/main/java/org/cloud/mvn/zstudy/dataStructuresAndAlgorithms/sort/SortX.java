package org.cloud.mvn.zstudy.dataStructuresAndAlgorithms.sort;

public class SortX {
	public static void main(String[] args) {
//		ShellSortAPI(100);
		PartitionSortAPI(16);
//		QuickSortAPI(100);
	}
	
	/**
	 * @Author LiuTao @Date 2020年6月5日 上午11:14:03 
	 * @Title: ShellSortAPI 
	 * @Description: 希尔排序
	 */
	public static void ShellSortAPI(int max){
		ArrayShell arr = new ArrayShell(max);
		for (int i = 0; i < max; i++) {
			long value = (long) (Math.random() * 99);
			arr.insert(value);
		}
		arr.display();
		arr.shellSort();
		arr.display();
	}
	/**
	 * @Author LiuTao @Date 2020年6月5日 下午1:44:54 
	 * @Title: PartitionSortAPI 
	 * @Description: 划分
	 */
	public static void PartitionSortAPI(int max){
		ArrayPartition arr = new ArrayPartition(max);
		for (int i = 0; i < max; i++) {
			long value = (long) (Math.random() * 199);
			arr.insert(value);
		}
		arr.display();
		long pivot = 99;
		System.out.print("Piovt is " + pivot);
		int size = arr.size();
		int partDex = arr.partitionSort(0, size - 1, 99);
		System.out.println(", Partition is at index " + partDex);
		arr.display();
	}
	/**
	 * @Author LiuTao @Date 2020年6月8日 上午10:55:24 
	 * @Title: QuickSortAPI 
	 * @Description: 快速排序
	 */
	public static void QuickSortAPI(int max){
		ArrayIns arr1 = new ArrayIns(max);
		for (int i = 0; i < max; i++) {
			long value = (long) (Math.random() * 99);
			arr1.insert(value);
		}
		arr1.display();
		arr1.quickSort1();
		arr1.display();
		
		ArrayIns arr2 = new ArrayIns(max);
		for (int i = 0; i < max; i++) {
			long value = (long) (Math.random() * 99);
			arr2.insert(value);
		}
		arr2.display();
		arr2.quickSort1();
		arr2.display();
	}
}

/**
 * @Author LiuTao @Date 2020年6月5日 下午1:44:41
 * @ClassName: ArrayParent 
 * @Description: TODO(Describe)
 */
class ArrayParent{
	protected long[] theArray;
	protected int nElems;
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	public void display() {
		System.out.print("Array = [ ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	public int size(){
		return nElems;
	}
	public void swap(int dex1, int dex2){
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}

/**
 * @Author LiuTao @Date 2020年6月5日 上午11:13:58
 * @ClassName: ArrayShell 
 * @Description: TODO(Describe)
 */
class ArrayShell extends ArrayParent{
	public ArrayShell(int max){
		theArray = new long[max];
		nElems = 0;
	}
	public void shellSort(){
		int inner, outer;
		long temp;
		int h = 1;
		while(h <= nElems/3)
			h = h * 3 + 1;
		while(h > 0){
			for(outer = h; outer < nElems; outer++){
				temp = theArray[outer];
				inner = outer;
				while(inner > h - 1 && theArray[inner - h] >= temp){
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}
/**
 * @Author LiuTao @Date 2020年6月8日 下午4:36:37
 * @ClassName: ArrayPartition 
 * @Description: TODO(Describe)
 */
class ArrayPartition extends ArrayParent{
	public ArrayPartition(int max){
		theArray = new long[max];
		nElems = 0;
	}
	public int partitionSort(int left, int right, long pivot){
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while(true){
			while(leftPtr < right && theArray[leftPtr] < pivot)
				++leftPtr;
			while(rightPtr > left && theArray[rightPtr] > pivot)
				--rightPtr;
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		return leftPtr;
	}
}
/**
 * @Author LiuTao @Date 2020年6月8日 上午10:53:29
 * @ClassName: ArrayIns 
 * @Description: TODO(Describe)
 */
class ArrayIns extends ArrayParent{
	public ArrayIns(int max){
		theArray = new long[max];
		nElems = 0;
	}
	public void quickSort1(){
		recQuickSort1(0, nElems - 1);
	}
	public void recQuickSort1(int left, int right){
		if(right - left <= 0){
			return;
		}else {
			long pivot = theArray[right];
			int partition = partitionIt1(left, right, pivot);
			recQuickSort1(left, partition - 1);
			recQuickSort1(partition + 1, right);
			
		}
	}
	public int partitionIt1(int left, int right, long pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true){
			while(theArray[++leftPtr] < pivot);
			while(rightPtr > 0 && theArray[--rightPtr] > pivot);
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}
	/***************************************************************/
	public void quickSort2(){
//		recQuickSort2(0, nElems - 1);
		insertionSort(0, nElems - 1);
	}
	public void recQuickSort2(int left, int right){
		int size = right - left + 1;
		if(size <= 3){
			menualSort(left, right);
		}else {
			long median = medianOf3(left, right);
			int partition = partitionIt2(left, right, median);
			recQuickSort2(left, partition - 1);
			recQuickSort2(partition + 1, right);
			
		}
	}
	public long medianOf3(int left, int right){
		int center = (left + right) / 2;
		if(theArray[left] > theArray[center])
			swap(left, center);
		if(theArray[left] > theArray[right])
			swap(left, right);
		if(theArray[center] > theArray[right])
			swap(center, right);
		swap(center, right - 1);
		return theArray[right - 1];
	}
	public void menualSort(int left, int right){
		int size = right - left + 1;
		if(size <= 1){
			return;
		}else if(size == 2){
			if(theArray[left] > theArray[right])
				swap(left, right);
			return;
		}else {
			if(theArray[left] > theArray[right - 1])
				swap(left, right - 1);
			if(theArray[left] > theArray[right])
				swap(left, right);
			if(theArray[right - 1] > theArray[right])
				swap(right - 1, right);
		}
	}
	public int partitionIt2(int left, int right, long pivot){
		int leftPtr = left;
		int rightPtr = right - 1;
		while(true){
			while(theArray[++leftPtr] < pivot);
			while(theArray[--rightPtr] > pivot);
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);
		return leftPtr;
	}
	public void insertionSort(int left, int right){
		int in, out;
		for(out = left + 1; out <= right; out++){
			long temp = theArray[out];
			in = out;
			while(in > left && theArray[in - 1] >= temp){
				theArray[in] = theArray[in - 1];
				--in;
			}
			theArray[in] = temp;
		}
	}
}
