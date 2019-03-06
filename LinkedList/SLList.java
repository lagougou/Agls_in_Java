// import org.graalvm.compiler.debug.Indent;

// public class SLList{
//     //nested class IntNode
//     public class IntNode{
//         public int item;
//         public IntNode next;
    
//         public IntNode(int i, IntNode n){
//             item = i;
//             next = n;
//         }
//     }

//     private IntNode first;
//     public SLList(int x){
//         first = new IntNode(x, null);
//     }

//     /* add first element into the List */
//     public void addFirst(int x){
//         first =  new IntNode(x, first);
//     }

//     /* add an element to the end of the List */ 
//     public void addLast(int x){
//         IntNode p = first;
//         while(p.next != null){
//             p = p.next;
//         }
//         p.next = new IntNode(x, null);
//     }

//     /* get first node element of the SLList */
//     public int getFirst(){
//         return first.item;
//     }

//     private static int get(IntNode n, int i){
//         if(i==0 || n.next == null ){
//             return n.item;
//         }
//         return get(n.next, i-1);
//     }
//     public int get(int i){
//         return get(first,i);
//     }

//     /* get size of the IntNode in SLList */ 
//     private static int size(IntNode n){
//        if(n.next == null){
//            return 1;
//        }
//        return 1 + size(n.next);
//     }

//     /*get size of SLList */
//     public int size(){
//         return size(first);
//     }
   
//     /*  get last element of the List */
//     public int getLast(){
//         IntNode p = first;
//         while(p.next != null){
//             p = p.next;
//         }
//         return p.item;
//     }

//     /* remove last node of SLList */
//     public void removeLast(){
//         IntNode p = first;
//         while(p.next.next != null){
//             p = p.next;
//         }
//         p.next = null;
//     }

//     public void remove(int i){

//     }

//     public static void main(String[] args) {
//         SLList L = new SLList(15);
//         L.addFirst(10);
//         L.addLast(12);
//         // L.first.next.next = L.first.next; 
//         System.out.println(L.size());
//         System.out.println(L.get(1));
//         System.out.println(L.getLast());
//         L.removeLast();
//         System.out.println(L.size());
//         System.out.println(L.get(1));
//         System.out.println(L.getLast());
//     }
// }

public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel; 
    private int size;

    // public SLList() {
    //     sentinel = new IntNode(0, null);
    //     size = 0;
    // }

    public SLList(int x) {
        // sentinel = new IntNode(0, null);
        sentinel = new IntNode(x, sentinel);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel = new IntNode(x, sentinel);
        size += 1;
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
    
        return sentinel.next.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size += 1;

        // if(first == null){
        //     first = new IntNode(x, null);
        //     return;
        // }
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public void deleteFirst(){
        if(size == 0){
            return;
        }
        IntNode p = sentinel;
        p.next = p.next.next;
    }


    public void insert(int item, int pos){
        size += 1;
        IntNode p = sentinel;
        IntNode rest = null;
        while( pos > 0 ){
            rest = new IntNode(p.item, rest);
            p = p.next;
            pos -= 1;
        }
        //IntNode x = reverse(rest);
        p = new IntNode(item, p);
        while( rest != null){
            p = new IntNode(rest.item, p);
            rest = rest.next;
        }
        sentinel = p;
        
    }
    
    public void reverse(){
        IntNode p = sentinel;
        IntNode reverse = null;
        IntNode second = null;
        while(p != null){
            second = p.next;
            p.next = reverse;
            reverse = p;
            p = second;
        }
    }
    /** Crashes when you call addLast on an empty SLList. Fix it. */
    
}