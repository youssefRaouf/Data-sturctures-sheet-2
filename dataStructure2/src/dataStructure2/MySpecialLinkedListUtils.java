package dataStructure2;

public class MySpecialLinkedListUtils {

	public static Node median(Node head) {
		if (head == null) {
			return null;
		}
		Node temp1 = head;
		Node temp2 = head.next;
		while (temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		return temp1;
	}

	public static double[] summary(Node head) {
		double[] summary = new double[5];
		double size = 0;
		Node temp = head;
		if (head == null) {
			return summary;
		}
		summary[3] = head.value;
		summary[4] = head.value;
		while (temp != null) {
			size++;
			summary[0] += temp.value;
			summary[1]++;
			if (temp.value > summary[3]) {
				summary[3] = temp.value;
			}
			if (temp.value < summary[4]) {
				summary[4] = temp.value;
			}
			temp = temp.next;
		}
		summary[1] = summary[0] / size;
		summary[2] = median(head).value;
		return summary;

	}

	public static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}

	public static Node evenIndexedElements(Node head) {
		if (head == null) {
			return null;
		}
		Node head2 = new Node(head.value);
		Node temp2 = head2;
		Node temp1 = head;
		int i = 0;
		while (temp1 != null) {
			if (i % 2 == 0 && temp1 != head) {
				temp2.next = new Node(temp1.value);
				temp2 = temp2.next;
			}
			i++;
			temp1 = temp1.next;
		}
		return head2;
	}

	public static Node insertionsort(Node head) {
		Node sorted = new Node(0);
		Node current = head;
		while (current != null) {
			Node j = sorted;
			Node current2 = new Node(current.value);
			while (j.next != null && j.next.value < current.value) {
				j = j.next;
			}
			current2.next = j.next;
			j.next = current2;
			current = current.next;
		}
		return sorted.next;
	}

	public static Node mergesort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = median(head);
		Node secondhalf = mid.next;
		mid.next = null;
		return merge(mergesort(head), mergesort(secondhalf));
	}

	public static Node merge(Node a, Node b) {
		Node temp = new Node(-1);
		Node f = temp;
		while (a != null && b != null) {
			if (a.value < b.value) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return f.next;
	}

	public static Node removeCentralNode(Node head) {
		Node central = median(head);
		Node current = head;
		while (current != null) {
			if (current.next == central) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
		return head;
	}

	public static boolean palindrome(Node head) {
		Node secondhalf = reverse(median(head).next);
		Node firsthalf = head;
		while (secondhalf != null) {
			if (firsthalf.value != secondhalf.value) {

				return false;
			}
			firsthalf = firsthalf.next;
			secondhalf = secondhalf.next;
		}

		return true;
	}

}