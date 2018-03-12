package leetcode;

/**
 * Created by lujxu on 2018/3/12.
 * description: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * link: https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    //63ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num=(l1.val+l2.val)%10;
        int step=(l1.val+l2.val)/10;
        ListNode root=new ListNode(num);
        ListNode l=root;
        while(l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            int sum=step+l1.val+l2.val;
            step=sum/10;
            l.next=new ListNode(sum%10);
            l=l.next;
        }
        while(l1.next!=null){
            l1=l1.next;
            int sum=step+l1.val;
            step=sum/10;
            l.next=new ListNode(sum%10);
            l=l.next;
        }
        while(l2.next!=null){
            l2=l2.next;
            int sum=step+l2.val;
            step=sum/10;
            l.next=new ListNode(sum%10);
            l=l.next;
        }
        if(step!=0){
            l.next=new ListNode(step);
        }
        return root;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0);
        ListNode l=root;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int sum=((l1==null)?0:l1.val)+((l2==null)?0:l2.val)+carry;
            carry=sum/10;
            l.next=new ListNode(sum%10);
            l=l.next;
            l1=(l1==null)?l1:l1.next;
            l2=(l2==null)?l2:l2.next;
        }
        return root.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}