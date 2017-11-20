package Model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import Control.Ctrl;

public class DgSS implements Runnable{
	
		private static DatagramSocket s;
		private DatagramPacket pkt;
		private byte[] buf = new byte[256];
		static boolean running;
		
		public DgSS(int PORT) throws Exception{
			System.out.printf("Server ready to recive on port: %d..\n", PORT);
			s = new DatagramSocket(PORT);
		}

		@Override
		public void run() {
			running = true;
			String CMD;
			for ( ; running; ) {
				pkt = new DatagramPacket(buf, buf.length);
				try {
					s.receive(pkt);
				} catch (Exception e) {	}
				CMD=new String(pkt.getData(), 0, pkt.getLength());
				Ctrl.getPROTO().setBuffer(pkt.getData());
				//running = !CMD.equals("END");
			}
			System.out.println("Remote Command! Server Closed..");
			s.close();
		}

		public static DatagramSocket getS() {
			return s;
		}

		public static void setS(DatagramSocket s) {
			DgSS.s = s;
		}

		public static boolean isRunning() {
			return running;
		}

		public static void setRunning(boolean running) {
			DgSS.running = running;
		}

}
