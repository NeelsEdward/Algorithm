package algorithm;

public class CountingSort {

	public static void main(String[] args) {
		int A[] ={5,2,9,5,2,3,5};
		counting_sort(A);
	}
	
	static void counting_sort(int A[]) {

	    // First, find the maximum value in A[]
	    int K = 0;
	    int N = A.length;
	    int sortedA[] = new int[N];
	    
	    for(int i=0; i<N; i++) {
	        K = Math.max(K, A[i]);
	    }

	    int Aux[] = new int[K+1];
	 
	    // Store the frequencies of each distinct element of A[],
	    // by mapping its value as the index of Aux[] array
	    for(int i=0; i<N; i++) {
	        Aux[A[i]]++;
	    }

	    int j = 0;
	    for(int i=0; i<=K; i++) {
	        int tmp = Aux[i];
	        // Aux stores which element occurs how many times,
	        // Add i in sortedA[] according to the number of times i occured in A[]
	        while(tmp-- >0) {
	            //cout << Aux[i] << endl;
	            sortedA[j] = i;
	            j++;
	        }
	    }
	    for(int i=0; i<sortedA.length; i++) {
	        System.out.print(sortedA[i]+" ");
	    }
	}
}
