/**
 * The Singleton pattern escapsulate a shared resource within a single
 * unique class instance. 
 * 1. Only have one instance.
 * 2. The constructor must be private
 * 3. 
 */

 class Singleton{

    //创建 Singleton 的一个对象
     private static Singleton _instance;
     private String s;

     //让构造函数为 private，这样该类就不会被实例化
     private Singleton(){
         s = "Hello, I am ....";
     }

     public static Singleton getInstance(){
        if (_instance == null){
            _instance = new Singleton();
        }
        return _instance;
     }
 }