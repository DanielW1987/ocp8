package chapter3.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class NavigableSetTest {

    public static void main(String... args){

        TreeSet<Integer> nums = new TreeSet<>();

        nums.add(1);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(7);

        // headSet: view from the beginning to toElement
        SortedSet<Integer> headSet = nums.headSet(3); // 3 is exclusive
        System.out.println(headSet);
        headSet.add(2);
        System.out.println(headSet);
        // headSet.add(6); // IllegalArgumentException: key out of range

        // subSet
        SortedSet<Integer> subSet = nums.subSet(1, true, 3, true);
        System.out.println(subSet); // contains 2, because it was added to headSet and headSet is backed by nums

    }
}
