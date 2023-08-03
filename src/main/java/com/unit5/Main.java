package com.unit5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNum(new int[] { 2, 1, 4, 3, 8, 5, 7, 6, 10 }, 10));

        BalancedBrackets balancedBrackets = new BalancedBrackets();
        System.out.println(balancedBrackets.isBalanced("({1})>"));

        LinkedList<Integer> l1 = new LinkedList<>(1);
        LinkedList<Integer> l2 = new LinkedList<>(5);
        LinkedList<Integer> head1 = l1;
        LinkedList<Integer> head2 = l2;

        for (int i = 2; i < 4; i++) {
            l1.next = new LinkedList<Integer>(i);
            l2.next = new LinkedList<Integer>(i + 4);

            l1 = l1.next;
            l2 = l2.next;
        }

        LinkedList<Integer> ll = getReversedTotal(head1, head2);

        while (ll != null) {
            System.out.println(ll.value);
            ll = ll.next;
        }

        String[] strs = new String[] { "Hello", "Bye", "Hey", "Car", "Computer" };

        System.out.println(getIndex(strs, "Car"));
        System.out.println(getIndex(strs, "Cars"));

        int[] nums = new int[] { 10, 2, 4, 6, 1, 3, 11, 15, 20, 18 };
        int[] output = mergeSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : output) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
 
    /***************************************************
     * Linked List
     ***************************************************/
    public static LinkedList<Integer> getReversedTotal(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> output = new LinkedList<>();

        LinkedList<Integer> l1Current = l1;
        LinkedList<Integer> l2Current = l2;

        output.value = l1Current.value + l2Current.value;

        l1Current = l1Current.next;
        l2Current = l2Current.next;

        while (l1Current != null && l2Current != null) {
            Integer value = l1Current.value + l2Current.value;

            LinkedList<Integer> newNode = new LinkedList<>(value);
            newNode.next = output;
            output = newNode;

            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }

        return output;

    }

    /***************************************************
     * Merge Sort
     ***************************************************/
    public static int[] mergeSort(int[] array) {

        if (array.length == 1)
            return array;

        int halfLen = array.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(array, 0, halfLen)),
                mergeSort(Arrays.copyOfRange(array, halfLen, array.length)));
    }

    public static int[] merge(int[] lArr, int[] rArr) {
        int[] arr = new int[lArr.length + rArr.length];

        int lIndex = 0;
        int rIndex = 0;
        int index = 0;

        while (lIndex < lArr.length && rIndex < rArr.length) {
            if (lArr[lIndex] < rArr[rIndex])
                arr[index++] = lArr[lIndex++];
            else
                arr[index++] = rArr[rIndex++];
        }

        while (lIndex < lArr.length) {
            arr[index++] = lArr[lIndex++];
        }

        while (rIndex < rArr.length) {
            arr[index++] = rArr[rIndex++];
        }

        return arr;
    }

    /***************************************************
     * Recursive Search
     ***************************************************/

    public static int getIndexRecursive(String[] strs, String search, int index) {

        if (index >= strs.length)
            return -1;

        if (strs[index].equals(search))
            return index;

        return getIndexRecursive(strs, search, ++index);
    }

    public static int getIndex(String[] strs, String search) {

        return getIndexRecursive(strs, search, 0);

    }
}