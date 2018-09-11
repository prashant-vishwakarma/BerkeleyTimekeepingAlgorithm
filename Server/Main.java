package ui;

import java.net.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Berkeley's Server\nEnter Port Number");
		int port = Integer.parseInt(br.readLine());

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();

			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			Date date = (Date) objectInputStream.readObject();

			Date myDate = new Date();

			System.out.println("Client" + date.toString() + "\n" + myDate.toString());

			long differenceInSeconds = myDate.getTime() - date.getTime();
			System.out.println("Difference in Seconds: " + TimeUnit.MILLISECONDS.toSeconds(differenceInSeconds));

			Date averageDate = new Date((myDate.getTime() + date.getTime()) / 2);
			System.out.println("Average Date" + averageDate.toString());

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(averageDate);

			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
