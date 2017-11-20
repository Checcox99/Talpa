package Model;

public class CDP {
	
	byte[] buffer;

	public CDP() {
		//primo B identifica il giocatore
		//secondo B indica la cella selezionata 1-25
		//terzo B indica risultato della cella 1-2
		//ACK per N -> N,0,0,0
		//VITTORIA di N -> N,255,255,255
		//SET giocatore N -> N,200,200,200
		buffer = new byte[3];
		azzera();
	}
	
	public void azzera() {
		this.buffer[0] = (byte) 0;
		this.buffer[1] = (byte) 0;
		this.buffer[2] = (byte) 0;
	}
	
	public int getGiocatore() {
		return buffer[0] & 0xFF;
	}

	public void setBuffer(int g) {
		this.buffer[0] = (byte) g;
	}
	
	public int getCella() {
		return buffer[1] & 0xFF;
	}

	public void setCella(int c) {
		this.buffer[1] = (byte) c;
	}
	
	public int getRis() {
		return buffer[2] & 0xFF;
	}

	public void setRis(int r) {
		this.buffer[2] = (byte) r;
	}

	public void setVittoria(int g) {
		this.buffer[0] = (byte) g;
		this.buffer[1] = (byte) 255;
		this.buffer[2] = (byte) 255;
	}
	
	public void setAck(int g) {
		this.buffer[0] = (byte) g;
		this.buffer[1] = (byte) 0;
		this.buffer[2] = (byte) 0;
	}
	
	public void setSet(int g) {
		this.buffer[0] = (byte) g;
		this.buffer[1] = (byte) 200;
		this.buffer[2] = (byte) 200;
	}
	

	public byte[] getBuffer() {
		return buffer;
	}
	
	public boolean conf(CDP buffer) {
		boolean flag=true;
		if(this.getGiocatore()!= buffer.getGiocatore()) flag=false;
		if(this.getCella()!= buffer.getCella()) flag=false;
		if(this.getRis()!= buffer.getRis()) flag=false;
		return flag;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}
	
	public String toString(){
		return "" + (buffer[0] & 0xFF) + (buffer[1] & 0xFF) +(buffer[2] & 0xFF);
	}
	

}
