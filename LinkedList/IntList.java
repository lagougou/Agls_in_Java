public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if(rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int get(int i){
       if(i == 0){
           return first;
       }
       return rest.get(i-1);
    }
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        while (L != null){
            L.first = L.first + x;
            L = L.rest;
        }
        return L;        
    }

    public static IntList square(IntList L){
        if (L == null){
            return L;
        }else{
            L.first *= L.first;
            square(L.rest);
        }
        // IntList L_sub = L;
        // while (L_sub != null ){
        //     L_sub.first *= L_sub.first;
        //     L_sub = L_sub.rest;
        // }
        return L;
    }

}


