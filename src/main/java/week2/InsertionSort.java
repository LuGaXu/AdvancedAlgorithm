package week2;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * Created by lujxu on 2017/12/20.
 */
public class InsertionSort
{
    public static void main(String [] args){
        InsertionSort sort=new InsertionSort();
        LinkList l=new LinkList(2);
        int [] a=new int[]{3,1,5,2,7,4};
        for (int i=0;i<a.length;i++){
            l.add(a[i]);
        }
        LinkList linkList=sort.insertSort(l);
        linkList.print();
    }

    public LinkList insertSort(LinkList list){
        LinkList newList=new LinkList(list.head.data);
        ListNode current=list.head.next;
        while (current!=null){
            ListNode pivot=newList.head;
            ListNode pre=null;
            while (pivot!=null&&pivot.data<=current.data){
                    pre=pivot;
                    pivot=pivot.next;
            }

            if (pivot==null){
                newList.add(current);
            }else{
                ListNode node=new ListNode(current.data);
                //表头
                if (pre==null){
                    node.next=newList.head;
                    newList.head=node;
                }else {
                    node.next= pre.next;
                    pre.next=node;
                }
            }
            current=current.next;
        }
        return newList;
    }
}

class LinkList{
    ListNode head;
    ListNode current;

    public LinkList(int a){
        head=new ListNode(a);
        current=head;
    }


    public void add(int a){
        ListNode node=new ListNode(a);
        current.next=node;
        current=node;
    }

    public void add(ListNode node){
        current.next=new ListNode(node.data);
        current=current.next;
    }

    public void print(){
        ListNode node=head;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }

    }
}

class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data=data;
        next=null;
    }
}
