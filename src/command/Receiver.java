package command;

public class Receiver {
	public void action(Command cmd){
		System.out.println("command received " + cmd.getCommand());
	}
}
