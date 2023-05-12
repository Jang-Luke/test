package e00_Practice;

public class Notation {
	private int _private;
	int _default;
	protected int _proected;
	public int _public;
	
	public Notation() {}
	
	private void _privateF(int num) {}
	void _defaultF(int num, String str) {}
	protected String _protectedF() {return new String();}
	public void _publicF() {}
}
