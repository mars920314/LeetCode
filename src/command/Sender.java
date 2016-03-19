package command;

public class Sender {
	Command command;
	public Sender(Command command){
		this.command = command;
	}
	public void appoint(String content){
		command.setCommand(content);
		command.execute();
	}
}
