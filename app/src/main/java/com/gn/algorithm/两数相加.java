package com.gn.algorithm;

public class 两数相加 {
    /**
     *
     给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(6);


        // 赋值
//        int i = 1234567890;
//        int j = 1234567890;
//        String m = String.valueOf(i);
//        char[] s = m.toCharArray();
//        ListNode listNode = new ListNode(0);
//        ListNode listNode1 = listNode;
//        for (char node : s) {
//            int val = Integer.valueOf(node);
//            listNode1.next = new ListNode(val);
//            listNode1 = listNode1.next;
//        }



        toString(addTwoNumbersDigui(listNode1,listNode2));

    }

    public static ListNode addTwoNumbersDigui(ListNode l1, ListNode l2) {
        return addTwoNumbersDigui(l1, l2, 0);
    }


    public static ListNode addTwoNumbersDigui(ListNode l1, ListNode l2, int jinwei) {
        if (l1 == null && l2 == null && jinwei == 0) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int x = l1.val + l2.val + jinwei;
        ListNode node = new ListNode(x % 10);
        node.next = addTwoNumbersDigui(l1.next, l2.next, x/10);
        return node;

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode p = l1, q = l2, curr = node;
        int shi = 0;
        while (p != null || q != null) {

            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int result = shi + x + y;

            int ge = result % 10;
            shi = result / 10;

            curr.next = new ListNode(ge);

            if (p != null) {
                p = p.next == null ? null : p.next;
            }
            if (q != null) {
                q = q.next == null ? null : q.next;
            }

            curr = curr.next;

        }

        if (shi > 0) {
            curr.next = new ListNode(shi);
        }

        node = node.next;

        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void toString(ListNode node) {

        while (node != null) {
            System.out.println(node.val);
            node = node.next;

        }

    }


}
