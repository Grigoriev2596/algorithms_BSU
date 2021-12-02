import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	
	public static int x;

	public static int N = 100;
	
	public static int M = 100;
	
	public static int binarySearchComparsionCounter = 0;
	public static int interpolationCounter = 0;

	
	public static void main(String[] args) {
//		int[] binarySearchArray = new int[N];
//		fillArray(binarySearchArray, M);
//		Arrays.sort(binarySearchArray);
//		x = 50;
//		System.out.println(Arrays.toString(binarySearchArray));
//		System.out.println("element index: " + binarySearch(binarySearchArray, x, 0, binarySearchArray.length - 1));
//		System.out.println("amount of comparsions: " + binarySearchComparsionCounter);
//
//		System.out.println("===================================");
//
//		int[] interpolationArray = new int[N];
//		fillArray(interpolationArray, M);
//		Arrays.sort(interpolationArray);
//		System.out.println(Arrays.toString(interpolationArray));
//		System.out.println("element index: " + interpolationSearch(interpolationArray, x));
//		System.out.println("amount of comparsions: " + interpolationCounter);

		
		
		int[] BSTArray = {  15, 12, 20, 10, 13, 9 ,11};
		BST bst = new BST();
		bst.buildTree(BSTArray);

		System.out.print("In order traversal: ");
		System.out.println(bst.getInorder().toString());
		System.out.println();
		System.out.print("Reverse in order traversal: ");
		System.out.println(bst.getReverseInorder().toString());

		bst.root = bst.getBalancedRoot(bst.root, bst.n / 2);

		System.out.print("In order traversal: ");
		System.out.println(bst.getInorder().toString());
	}

	public static int interpolationSearch(int[] data, int item) {

		int highEnd = (data.length - 1);
		int lowEnd = 0;

		while (item >= data[lowEnd] && item <= data[highEnd] && lowEnd <= highEnd) {
			interpolationCounter++;
			int probe
					= lowEnd + (highEnd - lowEnd) * (item - data[lowEnd]) / (data[highEnd] - data[lowEnd]);

			if (highEnd == lowEnd) {
				interpolationCounter++;
				if (data[lowEnd] == item) {
					interpolationCounter++;
					return lowEnd;
				} else {
					return -1;
				}
			}

			if (data[probe] == item) {
				interpolationCounter++;
				return probe;
			}

			if (data[probe] < item) {
				interpolationCounter++;
				lowEnd = probe + 1;
			} else {
				highEnd = probe - 1;
			}
		}
		return -1;
	}

	
	public static int binarySearch(int[] sortedArray, int key, int low, int high) {
	    int index = -1;

	    while (low <= high) {
	    	binarySearchComparsionCounter++;
	        int mid = (low + high) / 2;
	        binarySearchComparsionCounter++;
	        if (sortedArray[mid] < key) {
	            low = mid + 1;
	        } else if (sortedArray[mid] > key) {
	            high = mid - 1;
	        } else if (sortedArray[mid] == key) {
	            index = mid;
	            break;
	        }
	    }
	    return index;
	}
	
	
	public static void fillArray(int[] arr, int m) {
		Random random = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(m);
		}
	}


}