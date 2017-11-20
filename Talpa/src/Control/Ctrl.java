package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Model.CDP;
import Model.DgSC;
import Model.DgSS;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.PrintRequestAttribute;
import javax.swing.JButton;
import javax.swing.JLabel;

import View.Menu;
import View.Client;
import View.Finestra;
import View.Server;

public class Ctrl implements ActionListener{

	Finestra f;
	Menu m;
	Server s;
	Client c;
	char scheda;
	byte[] SOL;
	InetAddress IP;
	int PORT;
	int TALPA;
	static boolean RUN;
	static CDP PROTO;
	static CDP PROTOout;
	ArrayList<Integer> GAMERS;
	Timer timer;
	CDP ris;
	int PLAYER;
	int SELECT;
	JButton[] ARR;
	boolean FLAG;
	boolean runner;
	boolean ABILITATO;
	
	private static final String UP_STRING = ":-)";
	private static final String DOWN_STRING = ":-(";
	private static final Color UP_COLOR = Color.GREEN;
	private static final Color DOWN_COLOR = Color.RED;
	

	public Ctrl(Finestra f) {
		this.f = f;
		RUN=true;
		PROTO=new CDP();
		PROTOout=new CDP();
		SOL= new byte[25];
		ARR= new JButton[25];
		runner=true;
		f.setResizable(false);
		
		SELECT=0;
		FLAG=false;
		
		
		
		//inizializzo il pannello Configurazione
		m = new Menu();
		m.getBtnServer().addActionListener(this);
		m.getBtnClient().addActionListener(this);
		m.getTxtIp().addActionListener(this);
		m.getTxtPorta().addActionListener(this);
		
		//inizializzo il pannello Server
		s = new Server();
		s.getBtnStart().addActionListener(this);
		
		//inizializzo il pannello Client
		c = new Client();
		associaArr();
		for(int i=0;i<25;i++){
			ARR[i].addActionListener(this);
		}
		/*c.getButton().addActionListener(this);
		c.getButton_1().addActionListener(this);
		c.getButton_2().addActionListener(this);
		c.getButton_3().addActionListener(this);
		c.getButton_4().addActionListener(this);
		c.getButton_5().addActionListener(this);
		c.getButton_6().addActionListener(this);
		c.getButton_7().addActionListener(this);
		c.getButton_8().addActionListener(this);
		c.getButton_9().addActionListener(this);
		c.getButton_10().addActionListener(this);
		c.getButton_11().addActionListener(this);
		c.getButton_12().addActionListener(this);
		c.getButton_13().addActionListener(this);
		c.getButton_14().addActionListener(this);
		c.getButton_15().addActionListener(this);
		c.getButton_16().addActionListener(this);
		c.getButton_17().addActionListener(this);
		c.getButton_18().addActionListener(this);
		c.getButton_19().addActionListener(this);
		c.getButton_20().addActionListener(this);
		c.getButton_21().addActionListener(this);
		c.getButton_22().addActionListener(this);
		c.getButton_23().addActionListener(this);
		c.getButton_24().addActionListener(this);*/
		
		f.getContentPane().removeAll();
		f.getContentPane().add(m);
		
		scheda='m';
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(m.getBtnServer()==e.getSource()){
			
			try {
				IP = InetAddress.getByName(m.getTxtIp().getText());
				PORT = Integer.parseInt(m.getTxtPorta().getText());
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			f.getContentPane().removeAll();
			f.getContentPane().add(s);
			f.setVisible(true);
			
			scheda = 's';
			
		}
		
		if(m.getBtnClient()==e.getSource()){
			
			Thread T = new Thread(){
				public void run(){
					CDP app = new CDP();
					CDP appset = new CDP();
					CDP pro = new CDP();
					
					try {
						IP = InetAddress.getByName(m.getTxtIp().getText());
						PORT = Integer.parseInt(m.getTxtPorta().getText());
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					}
					
					f.getContentPane().removeAll();
					f.getContentPane().add(c);
					f.setVisible(true);
					
					scheda = 'c';
					
					timer = new Timer();
					
					do{
						PLAYER= (int) (Math.random()*100 +0.5d);
					}while(PLAYER>25 || PLAYER<1);
					
					
					try {
						new Thread(new DgSS(PORT)).start();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					PROTOout.setSet(PLAYER);
					app.setAck(PLAYER);
					appset.setSet(PLAYER);
					
					do{
						try {
							new Thread(new DgSC(DgSS.getS(),IP,PORT,PROTOout.getBuffer())).start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						System.out.println("Connetti player " + PLAYER);
						System.out.println(PROTO.toString());
						System.out.println(app.toString());
					}while(PROTO.conf(app)==false);
					System.out.println(PROTO.toString());
					System.out.println(PLAYER + " connesso");
					
					do{
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(PROTO.conf(appset)==true){
							c.getPanel_uno().setBackground(UP_COLOR);
							c.getPanel_due().setBackground(DOWN_COLOR);
							System.out.println("abilita");
							snabilita(true);
							do{
								PROTOout.setAck(PLAYER);
								try {
									new Thread(new DgSC(DgSS.getS(),IP,PORT,PROTOout.getBuffer())).start();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								System.out.println("ack verso il server");
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}while(FLAG==false);
							pro.setBuffer(PLAYER);
							pro.setCella(SELECT);
							PROTOout=pro;
							PROTO.setRis(0);
							do{
								System.out.println("invio " + PROTOout.toString());
								try {
									new Thread(new DgSC(DgSS.getS(),IP,PORT,PROTOout.getBuffer())).start();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}while(PROTO.getRis()==0);
							System.out.println("ricevuta risposta" + PROTO.toString());
							pro=PROTO;
							if(pro.getRis()==1){
								ARR[pro.getCella()-1].setBackground(DOWN_COLOR);
							}
							if(pro.getRis()==2){
								ARR[pro.getCella()-1].setBackground(UP_COLOR);
								c.getLblRisultato().setText("VINTO");
								c.getLblRisultato().paintImmediately(c.getLblRisultato().getVisibleRect());
								runner=false;
							}
							snabilita(false);
							System.out.println("fine turno");
							PROTOout.setAck(PLAYER);
							for(int i=0; i<10;i++){
								try {
									new Thread(new DgSC(DgSS.getS(),IP,PORT,PROTOout.getBuffer())).start();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}else{
							c.getPanel_uno().setBackground(DOWN_COLOR);
							c.getPanel_due().setBackground(UP_COLOR);
							pro=PROTO;
							if(pro.getRis()==1){
								ARR[pro.getCella()-1].setBackground(DOWN_COLOR);
							}
							if(pro.getRis()==2){
								ARR[pro.getCella()-1].setBackground(UP_COLOR);
								c.getLblRisultato().setText("PERSO");
								c.getLblRisultato().paintImmediately(c.getLblRisultato().getVisibleRect());
								f.setVisible(false);
								f.setVisible(true);
								runner=false;
							}
						}
						FLAG=false;
					}while(runner==true);
					System.out.println("fine partita");
				}
			};
			T.start();
			
			/*CDP app = new CDP();
			
			try {
				IP = InetAddress.getByName(m.getTxtIp().getText());
				PORT = Integer.parseInt(m.getTxtPorta().getText());
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			f.getContentPane().removeAll();
			f.getContentPane().add(c);
			f.setVisible(true);
			
			scheda = 'c';
			
			timer = new Timer();
			
			do{
				PLAYER= (int) (Math.random()*100 +0.5d);
			}while(PLAYER>25 || PLAYER<1);
			
			
			try {
				new Thread(new DgSS(PORT)).start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			PROTOout.setSet(PLAYER);
			app.setAck(PLAYER);
			
			do{
				try {
					new Thread(new DgSC(DgSS.getS(),IP,PORT,PROTOout.getBuffer())).start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("Connetti player " + PLAYER);
				System.out.println(PROTO.toString());
				System.out.println(app.toString());
			}while(PROTO.conf(app)==false);
			System.out.println(PROTO.toString());
			System.out.println(PLAYER + " connesso");*/
			
			
		}
		
if(s.getBtnStart()==e.getSource()){
			
			s.getLblTesto().setText("In attesa della connesione dei due giocatori");
			s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
			
			GAMERS = new ArrayList<Integer>();
			timer = new Timer();
			
			do{
				TALPA= (int)(Math.random()*100 + 0.5d);
			}while(TALPA>24);
			
			costruisci(TALPA);
			
			try {
				new Thread(new DgSS(PORT)).start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//connessione giocatori temporizzata
			/*timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
				    if(GAMERS.contains(PROTO.getGiocatore())==false){
				    	GAMERS.add(PROTO.getGiocatore());
				    	PROTOout.setAck(GAMERS.get(GAMERS.size()-1));
				    	System.out.println("proto "+PROTO.getGiocatore());
				    	System.out.println("proto out "+PROTOout.getGiocatore());
				    	System.out.println("gamers "+GAMERS);
				    	
				    	try {
							new Thread(new DgSC(DgSS.getS(),InetAddress.getByName("255.255.255.255"),PORT,PROTOout.getBuffer())).start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				  
				    }
				  }
				}, 10*1000);
			
			try {
				TimeUnit.SECONDS.sleep(11);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			
			int G = 0;
			do{
				//System.out.println("attendo");
				if((GAMERS.contains(PROTO.getGiocatore())==false) && PROTO.getGiocatore()!=0){
			    	GAMERS.add(PROTO.getGiocatore());
			    	PROTOout.setAck(GAMERS.get(GAMERS.size()-1));
			    	G++;
			    	s.getLblTesto().setText("Giocatore " + G + " connesso");
			    	s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
			    	
			    	System.out.println("Connetti player " + G);
			    	System.out.println(GAMERS.get(G-1));
					System.out.println(PROTO.toString());
					System.out.println(PROTOout.toString());
			    	
			    	for(int i=0;i<3;i++){
			    		try {
							new Thread(new DgSC(DgSS.getS(),InetAddress.getByName("255.255.255.255"),PORT,PROTOout.getBuffer())).start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			    	}
			    	
			  
			    }
			}while(GAMERS.size()<2);
			
			System.out.println("talpa " + TALPA);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			s.getLblTesto().setText("Giocatori connessi");
	    	s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ris = new CDP();
			
			G=1;
			
			while(RUN==true){
				
				if(G==1){
					G=0;
				}
				else{
					G=1;
				}
					

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//chiedi mossa al giocatore
				s.getLblTesto().setText("Richiesta mossa al giocatore " + (G+1));
				s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
				System.out.println("Richiesta mossa al giocatore " + G);
				chiedi(G);
				
				
				//ottieni e invia risposta dal giocatore 
				s.getLblTesto().setText("Attesa mossa del giocatore " + (G+1));
				s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
				System.out.println("Attesa mossa del giocatore " + G);
				prendiDai(G);
				
				if(ris.getRis()==2) RUN=false;
				
				
				
			}
			DgSS.setRunning(RUN);
			
			s.getLblTesto().setText("GIOCATORE " + G + " HA VINTO");
			s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
			
		}
		
		if(c.getButton()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton().getText());
			FLAG=true;
		}
		if(c.getButton_1()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_1().getText());
			FLAG=true;
		}
		if(c.getButton_2()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_2().getText());
			FLAG=true;
		}
		if(c.getButton_3()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_3().getText());
			FLAG=true;
		}
		if(c.getButton_4()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_4().getText());
			FLAG=true;
		}
		if(c.getButton_5()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_5().getText());
			FLAG=true;
		}
		if(c.getButton_6()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_6().getText());
			FLAG=true;
		}
		if(c.getButton_7()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_7().getText());
			FLAG=true;
		}
		if(c.getButton_8()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_8().getText());
			FLAG=true;
		}
		if(c.getButton_9()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_9().getText());
			FLAG=true;
		}
		if(c.getButton_10()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_10().getText());
			FLAG=true;
		}
		if(c.getButton_11()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_11().getText());
			FLAG=true;
		}
		if(c.getButton_12()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_12().getText());
			FLAG=true;
		}
		if(c.getButton_13()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_13().getText());
			FLAG=true;
		}
		if(c.getButton_14()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_14().getText());
			FLAG=true;
		}
		if(c.getButton_15()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_15().getText());
			FLAG=true;
		}
		if(c.getButton_16()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_16().getText());
			FLAG=true;
		}
		if(c.getButton_17()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_17().getText());
			FLAG=true;
		}
		if(c.getButton_18()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_18().getText());
			FLAG=true;
		}
		if(c.getButton_19()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_19().getText());
			FLAG=true;
		}
		if(c.getButton_20()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_20().getText());
			FLAG=true;
		}
		if(c.getButton_21()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_21().getText());
			FLAG=true;
		}
		if(c.getButton_22()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_22().getText());
			FLAG=true;
		}
		if(c.getButton_23()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_23().getText());
			FLAG=true;
		}
		if(c.getButton_24()==e.getSource()){
			SELECT= Integer.parseInt(c.getButton_24().getText());
			FLAG=true;
		}
		
		
		
	}
	
	
	private void prendiDai(int g) {
		CDP app = new CDP();
		CDP ack = new CDP();
		PROTOout.azzera();
		int ccc=0;
		boolean pre= false;
		ack.setAck(GAMERS.get(g));
		app.azzera();
		System.out.println("uno proto " + PROTO.toString());
		do{
			do{
				PROTOout.azzera();
				System.out.println("due");
				if(PROTO.conf(ack)==false && ack.getGiocatore()==PROTO.getGiocatore() && PROTO.getCella()!=0){
					System.out.println("tre");
					System.out.println("ack " + ack.toString());
					System.out.println("proto " + PROTO.toString());
					PROTOout=PROTO;
					ccc=PROTOout.getCella();
					PROTOout.setRis(SOL[ccc]);
					System.out.println("risposta " + PROTOout.toString());
					try {
						new Thread(new DgSC(DgSS.getS(),InetAddress.getByName("255.255.255.255"),PORT,PROTOout.getBuffer())).start();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					pre=true;
				}
			}while(pre==false);
			System.out.println("quattro");
			if(PROTOout.getRis()==2) {
				RUN=false;
				ris.setBuffer(PROTOout.getBuffer());
			}
			s.getLblTesto().setText("Risposta per il giocatore " + g);
			s.getLblTesto().paintImmediately(s.getLblTesto().getVisibleRect());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("ack " + ack.toString());
			System.out.println("proto " + PROTO.toString());
			System.out.println("protout " + PROTOout.toString());
		}while(ack.conf(PROTO)==false);
		
	}

	private void chiedi(int g) {

		CDP ack = new CDP();
		System.out.println("chiedi al " + (g));
		PROTOout.setSet(GAMERS.get(g));
		ack.setAck(GAMERS.get(g));
		do{
			System.out.println(PROTOout.toString());
			try {
				new Thread(new DgSC(DgSS.getS(),InetAddress.getByName("255.255.255.255"),PORT,PROTOout.getBuffer())).start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}while(ack.conf(PROTO)==false);
	}
	
	public static CDP getPROTO() {
		return PROTO;
	}

	public void setPROTO(CDP pROTO) {
		PROTO = pROTO;
	}


	private void costruisci(int T) {
		for(int i=0;i<25;i++){
			SOL[i]= (byte) 1;
		}
		SOL[T]= (byte) 2;
	}

	public static boolean isRUN() {
		return RUN;
	}

	public static void setRUN(boolean rUN) {
		RUN = rUN;
	}
	
	private void associaArr() {
		ARR[0]=c.getButton();
		ARR[1]=c.getButton_1();
		ARR[2]=c.getButton_2();
		ARR[3]=c.getButton_3();
		ARR[4]=c.getButton_4();
		ARR[5]=c.getButton_5();
		ARR[6]=c.getButton_6();
		ARR[7]=c.getButton_7();
		ARR[8]=c.getButton_8();
		ARR[9]=c.getButton_9();
		ARR[10]=c.getButton_10();
		ARR[11]=c.getButton_11();
		ARR[12]=c.getButton_12();
		ARR[13]=c.getButton_13();
		ARR[14]=c.getButton_14();
		ARR[15]=c.getButton_15();
		ARR[16]=c.getButton_16();
		ARR[17]=c.getButton_17();
		ARR[18]=c.getButton_18();
		ARR[19]=c.getButton_19();
		ARR[20]=c.getButton_20();
		ARR[21]=c.getButton_21();
		ARR[22]=c.getButton_22();
		ARR[23]=c.getButton_23();
		ARR[24]=c.getButton_24();
		
	}
	
	private void snabilita(boolean f){
		for(int i=0;i<25;i++){
			ARR[i].setEnabled(f);
		}
	}
	
}
