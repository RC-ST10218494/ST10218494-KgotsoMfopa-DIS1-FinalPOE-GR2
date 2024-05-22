import java.util.regex.*;
class Login{
    String username;
    String pass;
    String name;
    String surname;

    boolean checkUserName(String username){
        if(username.length()>5 || username.indexOf('_')==-1){
            return false;
        }
        else{
            return true;
        }
    }

    boolean checkPasswordComplexity(String pass){
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pass);
        return m.matches();
    }

    boolean loginUser(String username,String pass){
        if(username.equals(this.username) && pass.equals(this.pass)){
            return true;
        }
        else{
            return false;
        }
    }

    String returnLoginStatus(String username,String pass){
        if(loginUser(username, pass)){
            return "Welcome "+name+surname+" it is greater to see you again.";
        }
        else{
            return "Username or passoword incorrect, please try again.";
        }
    }

    void registerUser(String name,String surname,String username,String pass){

        if(checkUserName(username)){
            this.username = username;
            System.out.println("Username successfully Captured");
        }
        else{
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long.");
        }
       if(checkPasswordComplexity(pass)){
           this.pass = pass;
            System.out.println("Password successfully captured");
        }
        else{
            System.out.println("Password is not correctly formatted, please ensure that the passoword contains atleast 8 characters, a capital letter, a number and a special character.");
        }
        if(checkUserName(username) && checkPasswordComplexity(pass)){
            this.name = name;
            this.surname = surname;
            System.out.println(returnLoginStatus(username, pass));
        }
    }
}

