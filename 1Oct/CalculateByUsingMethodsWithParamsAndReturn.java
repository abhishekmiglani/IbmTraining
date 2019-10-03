class CalculateByUsingMethodsWithParamsAndReturn{
    
    public static void main(String[] args) {
    new CalculateByUsingMethodsWithParamsAndReturn().display();
     
    }
    void display(){
        System.out.println(input());
    }

    int input(){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter two numbers");
        int firstNum = scan.nextInt();
        int secondNum = scan.nextInt();
        return(add(firstNum,secondNum));
    }
 
    int add(int firstNum, int secondNum){
        return firstNum + secondNum;
    }
}