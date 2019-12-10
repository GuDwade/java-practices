public class ThrowException {
    public static void main(String[] args) {
        //子类在上，父类在下
        try{
            //throw new RuntimeException();
            throw new Exception();
        }catch(RuntimeException e){
            System.out.println("我是RuntimeException");
        }catch(Exception e){
            System.out.println("我是Exception");
        }
    }
}
