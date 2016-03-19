package state;

public class StateText {
	public static void main(String[] args){
		State state = new State();
		Context context = new Context(state);
		state.state = "red";
		context.method();
		state.state = "blue";
		context.method();
	}
}
