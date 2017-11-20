package Main;


import Control.Ctrl;
import View.Menu;
import View.Finestra;

public class Main {

	public static void main(String[] args) throws Exception{
		
		Finestra f = new Finestra();
		Ctrl c = new Ctrl(f);
		f.setVisible(true);
	}
	
	
}
