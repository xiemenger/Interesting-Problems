class Solution{
}

// Abstract class can contains 0 - n abstract methods. 
abstract class MaheshPhone{
    public void call(){
        System.out.println("calling...");
    }

    // this class has this method, 
    // but don't know the details of this method. 
    // the methods' details may change according to specific case.
    // so we define it as an abstract method.
    public abstract void move();  
    public abstract void dance();
    public abstract void cook();
}

// extends MaheshPhone,  define some of the abstract methods.
// since MaheshPhone only rewrite the abstract method move, 
// it still has abstract methods: dance and cook .
// so it still a abstract class.
abstract class RameshPhone extends MaheshPhone{
    public void move(){
        System.out.println("moving......");
    }
}

// since SureshPhone has no abstract method.
// so it still a normal class.
// it can be instantiate. 
class SureshPhone extends RameshPhone{
    public void dance(){
        System.out.println("dancing......");
    }

    public void cook(){
        System.out.println("cooking......");
    }
}