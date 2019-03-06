public class DLList<Item>{
    public class IntNode{
        public Item item;
        public IntNode next; 
        public IntNode prev;
        public IntNode(IntNode p,Item i, IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
    int size = 0;
    IntNode first = null;
    IntNode last = null;
    public DLList(Item x){
        first = last = new IntNode(first,x,last);
        size = 1;
    }

    public void addFirst(Item x){
        size +=1;
        IntNode temp = new IntNode(null, x, null);
        if(first == null){
            first = last = temp;
        }else{
            first.prev = temp;
            temp.next = first;
            first = temp;
        }
        
    }
    public void addLast(Item x){
        size += 1;
        IntNode temp = new IntNode(null, x, null);
        if(first == null){
            first = last = temp;
        }else{
            last.next = temp;
            temp.prev = last;
            last = temp;
        }  
    }

    public Item get(int i){
        if(size == 0){
            return null;
        }
        IntNode p = first;
        while( i > 0 && p != last){
            p = p.next;
            i--;
        }
        return p.item;
    }

    public void removeLast(){
        if(first == null){
            return;
        }else{
                size -= 1;
                if(last == first && first != null ){
                    last = first = null;
                }else{
                    IntNode p = last.prev;
                    last.prev.next = null;
                    last = p; 
                }
        }    
    }

}