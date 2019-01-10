package cloningExceptionsReflection;

public class MyException extends Exception {
    String message = "There are no fruits of such color. Please enter another color";

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("There are no fruits of such color. Please enter another color");
    }
}
