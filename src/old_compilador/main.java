package old_compilador;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringReader;

public class main {
	private static String lastlexeme;

	public static void main(String[] args) {
		String myStr = "aaaaa \n baaa \n";
		System.out.println(myStr.substring(0, 8 + 1).split("\\r?\\n").length);
		System.out.println(myStr.charAt(8));
		System.out.println(myStr);
		// SINTATICO
		// try {
		// LineNumberReader in = new LineNumberReader(new
		// InputStreamReader(System.in));
		// String line = in.readLine();
		//
		// lexico.setInput(new StringReader(line));
		//
		// // sintatico.parse(lexico, semantico);
		// sintatico.parse(lexico, null);
		// System.out.println(" = ");
		// // System.out.println(trans.getResult());
		// } catch (LexicalError e) {
		// System.out.println("Linha: " + lineNumber);
		// e.printStackTrace();
		// } catch (SyntaticError e) {
		// System.out.println("Linha: " + lineNumber);
		// e.printStackTrace();
		// } catch (SemanticError e) {
		// // TODO Auto-generated catch block
		// System.out.println("Linha: " + lineNumber);
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
