package patterns.LL;

import utilites.ListNode;

public class MergeLL {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // Start merging
        ListNode merged = null;
        ListNode current = null;

        if(list1.val < list2.val){
            merged = list1;
            list1 = list1.next;
        }else{
            merged = list2;
            list2 = list2.next;
        }
        current = merged;
        while(list1!= null && list2!= null){

            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1!= null)
            current.next = list1;
        if(list2!= null)
            current.next = list2;
        return merged;
    }

}
