package state;

public class Context {
	public State state;
	public Context(State state){
		this.state = state;
	}
	public void method(){
		if(state.state.equals("red"))
			state.methodRed();
		else if(state.state.equals("blue"))
			state.methodBlue();
	}
}
