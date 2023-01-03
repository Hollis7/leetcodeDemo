import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ListNodeAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新表伪指针
        ListNode pre = new ListNode(0);
        //进位指针
        int carry = 0;
        //指向存储和的位置
        ListNode cur = pre;
        int x, y, sum;
        while (l1 != null || l2 != null) {
            if (l1 != null) x = l1.val;
            else x = 0;
            if (l2 != null) y = l2.val;
            else y = 0;
            sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            //cur向后移一位
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        //考虑最后有进位,只可能是1
        if(carry!=0)cur.next=new ListNode(carry);
        //返回头节点
        return pre.next;
    }
}
