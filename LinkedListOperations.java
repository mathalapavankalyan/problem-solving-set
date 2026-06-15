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
	
	// palindrome list
	 public static  boolean isPalindrome(ListNode head) {
	        if(head == null || head.next == null){
	            return true;
	        }

	        ListNode prev = null;
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast!= null && fast.next!=null){
	            fast = fast.next.next;
	            ListNode nextptr = slow.next;
	            slow.next = prev;
	            prev = slow;
	            slow  = nextptr;
	        }
	        if(fast!=null) {
	        	slow = slow.next;
	        }
	        while(prev!=null){
	            if(slow.val != prev.val){
	                return false;
	            }
	            prev = prev.next;
	            slow = slow.next;
	        }

	        return true;
	    }
	 
	 
	 // https://leetcode.com/problems/odd-even-linked-list/
	 
//	 public static ListNode oddEvenList(ListNode head) {
//
//	        if(head == null || head.next == null){
//	            return head;
//	        }
//            ListNode temp = head;
//	        ListNode oddList = temp.next;
//	        ListNode oddDummy = oddList;
//	        ListNode evenList = temp;
//	        ListNode evenDummy = evenList;
//	        temp = temp.next.next;
//	        int index = 2;
//	        while(temp!=null){
//	           if(index%2==0) {
//	        	   evenList.next = new ListNode(temp.val);
//	        	   evenList = evenList.next;
//	           }
//	           else {
//	        	   oddList.next = new ListNode(temp.val);
//	        	   oddList = oddList.next;
//	           }
//	           index++;
//	           temp = temp.next;
//	           
//	        }
//	        oddList.next = null;
//	        while(oddDummy!=null){
//	        	
//	            evenList.next = oddDummy;
//	            evenList = evenList.next;
//	            oddDummy = oddDummy.next;
//	        }
//	       
//	        return evenDummy;
//	    }
	 
	 public static ListNode oddEvenList(ListNode head) {
		    if (head == null || head.next == null) {
		        return head;
		    }

		    ListNode odd = head;
		    ListNode even = head.next;
		    ListNode evenHead = even;

		    while (even != null && even.next != null) {
		        odd.next = even.next;
		        odd = odd.next;

		        even.next = odd.next;
		        even = even.next;
		    }

		    odd.next = evenHead;

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

    
//    public static ListNode reverseLinkedList(ListNode head) {
//    	if(head == null) {
//    		return null;
//    	}
//    	
//    	ListNode temp = head;
//    	ListNode prev = null;
//    	while(temp !=null) {
//    		ListNode next = temp.next;
//    		temp.next = prev;
//    		prev = temp;
//    		temp = next;
//    		
//    	}
//    	
//    	return prev;
//    	
//    }
//    public static ListNode reverseLinkedList(ListNode head) {
//    	if(head == null) {
//    		return null;
//    	}
//    	ListNode prev= null;
//    	return getReversedLinkedList(head , prev );
//    	
//    }
//    
//    
//    
//    private static ListNode getReversedLinkedList(ListNode head, ListNode prev) {
//    	if(head ==null) {
//    		return prev;
//    	}
//    	
//    	ListNode next = head.next;
//    	head.next = prev;
//    	prev = head;
//    	head = next;
//    		
//    	
//    	return getReversedLinkedList(head, prev);
//	
//}
    
    
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
	// ================= MAIN =================

    public static void main(String[] args) {

        ListNode head = null;

        // Insert
        head = insertAtStart(head, 2);
        head = insertAtEnd(head, 1);
//        head = insertAtEnd(head, 3);
//        head = insertAtEnd(head, 5);
//        head = insertAtEnd(head, 6);
//        head = insertAtEnd(head, 4);
//        head = insertAtEnd(head, 7);
        //2,1,3,5,6,4,7
//        head = insertAtPosition(head, 25, 2);

//        printList(head); // 10 -> 20 -> 25 -> 30 -> null

        // Update
//        updateAtStart(head, 100);
//        updateAtEnd(head, 300);
//        updateAtPosition(head, 1, 200);

//        printList(head); // 100 -> 200 -> 25 -> 300 -> null
//        deleteMiddle(head);
//        printList(head);
//        head = reverseList(head);
//        printList(head);
        head = oddEvenList(head);
        printList(head);
        // Delete
//        head = deleteAtStart(head);
//        head = deleteAtEnd(head);
//        head = deleteAtPosition(head, 1);

//        printList(head); // 200 -> null
    }
}