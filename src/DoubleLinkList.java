import java.util.Scanner;

class ListNode{
    public int info ;
    public ListNode FORW , BACK;
    public ListNode(int info){
        this.info = info;
        this.FORW = null;
        this.BACK = null;
    }
    public int getInfo(){
        return this.info;
    }
}
public class DoubleLinkList {
    public static Scanner scan  = new Scanner(System.in);
    public static ListNode FIRST = null;
    public static ListNode LAST = null;
    public static ListNode PTR = null;
    public static int ELEMENT = 0;
    public static ListNode LOC = null, LOCP  = null;
    public static void main(String[] args){
        boolean flag = true;
        int choice ;
        while(flag){
            System.out.println("AVAILABLE CHOICES");
            System.out.println("1 : INSERT NODE");
            System.out.println("2 : INSERT AT FIRST POSITION");
            System.out.println("3 : INSERT AT END");
            System.out.println("4 : INSERT NODE AT PARTICULAR POSITION");
            System.out.println("5 : DELETE THE FIRST NODE");
            System.out.println("6 : DELETE THE END NODE");
            System.out.println("7 : DELETE A NODE AT A PARTICULAR POSITION");
            System.out.println("8 : FIND A NODE");
            System.out.println("9 : TRAVERSE THE LINK LIST");
            System.out.println("10 : EXIT");


            choice = scan.nextInt();

            switch(choice){
                case 1 : insertNode();
                    break;
                case 2 : insertFirst();
                    break;
                case 3:  insertEnd();
                    break;
                case 4:  insertPos();
                    break;
                case 5:  deleteFirst();
                    break;
                case 6 : deleteEnd();
                    break;
                case 7: //deleteNode();
                    break;
                case 8:// findNode();
                    break;
                case 9: readList();
                    break;
                case 10:
                    System.out.println("END OF SINGLE LINK LIST");
                    flag = false;
                    break;
                default :
                    System.out.println("WRONG CHOICE");
            }
        }
    }

    //INSERTING NODE TO DOUBLE LINK LIST
    public static void insertNode(){
        if(FIRST == null){
            System.out.print("\nENTER THE ELEMENT : ");
            ELEMENT = scan.nextInt();
            ListNode newNode = new ListNode(ELEMENT);
            FIRST = newNode;
            LAST = newNode;
            newNode.BACK = null;
        }else{
            System.out.print("\nENTER THE ELEMENT : ");
            ELEMENT = scan.nextInt();
            ListNode newNode = new ListNode(ELEMENT);
            LAST.FORW = newNode;
            newNode.BACK = LAST;
            LAST = newNode;
        }
    }


    //INSERT NEW NODE AT THE FIRST POSITION OF THE DOUBLE LINK LIST
    public static void insertFirst(){
        System.out.print("\nENTER THE ELEMENT : ");
        ELEMENT = scan.nextInt();
        ListNode newNode = new ListNode(ELEMENT);
        FIRST.BACK = newNode;
        newNode.FORW = FIRST;
        FIRST = newNode;
    }

    //INSERT ELEMENT AT THE END OF THE DOUBLE LINK LIST
    public static void insertEnd(){
        System.out.print("\nENTER THE ELEMENT : ");
        ELEMENT = scan.nextInt();
        ListNode newNode = new ListNode(ELEMENT);
        LAST.FORW = newNode;
        newNode.BACK = LAST;
        LAST = newNode;
    }

    //INSERT A NODE AT A PARTICULAR POSITION IN THE GIVEN DOUBLE LINK LIST
    public static void insertPos(){
        int pos , i = 1;
        System.out.println("ENTER THE POSITION TO INSERT THE ELEMENT");
        pos = scan.nextInt();
        PTR = FIRST;

        while(PTR!= null && i<pos){
            PTR = PTR.FORW;
            ++i;
        }
        if(PTR == null){
            System.out.println("POSITION NOT FOUND");
        }else{
            System.out.print("\nENTER THE ELEMENT : ");
            ELEMENT = scan.nextInt();
            ListNode newNode = new ListNode(ELEMENT);

            newNode.BACK = PTR ;
            newNode.FORW = PTR.FORW;
            (PTR.FORW).BACK = newNode;
            PTR.FORW = newNode;
        }
    }

    //DELETE THE FIRST NODE FROM THE DOUBLE LINK LIST
    public static void deleteFirst(){
        FIRST = FIRST.FORW;
    }

    //DELETE THE NODE FROM THE END OF THE DOUBLE LINK LIST
    public static void deleteEnd(){
        (LAST.BACK).FORW = null;
        LAST = LAST.BACK;
    }

    //READING NODE OF DOUBLE LINK LIST
    public static void readList(){
        PTR = FIRST;
        while(PTR!=null){
            System.out.print(PTR.getInfo() + " \t");
            PTR = PTR.FORW;
        }
        System.out.println("\n");
    }


}
