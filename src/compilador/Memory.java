package compilador;

public class Memory {
	private static Memory instance = null;

	protected Memory() {
		// Exists only to defeat instantiation.
	}

	public static Memory getInstance() {
		if (instance == null) {
			instance = new Memory();
		}
		return instance;
	}

	private char lastLexeme;
	private int errorLine;

	public char getLastLexeme() {
		return this.lastLexeme;
	}

	public void setLastLexeme(char lexeme) {
		this.lastLexeme = lexeme;
	}

	public int getErrorLine() {
		return this.errorLine;
	}
	
	public void setErrorLine(int line) {
		this.errorLine = line;
	}

}
