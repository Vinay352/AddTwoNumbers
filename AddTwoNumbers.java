package Leetcode.Medium;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        int carry=0;

        ListNode temp1=list1, temp2=list2;

        ListNode finalList = new ListNode();
        ListNode tempFinal = finalList;

        int total;
        while( temp1 != null && temp2 != null){
            total = temp1.val + temp2.val + carry;
            tempFinal.val = total % 10;
            carry = total / 10;

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 != null && temp2 != null){
                tempFinal.next = new ListNode();
                tempFinal = tempFinal.next;
            }
            else{
                tempFinal.next = null;
            }
        }

        while( temp1 != null ){
            tempFinal.next = new ListNode();
            tempFinal = tempFinal.next;

            total = temp1.val + carry;
            tempFinal.val = total % 10;
            carry = total / 10;

            temp1 = temp1.next;

//            if(temp1 != null){
//                tempFinal.next = new Leetcode.Medium.ListNode();
//                tempFinal = tempFinal.next;
//            }
        }

        while( temp2 != null ){
            tempFinal.next = new ListNode();
            tempFinal = tempFinal.next;

            total = temp2.val + carry;
            tempFinal.val = total % 10;
            carry = total / 10;

            temp2 = temp2.next;

//            if(temp2 != null){
//                tempFinal.next = new Leetcode.Medium.ListNode();
//                tempFinal = tempFinal.next;
//            }
        }

        if( carry != 0 ){
            tempFinal.next = new ListNode();

            tempFinal = tempFinal.next;

            tempFinal.val = carry;
            tempFinal.next = null;
        }
        else{
            tempFinal.next = null;
        }

        return finalList;
    }

    public static void main(String[] args) {
        ListNode node1 = createListNode(9999999);
        ListNode node2 = createListNode(9999);

        // printListNode(node1);

        // System.out.println(346+747);

        ListNode addList = addTwoNumbers(node1, node2);
        printListNode(addList);
    }

    private static void printListNode(ListNode node1) {

        ListNode temp = node1;

        String output = "[";

        while(temp != null){
//            if(temp.next == null){
//                if(temp.val != 0){
//                    output = output + temp.val + ",";
//                }
//            }
//            else{
//                output = output + temp.val + ",";
//            }

            output = output + temp.val + ",";

            // System.out.println( temp.val );

            temp = temp.next;
        }

        // int last = output.length();

        for(int i = 0; i < output.length() - 1; i++){
            System.out.print(output.charAt(i));
        }
        System.out.println("]");
    }

    private static ListNode createListNode(int num) {

        ListNode list1 = new ListNode();
        ListNode temp = list1;

        String numString = Integer.toString(num);

        for(int i = 0 ; i < numString.length() ; i++){
            if(i == 0){
                list1.val = num % 10;
                list1.next = null;
                num /= 10;
            }
            else{
                temp.next = new ListNode();
                temp.next.val = num % 10;
                num/=10;
                temp.next.next = null;
                temp = temp.next;
            }
        }

        return list1;
    }
}
