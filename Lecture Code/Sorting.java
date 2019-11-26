package classses;

import java.util.Arrays;


/**
 * Author: Eric Altenburg
 * Date: 11/5/18
 **/
public class Sorting {
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selection(int[] a) {
        int posMin;
        for (int fill = 0; fill <= a.length-2; fill ++) {
            posMin = fill;
            for (int i = fill; i <= a.length-1; i ++) {
                if ( a[i] < a[posMin]) {
                    posMin = i;
                }
            }
            swap(a, fill, posMin);
        }
    }

    public static void bubble(int[] a) {
        Boolean exchange = true;
        int end = a.length;
        while(exchange) {
            for (int i = 0; i < end; i ++) {
                //swap adjacent elements and change exchange if a swap has occurred
            }
        }
    }

    public static void insert(int[] a, int val, int index) {
        int current = index;
        while(current-1 >= 0 && a[current-1] > val) {
            a[current] = a[current-1];
            current--;
        }
        a[current] = val;
    }

    public static void insertion (int[] a) {
        for (int nextPos = 1; nextPos < a.length; nextPos ++) {
            int nextVal= a[nextPos];
            insert(a, nextVal, nextPos);
        }
    }

    private static int[] merge(int[] a, int[] b, int[] update) {
        int[] c = new int[a.length + b.length];
        int ia = 0;
        int ib = 0;
        int ic = 0;

        while(ia < a.length && ib < b.length) {
            if (a[ia] < b[ib]) {
                c[ic] = a[ia];
                ia++;
            } else {
                c[ic] = b[ib];
                ib++;
            }
            ic++;
        }

        while(ia<a.length){
            c[ic] = a[ia];
            ic++;
            ia++;
        }

        while(ib<b.length) {
            c[ic] = b[ib];
            ic++;
            ib++;
        }

        return c;

    }

    public static void mergeSort(int[] a) {
        int size = a.length/2;
        int[] left;
        int[] right;

        if (a.length <= 1) {
            return;
        }

        left = Arrays.copyOfRange(a, 0, size);
        right = Arrays.copyOfRange(a, size+1, a.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, a);
    }

    private static void buildHeap(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int current = a.length-1;
            int parent = (current-1)/2;
            while(parent>=0 && a[current]> a[parent]) {
                swap(a, current, parent);
                current = parent;
                parent = (current-1)/2;
            }
        }
    }

    private static void desconstructHeap(int[] a) {

        int temp = a[0];
        a[0] = a[a.length-1];
        a[a.length-1] = temp;

        int parent = 0;
        int leftChild;
        int rightChild;
        int maxChild;

        while (true) {
            leftChild = (parent*2)+1;
            rightChild = leftChild+1;
            //determine minimum
            if (leftChild > a.length-1) { //reached a leaf
                break;
            }
            maxChild = leftChild;

            if (rightChild < a.length && a[rightChild] > a[leftChild]) {
                maxChild = rightChild;
            }

            //Now minChild points to the smallest of the children
            if (a[parent] > a[maxChild]) {
                break;
            }

            swap(a, parent, maxChild);
            parent = maxChild;
        }
    }

    public static void heapSort(int[] a) {
        buildHeap(a);
        desconstructHeap(a);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = left;
        int up = left;
        int down = right;

        do {
            while (a[up] <= a[pivot] && up < right) {
                up++;
            }
            while (a[down] > a[pivot]) {
                down--;
            }
            if (up < down) {
                swap(a, up, down);
            }
        } while (up < down);

        swap(a, down, pivot);
        return down;
    }

    private static void qsHelper(int[] a , int left, int right) {
        if (left < right) {
            int pivot_index = partition(a, left, right);
            qsHelper(a, left, pivot_index-1);
            qsHelper(a, pivot_index-1, right);
        }
    }

    public static void qs(int[] a) {
        qsHelper(a, 0, a.length-1);
    }

    public static void main(String[] args) {
//        int[] a = {35, 65, 30, 60, 20};
//        int[] b = {12, 40, 37, 50, 80};
//        int[] c = {54, 26, 93, 17, 77, 31, 44, 55, 20};
//
////        System.out.println(Arrays.toString(a));
////        selection(a);
////        insertion(a);
////        System.out.println(Arrays.toString(merge(a,b)));
////        mergeSort(a);
////        System.out.println(Arrays.toString(a));
//
////        int i = partition(c, 0, c.length-1);
//        qs(c);
//        System.out.println(Arrays.toString(c));
    }
}
