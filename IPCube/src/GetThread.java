import java.io.BufferedReader;
import java.io.IOException;

public class GetThread extends Thread{
    public BufferedReader in;
    GetThread(String name, BufferedReader in){
        super(name);
        this.in = in;
    }

    public void run(){
        try {
            while (true) {
                String mes = in.readLine();
                if(mes.equals("stop")){
                    break;
                }
                System.out.println(mes);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
