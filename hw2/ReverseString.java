package hw2;

public class ReverseString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackArray<Character> stk = new StackArray<Character>(10);
        String temp = "terry";
        for(int i=0;i<temp.length(); i++) {
            stk.push(temp.charAt(i));
        }
        while(!stk.isEmpty()) {
            System.out.print(stk.peek());
            stk.pop();
        }
        
    }

}
