package Model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;

public class DgSC implements Runnable{
	
	byte[] MSG;
	InetAddress IP;
	int PORT;
	DatagramSocket DS;
	
	public DgSC(DatagramSocket ds, InetAddress IP, int PORT, byte[] MSG) throws Exception{
		this.MSG=MSG;
		this.IP=IP;
		this.PORT=PORT;
		this.DS=ds;
	}

	public void run(){
	
			DatagramSocket s = DS;
			try {
				s = new DatagramSocket();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				s.send(new DatagramPacket(MSG, MSG.length, IP, PORT));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.close();
	}

}
