class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode f1 = head;
        for (int i = 1; i < k; i++) {
            f1 = f1.next;
        }

        ListNode f2 = head;
        for (int i = 1; i < count - k + 1; i++) {
            f2 = f2.next;
        }

        int val = f1.val;
        f1.val = f2.val;
        f2.val = val;

        return head;
    }
}