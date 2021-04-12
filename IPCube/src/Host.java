import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Host {
    public static ServerSocket socket;
    public static Socket client;
    public static BufferedReader in;
    public static BufferedWriter out;
    public static BufferedReader reader;
    public static GetThread thread;

    public static void main(String[] args) {
        try{
            socket = new ServerSocket(2288);
            client =  socket.accept();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            thread = new GetThread("GetThreadHost", in);
            thread.start();
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                //String clientWord = in.readLine();
                //if (clientWord.equals("стоп")){
                //    break;
                //}
                //System.out.println("Клиент написал: " + clientWord);
                System.out.println("Сообщение: ");
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
