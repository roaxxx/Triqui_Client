package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import view.CustomEvent;
import view.CustomEventResponse;
import view.IOManager;

public class Control implements CustomEvent{
	private CustomEventResponse event;
	
	public void init() {
		IOManager iom = new IOManager();
		iom.setVisible(true);
	}


	@Override
	public void reiniciar() {
		event.restarGame();
		
	}
	
	public CustomEventResponse getEvent() {
		return event;
	}
	public void setEvent(CustomEventResponse event) {
		this.event = event;
	}


	@Override
	public void sendTriqui(String[] boxMirror, int i) {
		
		//Declaración variable tipo Registry
		Registry r;
		try {
			
			//Obtención de registro remoto y asignación de objeto (interfaz)
			r = LocateRegistry.getRegistry("10.57.20.68",1095);
			TriquiRemote stub = (TriquiRemote) r.lookup("TriquiRemote");
			
			int winOp [];
			//Invocación de métodos remoto 
			String resultString = stub.isWinner(boxMirror, i);
			if(!resultString.equals("-")) {
				winOp = stub.getWinOption(boxMirror,resultString);
				event.showWinner(winOp,resultString);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
