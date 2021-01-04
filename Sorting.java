import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
//		
//		int[] shortRepeat = repeat(1);
//		int[] shortMostlySorted = mostlySorted(1);
//		int[] shortReverse = reverse(1);
//		int[] shortRandom = random(1);
//		int[] mediumRepeat = repeat(2);
//		int[] mediumMostlySorted = mostlySorted(2);
//		int[] mediumReverse = reverse(2);
//		int[] mediumRandom = random(2);
//		int[] longRepeat = repeat(3);
//		int[] longMostlySorted = mostlySorted(3);
//		int[] longReverse = reverse(3);
//		int[] longRandom = random(3);
		
		int[] array = {4, 7, 2, 9, 1, 6};
		insertionSort(array);
		System.out.println("mine" + Arrays.toString(array));
		insertionSort2(array);
		System.out.println("text" + Arrays.toString(array));
		
//		System.out.println(Arrays.toString(shortRandom));
//		quickSort(shortRandom, 0, shortRandom.length - 1);
//		System.out.println(Arrays.toString(shortRandom));
//		
//		System.out.println("Short Repeat: ");
//		compareTimes(shortRepeat);
//		System.out.println();
//		
//		System.out.println("Short Mostly Sorted: ");
//		compareTimes(shortMostlySorted);
//		System.out.println();
//		
//		System.out.println("Short Reverse: ");
//		compareTimes(shortReverse);
//		System.out.println();
//		
//		System.out.println("Short Random: ");
//		compareTimes(shortRandom);
//		System.out.println();
//		
//		System.out.println("Medium Repeat: ");
//		compareTimes(mediumRepeat);
//		System.out.println();
//		
//		System.out.println("Medium Mostly Sorted: ");
//		compareTimes(mediumMostlySorted);
//		System.out.println();
//		
//		System.out.println("Medium Reverse: ");
//		compareTimes(mediumReverse);
//		System.out.println();
//		
//		System.out.println("Medium Random: ");
//		compareTimes(mediumRandom);
//		System.out.println();
//		
//		System.out.println("Long Repeat: ");
//		compareTimes(longRepeat);
//		System.out.println();
//		
//		System.out.println("Long Mostly Sorted: ");
//		compareTimes(longMostlySorted);
//		System.out.println();
//		
//		System.out.println("Long Reverse: ");
//		compareTimes(longReverse);
//		System.out.println();
//		
//		System.out.println("Long Random: ");
//		compareTimes(longRandom);
//		System.out.println();
//		
		
	}
	
	public static void compareTimes(int[] array) {
		long startTime = System.nanoTime();
		selectionSort(array);
		long endTime = System.nanoTime();
		System.out.println("selection: " + (endTime - startTime));		
		
		long startTime2 = System.nanoTime();
		insertionSort(array);
		long endTime2 = System.nanoTime();
		System.out.println("insertion: " + (endTime2 - startTime2));
		
		long startTime3 = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		long endTime3 = System.nanoTime();
		System.out.println("insertion: " + (endTime2 - startTime2));
	}
	
	// Length: 1 = short, 2 = medium, 3 = long;
		public static int[] repeat(int length) {
			int[] output = new int[(int) ((Math.pow(10, length)))];
			for (int i = 0; i < output.length; i++) {
				output[i] = (int) (Math.random() * 4) + 5;
			}
			return output;
		}

	// Length: 1 = short, 2 = medium, 3 = long;
		public static int[] mostlySorted(int length) {
			int[] output = new int[(int) ((Math.pow(10, length)))];
			for (int i = 0; i < output.length; i++) {
				output[i] = i;
			}
			for (int j = 0; j < output.length / 5; j++) {
				int temp = output[(int) (Math.random() * output.length)];
				int temp2 = output[(int) (Math.random() * output.length)];
				output[temp] = output[temp2];
				output[temp2] = output[temp];
			}
			return output;
		}

	// Length: 1 = short, 2 = medium, 3 = long;
		public static int[] reverse(int length) {
			int[] temp = mostlySorted(length);
			int[] output = new int[temp.length];

			for (int i = 0; i < output.length; i++) {
				output[i] = temp[temp.length - (1 + i)];
			}
			return output;
		}

	// Length: 1 = short, 2 = medium, 3 = long;
		public static int[] random(int length) {
			int[] output = new int[(int) ((Math.pow(10, length)))];
		
			for (int i = 0; i < output.length; i++) {
				output[i] = (int)( Math.random() * output.length);
			}
			return output;
		
		}
		
		
	public static void quickSort(int[] array, int left, int right) {
		if (right - left <= 1) return;
		
		int pivot = array[left + (right - left) / 2];
		int low = left;
		int high = right;

		while (low <= high) {
			while (array[low] < pivot)
				low++;

			while (array[high] > pivot) 
				high--;
		
			if (low <= high) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
				low++;
				high--;
			}
		}

		if (left < high)
			quickSort(array, left, high);
		if (low < right)
			quickSort(array, low, right);
	}
		
	 public static void bestMergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		 if (leftStart <= rightEnd) return;
		 else if (array.length <= 7) {
			 insertionSort(array);
			 return;
		 }
		 int middle = (leftStart + rightEnd) / 2;
			 
		 mergeSort(array, temp, leftStart, middle);
		 mergeSort(array, temp, middle + 1, rightEnd);
		 mergeHalves(array, temp, leftStart, rightEnd);
			 
	 }
	 
	 public static void insertionSort2(int[] array, int start, int end) {
			for (int i = start; i < end; i++) {
				int index = i - 1;

				while (array[index] > array[index + 1] && index > 0) {
					int temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
					index--;
				}
			}
		}
		 
		
	 public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		 
		 if (leftStart <= rightEnd) return;
		 int middle = (leftStart + rightEnd) / 2;
		 
		 mergeSort(array, temp, leftStart, middle);
		 mergeSort(array, temp, middle + 1, rightEnd);
		 mergeHalves(array, temp, leftStart, rightEnd);
		 
	 }
	 
	 public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		 int leftEnd = (rightEnd + leftStart) / 2;
		 int rightStart = leftEnd + 1;
		 int size = (rightEnd - leftStart) + 1;
		 
		 int right = rightStart;
		 int left = leftStart;
		 int index = leftStart;
		 
		 while (left <= leftEnd && right <= rightEnd) {
			 if (array[left] <= array[right]) {
				 temp[index] = array[left];
				 left++;
			 } else {
				 temp[index] = array[right];
				 right++;
			 }
			 index++;
		 }
		 
		 System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		 System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		 System.arraycopy(temp, leftStart, array, leftStart, size);
		 
 	 }
	
	 
	
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[index])
					index = j;
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int index = i - 1;

			while (array[index] > array[index + 1] && index > 0) {
				int temp = array[index];
				array[index] = array[index + 1];
				array[index + 1] = temp;
				index--;
			}
		}
	}
	
	public static void insertionSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int temp = array[i];
			
			while (array[j] > temp && j >= 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}

}
