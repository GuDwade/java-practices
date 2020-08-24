import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.实现Callable接口
public class CallableTest implements Callable {
    //2.重写call()方法
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==1){
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        //3.创建实现了callable()接口的类对象
        CallableTest callableTest=new CallableTest();
        //4.创建FutureTask对象，传入callable实例对象
        FutureTask futureTask=new FutureTask(callableTest);
        //5.FutureTask传入Thread()构造方法
        new Thread(futureTask).start();

        try {
            //6.获得线程操作返回结果
            int sum= (int)futureTask.get();

            System.out.println("返回结果为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
