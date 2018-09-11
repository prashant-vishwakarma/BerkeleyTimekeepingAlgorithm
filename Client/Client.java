import java.io.*;
import java.util.Date;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		try {

			Socket s = new Socket("192.168.107.78", 1025);
			ObjectOutputStream oOut = new ObjectOutputStream(s.getOutputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			String print = new String("hello");
			Scanner sc = new Scanner(System.in);
			// print=sc.nextLine();
			// dout.writeUTF(print);
			Date date1 = new Date();
			oOut.writeObject(date1);
			ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
			Date serverDate = (Date) oin.readObject();
			System.out.println("" + date1);
			System.out.println("" + serverDate);

			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = dis.readUTF();
			System.out.println("Server: " + str);
			dout.flush();
			dout.close();
			s.close();
			// sc.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
