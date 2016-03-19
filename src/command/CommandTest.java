package command;

public class CommandTest {
	public static void main(String[] args){
		Receiver receiver = new Receiver();
		Command command = new CommandOne(receiver);
		Sender sender = new Sender(command);
		sender.appoint("hands up");
	}
}
