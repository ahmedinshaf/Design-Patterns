package Stratgey;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Duck myDuck  = new Duck(new JetFly(),new NoEating());
        System.out.println(myDuck.eat());

    }
}

interface Strategy{
     int doOperation(int num1, int num2);
}

 class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}

class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements  Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}

class Duck implements IEatBehavior,IFlyBehavior{
    private IFlyBehavior flyBehavior;
    private IEatBehavior eatBehavior;
    public Duck(IFlyBehavior fly,IEatBehavior eat){
        this.flyBehavior = fly;
        this.eatBehavior = eat;
    };
    @Override
    public String eat(){
        return eatBehavior.eat();
    }
    @Override
    public String fly() {
        return flyBehavior.fly();
    }
}
interface IFlyBehavior{
    String fly();
}
class JetFly implements IFlyBehavior{
    @Override
    public String fly() {
        return "Jet Fly";
    }
}
class Nofly implements  IFlyBehavior{
    @Override
    public String fly(){
        return "No Fly";
    }
}
interface  IEatBehavior {
    String eat();
}
class Kothi implements  IEatBehavior{
    @Override
    public String eat(){
        return "Kothi eating";
    }
}
class NoEating implements IEatBehavior{
    @Override
    public String eat() {
        return "No eat method";
    }
}


