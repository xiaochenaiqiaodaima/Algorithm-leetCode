package 两数相加;

import ListNode.ListNode;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/9 17:30
 **/
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public static ListNode add(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(2,l2);

        ListNode s3 = new ListNode(4);
        ListNode s2 = new ListNode(6,s3);
        ListNode s1 = new ListNode(5,s2);

        ListNode listNode = add(l1, s1);
        System.out.println(listNode.toString());

    }
}
