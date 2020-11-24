package org.cloud.mvn.zstudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiuTao @Date 2020年9月21日 下午5:12:35
 * @ClassName: Medium 
 * @Description: 中等难度
 */
public class Medium {
	public static void main(String[] args) {
		String[] strs = new String[7];
		strs[0] = "eat";
		strs[1] = "tea";
		strs[2] = "tan";
		strs[3] = "ate";
		strs[4] = "nat";
		strs[5] = "bat";
		strs[6] = "batx";
		List<List<String>> list = groupAnagrams(strs);
		System.out.println(list);
	}

	public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
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
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) 
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
class ListNode {
	public ListNode next;
	public int val;
	public ListNode(int i){
		this.val = i;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
} 
