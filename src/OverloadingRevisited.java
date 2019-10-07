class OverloadingRevisited{
    public static void main(String[] args) {
 
        int var = 761;
 
        // int -> Integer -> Long
         
    OverloadingRevisited ref = new OverloadingRevisited();
    ref.func((byte) var);
 
    }
 
 
    void func(Long b){
        System.out.println("Long...");
    }
 
    void func(byte b){
        System.out.println("byte");
    }
}