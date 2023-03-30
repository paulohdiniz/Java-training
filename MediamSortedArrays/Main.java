package MediamSortedArrays;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    
	public static void main(String[] args){

        //1,2,3,4,9,10,99,101,102,999 i
        //4,5,6, 9, 11, 100 j
        int array1[] = { 1, 2, 3, 10, 99999999};
        int array2[] = { 3,4,99 };
        System.out.println(somme(array1, array2));
        System.out.println(mediam(somme(array1,array2)));
	}
    private static HashSet <Integer> somme(int[] nums1, int[] nums2) {
        HashSet <Integer> completList = new LinkedHashSet<Integer>();
        HashSet <Integer> list1 = convert(nums1);
        HashSet <Integer> list1Copy = convert(nums1);
        HashSet <Integer> list2 = convert(nums2);

        for (Integer element2 : list2) {
            for (Integer element1 : list1) {
                if (element2 >= element1){
                    completList.add(element1);
                    list1Copy.remove(element1);
                }
            }
            completList.add(element2);
        }
        if (!list1Copy.isEmpty()){
            for (Integer element : list1Copy) {
                completList.add(element);
            }
        }
        return completList;
    }
    
    private static double mediam(HashSet <Integer>list){
        int ratioInt = list.size()/2;
        int currentIndex = 0;
        int desiredIndex1 = ratioInt-1;
        int desiredIndex2 = ratioInt;
        int value1 = 0;
        int value2 = 0;

        for (Integer element : list) {
            if (currentIndex == desiredIndex1) {
                value1 = element;
            }
            if (currentIndex == desiredIndex2) {
                value2 = element;
            }
            currentIndex++;
        }

        if (list.size()%2 == 0){
            return (value1 + value2)/2.0;
        }else{
           return value2;
        }

    }
    static HashSet<Integer> convert(int[] array)
    {
        // Hash Set Initialisation
        HashSet<Integer> Set = new LinkedHashSet<>();
 
        // Iteration using enhanced for loop
        for (int element : array) {
            Set.add(element);
        }
        // returning the set
        return Set;
    }

}