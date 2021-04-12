import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static BufferedReader in;
    public static BufferedWriter out;
    public static BufferedReader reader;
    public static GetThread thread;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 2288);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            thread = new GetThread("GettingThread", in);
            thread.start();
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Введите сообщение:");
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                //String serverWord = in.readLine();
                //System.out.println("Хост сказал: " + serverWord);
                //if (serverWord.equals("стоп")){
                //    break;
                //}
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
