package Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.DrawList;
import model.PaintObject;

public class Server {
	public static int PORT_NUMBER = 4009;
	private static List<ObjectOutputStream> list = Collections.synchronizedList(new ArrayList<ObjectOutputStream>());
	private static DrawList drawlist;

	public static void main(String[] args) throws IOException {
		drawlist = new DrawList();
		Socket client = null;
		ServerSocket socket = new ServerSocket(PORT_NUMBER);
		ObjectInputStream fromClient = null;
		ObjectOutputStream toClient = null;
		while (true) {
			try {
				client = socket.accept();
				fromClient = new ObjectInputStream(client.getInputStream());
				toClient = new ObjectOutputStream(client.getOutputStream());
				toClient.writeObject(drawlist);
			} catch (IOException e) {
			}
			list.add(toClient);
			ClientHandler handler = new ClientHandler(fromClient, list, drawlist);
			handler.start();
		}
	}
}

class ClientHandler extends Thread {
	private ObjectInputStream fromclient;
	private List<ObjectOutputStream> list;
	private DrawList drawlist = new DrawList();

	public ClientHandler(ObjectInputStream input, List<ObjectOutputStream> lists, DrawList d) {
		list = new ArrayList<ObjectOutputStream>();
		list = lists;
		this.fromclient = input;
		drawlist = d;
	}

	@Override
	public void run() {
		while (true) {
			PaintObject draw = null;
				try {
					draw = (PaintObject) fromclient.readObject();
				} catch (ClassNotFoundException e) {
				
				} catch (IOException e) {
	
				}
			drawlist.add(draw);
			writetoclient(draw);
		}
	}

	public void writetoclient(PaintObject draw) {
		synchronized (list) {
			for (ObjectOutputStream a : list)
				try {
					a.writeObject(draw);
				} catch (IOException e) {
				}
		}
	}
}