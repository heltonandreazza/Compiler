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
	private String input;
	private String lastToken;
	private String lastFileName;
	private String lastFileCode;

	public char getLastLexeme() {
		return this.lastLexeme;
	}

	public void setLastLexeme(char lexeme) {
		this.lastLexeme = lexeme;
	}

	public int getErrorLine() {
		return this.errorLine;
	}

	public void setErrorLine(int pos) {
		this.errorLine = input.substring(0, pos + 1).split("\\r?\\n").length;
	}

	public void setLastToken(String lexeme) {
		this.lastToken = lexeme;
	}

	public String getLastToken() {
		return this.lastToken;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput() {
		return this.input;
	}

	public String getLastFileName() {
		return lastFileName;
	}

	public void setLastFileName(String lastFileName) {
		this.lastFileName = lastFileName;
	}

	public String getLastFileCode() {
		return lastFileCode;
	}

	public void setLastFileCode(String lastFileCode) {
		this.lastFileCode = lastFileCode;
	}

}
