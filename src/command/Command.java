package command;

public interface Command {
	public void execute();
	public void setCommand(String content);
	public String getCommand();
}
