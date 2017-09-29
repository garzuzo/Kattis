	import java.io.*;
	import java.util.*;
	
	public class froshWeek {

//For UVA Solution: while(hasNext())

	    static long[] array;
	    static long[] tempMergArr;
	    static int length;
	    
	 static long contador;
	 
	    public static void main(String a[]) throws Exception{
	       
	
	       BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter esc=new BufferedWriter(new OutputStreamWriter(System.out));
	     
	    	   contador=0;
	       int n=Integer.parseInt(lector.readLine());
	       array=new long[n];
	       for(int i=0;i<n;i++){
	           
	           array[i]=Long.parseLong(lector.readLine());
	           
	       
	       }
	       
	    sort(array);
	    
	    esc.write(contador+"\n");
	       esc.flush();
	    }
	     
	    static void sort(long inputArr[]) {
	        array = inputArr;
	       length = inputArr.length;
	        tempMergArr = new long[length];
	        doMergeSort(0, length - 1);
	    
	    }

	   static void doMergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	        	int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    static void mergeParts(int lowerIndex, int middle, int higherIndex) {
	 int tot=0;
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	            tot++;
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        int cont=0;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	            
	                array[k] = tempMergArr[i];
	               // contador++;
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                int act=j-k;
	                j++;
	              
	                contador+=act;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	          //  contador++;
	            k++;
	            i++;
	        }
	
	    }
	}
