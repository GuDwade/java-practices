public class CheckedException {
    public static void method()throws Exception{

    }
    public static  void methodB()throws  RuntimeException{

    }
    //Exception是受查异常，其余为非受查异常
    public static void test1(){
        methodB();
    }
    /*
    public static void test() throws Exception {
        method();
    }
    */
    public static void test()throws RuntimeException{
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
