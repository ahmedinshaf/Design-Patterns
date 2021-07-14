package Factory;


class Shape{
    public void draw(){
        System.out.println("inside Shape draw method");
    }
}

class Rectangle extends Shape {
//    public String name="name";
//    @Override
//    public void draw() {
//        super.draw();
//        System.out.println("inside Rectangle draw method");
//    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        String theRole = "CASHIER";
        User user = UserFactory.getUser(theRole);
        user.login();
        user.enterToTable();
    }
}

class User{
    public void login (){
        System.out.println("User login");
    }
    public void register () {
        System.out.println("User register");
    }
    public void enterToTable() {
        System.out.println("user enter to table");
    }
}
class BusinessOwner extends User{
    public void enterToTable() {
        super.enterToTable();
        System.out.println("Business owner entered to Table");
    }
}
class Cashier extends User{
    @Override
    public void enterToTable() {
        super.enterToTable();
        System.out.println("Cashier entered to Table");
    }
}

class UserFactory {
    public static User getUser(String role){
        switch (role){
            case "OWNER":
                return new BusinessOwner();
            case "CASHIER":
                return new Cashier();
            default:
                return null;
        }
    }
}






