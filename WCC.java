import java.util.*;

public class WCC {

    public static void main(String[] args) {

        // 1) Median of Two Sorted Arrays
        int[] nums1 = {1, 2, 4, 6, 8};
        int[] nums2 = {-9, 2, 3, 5, 7, 8,9};

        List<Integer> integers = new ArrayList<>();

        int j = 0;
        int k = 0;

        for (int i = 0; i < nums1.length + nums2.length - 1; i++) {
            if (nums1[k] >= nums2[j])
                integers.add(nums2[j++]);
            else {
                integers.add(nums1[k++]);
            }
        }
        System.out.println("1) Median of Two Sorted Arrays");
        if(integers.size() % 2 == 0){
            System.out.println((integers.get(integers.size() / 2)
                    + integers.get((integers.size() / 2) -1))/2f);
        }
        else{
            System.out.println(integers.get(integers.size() / 2));
        }


        //2) Merge k Sorted Lists
        List<Integer>[] lists = initialize();

        List<Integer> sorted = mergeLinkedLists(lists);

            //Display merged linked list
        StringBuilder s = new StringBuilder("");
        for (int i : sorted) {
            s.append(i);
            s.append(", ");
        }
        System.out.println("\n2) Merge k Sorted Lists");
        System.out.println(s.substring(0, s.length() - 2));
    }

    public static List<Integer>[] initialize(){
        int k = 3;
        List<Integer>[] list = new LinkedList[k];
        for (int i = 0; i < k; i++) {
            list[i] = new LinkedList<>();
        }
        list[0].addAll(List.of(1, 4, 5, 11, 55));
        list[1].addAll(List.of(1, 3, 4, 22));
        list[2].addAll(List.of(2, 6, 9, 10));

        return list;
    }

    public static List mergeLinkedLists(List<Integer>[] list){
        List<Integer> sorted = new LinkedList<>();
        sorted.addAll(list[0]);
        for (int i = 1; i < list.length; i++) {
            for ( int j = 0; j < list[i].size(); j++) {
                for (int k = 0; k < sorted.size(); k++) {
                    if (list[i].get(j) < sorted.get(k)) {
                        sorted.add(k, list[i].get(j));
                        break;
                    } else if (k + 1 == sorted.size()) {
                        sorted.add(k + 1, list[i].get(j));
                        break;
                    }
                }
            }
        }
        return sorted;
    }
}
