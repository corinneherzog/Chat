public class ServerTest {
    public static void main(String[] args){
   //     ArrayList<String>  messagesSent= new ArrayList<String>();
   //     ArrayList<String>  messagesRecieved= new ArrayList<String>();
        int portNum = Integer.parseInt(args[0]);
        try {
            ServerSocket server = new ServerSocket(portNum);
            Socket client = server.accept();
            PrintWriter out =  new PrintWriter(client.getOutputStream() , true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

            do{
                String userInput = userIn.readLine();
                out.print(userInput);
                if(userInput.equals("done")){
                    break;
                }

            }while(in.readLine() != null);
        }
        catch(IOException e){
            System.out.print(e);

        }
    }
}
