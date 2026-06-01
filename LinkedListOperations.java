package recursioncodes.linkedlist.problems;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListOperations {

    // ================= INSERT =================
	
//	 public static ListNode deleteMiddle(ListNode head) {
//	        if(head == null){
//	            return null;
//	        }
//	        ListNode slow = head;
//	        ListNode fast = head;
//	        while(fast!=null && fast.next!=null) {
//	        	slow = slow.next;
//	        	fast = fast.next.next;	   
//	        }
//	        
//	        ListNode prev = head;
//	        while(prev.next!=slow) {
//	        	prev= prev.next;
//	        }
//	        prev.next = slow.next;
//	        prev = prev.next;
//	        return head;
//	    }

	public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
    public static ListNode insertAtStart(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        return newNode;
    }

    public static ListNode insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static ListNode insertAtPosition(ListNode head, int data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        if (position == 0) {
            return insertAtStart(head, data);
        }

        ListNode temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                throw new IllegalArgumentException("Position Out Of Bounds");
            }
            temp = temp.next;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // ================= DELETE =================

    public static ListNode deleteAtStart(ListNode head) {
        if (head == null) {
            return null;
        }

        return head.next;
    }

    public static ListNode deleteAtEnd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static ListNode deleteAtPosition(ListNode head, int position) {
        if (head == null) {
            return null;
        }

        if (position < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        if (position == 0) {
            return head.next;
        }

        ListNode temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                throw new IllegalArgumentException("Position Out Of Bounds");
            }
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

    // ================= UPDATE =================

    public static void updateAtStart(ListNode head, int newValue) {
        if (head != null) {
            head.val = newValue;
        }
    }

    public static void updateAtEnd(ListNode head, int newValue) {
        if (head == null) {
            return;
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.val = newValue;
    }

    public static void updateAtPosition(ListNode head, int position, int newValue) {
        if (position < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        ListNode temp = head;

        for (int i = 0; i < position; i++) {
            if (temp == null) {
                throw new IllegalArgumentException("Position Out Of Bounds");
            }
            temp = temp.next;
        }

        if (temp == null) {
            throw new IllegalArgumentException("Position Out Of Bounds");
        }

        temp.val = newValue;
    }

    // ================= PRINT =================

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        ListNode head = null;

        // Insert
        head = insertAtStart(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtPosition(head, 25, 2);

//        printList(head); // 10 -> 20 -> 25 -> 30 -> null

        // Update
        updateAtStart(head, 100);
        updateAtEnd(head, 300);
        updateAtPosition(head, 1, 200);

        printList(head); // 100 -> 200 -> 25 -> 300 -> null
        deleteMiddle(head);
        printList(head);

        // Delete
        head = deleteAtStart(head);
        head = deleteAtEnd(head);
        head = deleteAtPosition(head, 1);

//        printList(head); // 200 -> null
    }
}