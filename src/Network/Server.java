package Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.DrawList;
import model.PaintObject;

public class Server {
	public static int PORT_NUMBER = 4009;
	
	 public static void main(String[] args) throws IOException {
		 	ArrayList<ObjectOutputStream> list=new ArrayList<ObjectOutputStream>();
		    Socket client = null;
		    ServerSocket socket = new ServerSocket(PORT_NUMBER);
		    ObjectInputStream fromClient = null;
		    ObjectOutputStream toClient = null;
		    while(true){
		    	try {
					client=socket.accept();
					fromClient=new ObjectInputStream(client.getInputStream());
					toClient=new ObjectOutputStream(client.getOutputStream());
					System.out.println("Server receive message");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	list.add(toClient);
		    	ClientHandler handler= new ClientHandler(fromClient,list);
		    	handler.start();
		    }
	 }
}
class ClientHandler extends Thread{
	private ObjectInputStream fromclient;
	private ArrayList<ObjectOutputStream> list;
	public ClientHandler(ObjectInputStream input, ArrayList<ObjectOutputStream> list){
		list=new ArrayList<ObjectOutputStream>();
		this.list=list;
		this.fromclient=input;
	}
	@Override
	public void run(){
		while(true){
			try {
				PaintObject draw = (PaintObject)fromclient.readObject();
				for(ObjectOutputStream a:list){
					a.writeObject(draw);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
