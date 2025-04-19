class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move to the node just before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist from left to right
        ListNode curr = prev.next;
        ListNode reversePrev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = reversePrev;
            reversePrev = curr;
            curr = next;
        }

        // Step 3: Reconnect
        prev.next.next = curr;      // tail of reversed part → right + 1 node
        prev.next = reversePrev;    // prev → head of reversed part

        return dummy.next;
    }
}
