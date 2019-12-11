import java.util.ArrayList;

public class TryCatchException {
    public static void main(String[] args) {
        try{
            new ArrayList<Integer>().get(0);
        }catch(RuntimeException e){
            throw new MyException("下标越界",e);
        }
    }
}
