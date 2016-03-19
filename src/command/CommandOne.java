package command;

public class CommandOne implements Command {
	String commandContent;
	Receiver receiver;
	public CommandOne(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		System.out.println("CommandOne is executing");
		receiver.action(this);
	}
	public void setCommand(String content){
		this.commandContent = content;
	}
	public String getCommand(){
		return commandContent;
	}
}
