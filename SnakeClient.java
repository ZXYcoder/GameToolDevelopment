import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeClient extends Frame
{

	 Socket s = null;
	
	public SnakeClient() throws Exception
	{
		s = new Socket("172.29.51.48", 8888);
		
//		(new Thread(new ReceiveThread())).start();
	}
	
//	public void send(String str) throws Exception
//	{	
//		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//		dos.writeUTF(str);
//	}
	
	public void disconnect() throws Exception
	{
		s.close();
	}
	
	public static void main(String[] args) throws Exception
	{	
		BufferedReader br = new BufferedReader (
							new InputStreamReader(System.in));
		
		SnakeClient cc = new SnakeClient();
		
		DataInputStream dis = new DataInputStream(cc.s.getInputStream());

		DataOutputStream dos = new DataOutputStream(cc.s.getOutputStream());
		
		String str = br.readLine();

		while(str != null && str.length() != 0)
		{
			dos.writeUTF(str);
			String str2 = dis.readUTF();
			System.out.println(str2);			
			str = br.readLine();
		}
		cc.disconnect();
	}
	
//	class ReceiveThread implements Runnable
//	{
//		public void run()
//		{
//			if(s == null) return;
//			try {
////				BufferedReader br = new BufferedReader (
////						new InputStreamReader(s.getInputStream()));
//				DataInputStream dis = new DataInputStream(s.getInputStream());
//				String str = dis.readUTF();
//				while (str != null && str.length() != 0)
//				{
//					System.out.println(str);
//				
//					str = dis.readUTF();
//				}
//			} 
//			catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//			
//		}
//	}
}