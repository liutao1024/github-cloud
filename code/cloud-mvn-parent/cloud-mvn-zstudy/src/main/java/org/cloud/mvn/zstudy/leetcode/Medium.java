package org.cloud.mvn.zstudy.leetcode;

import javax.management.ListenerNotFoundException;

/**
 * @Author LiuTao @Date 2020年9月21日 下午5:12:35
 * @ClassName: Medium 
 * @Description: 中等难度
 */
public class Medium {

	public static void addTwoNumber() {
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
}
class ListNode {
	private int[] l;
	public ListNode(int i){
		l = new int[i];
	}
	public ListNode(int[] l){
		this.l = l;
	}
} 
