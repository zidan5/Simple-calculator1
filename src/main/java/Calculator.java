import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

 class Calculator {


    public  static int add(int num1, int num2, int... numbers){
        int sum = num1 + num2;
        if(numbers.length != 0){
            for(int i : numbers){
                sum += i;
            }
        }
        return  sum;
    }


    public static int multiply(int num1, int num2,int... numbers){
        int product = num1 * num2;
        if(numbers.length != 0){
            for(int i : numbers){
                product *= i;
            }
        }
        return product;
    }
    public static boolean ValidateInput(String str){
        boolean Bool = true;
        try{
            int number = Integer.parseInt(str);
        }catch ( NumberFormatException e ){
            Bool =false;
        }
        return Bool;
    }
    public  static String InnerInputValidation(String answer){
        String YesOrNo="";
        if(!answer.equals("n") && !answer.equals("y")){
            do{
                System.out.println("Enter either 'Y' to continue or N to abort");
                Scanner sc = new Scanner(System.in);
                answer = sc.next().toLowerCase();
                if(answer.equals("n")){
                    break;
                }
            }while (!answer.equals("y"));
        }
        YesOrNo = answer;
        return  YesOrNo;
    }
    public static void UserInputFunction() throws NumberFormatException{
        String YN ="";
        do{
            System.out.println("=======Input any numbers you want,=========");
            System.out.println("then enter '*' to multiply or '+' to add");
            Scanner sc = new Scanner(System.in);
            List<Integer> li = new ArrayList<Integer>();
            li.clear();
            String UserInput = sc.next();

            if(ValidateInput(UserInput)) {
                li.add(Integer.parseInt(UserInput));
            }
            else{throw new NumberFormatException("Invalid input");

            }

            for(int i=0; i<li.size(); i++){ // check list size at least once before entering infinite loop

                UserInput = sc.next();
                if(ValidateInput(UserInput)){

                    li.add(Integer.parseInt(UserInput));// infinitely add numbers to list

                }else if(UserInput.equals("*")){  //Terminate loop and multiply numbers
                    int[] values = new int[li.size()];

                    for(int x = 0; x < li.size(); x++){
                        values[x] = li.get(x);
                    }

                    System.out.println("Product = "+multiply(1,1,values));
                    System.out.println("Want to multiply more numbers? [Y/N]");
                    String YesOrNo = sc.next().toLowerCase();
                    YN = InnerInputValidation(YesOrNo).equals("y") ? "yes": "no";

                } else if (UserInput.equals("+")) {  //Terminate loop and add numbers

                    int[] values = new int[li.size()];

                    for(int x = 0; x < li.size(); x++){
                        values[x] = li.get(x);
                    }
                    System.out.println("Sum = "+add(0,0,values));
                    System.out.println("Want to add more numbers? [Y/N]");
                    String YesOrNo = sc.next().toLowerCase();
                    YN = InnerInputValidation(YesOrNo).equals("y") ? "yes": "no";

                } else {
                    throw new NumberFormatException("You have entered an incorrect input");
                }
            }
        }while (YN.equals("yes"));
    }
    public static void main(String[] Args)throws NumberFormatException{
        try{
            UserInputFunction();
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }

    }

}
