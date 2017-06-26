package compilador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import javax.sound.midi.Soundbank;

import compilador.Token;

public class Semantico implements Constants {
	// TYPES
	private static final String FLOAT = "float64";
	private static final String INTEGER = "int64";
	private static final String STRING = "string";
	private static final String BOOLEAN = "bool";

	private static final String BR = "\r\n  ";
	// inicializar pilha de types
	Stack<String> pilha = new Stack();
	// inicializar codigo String
	String codigo = "";
	String operador;
	// inicializar tabela de símbolos
	// private HashMap<String, TIPO> table;
	// enumeration TIPO

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
		Integer a, b;

		switch (action) {
		case 1:
			// OK add
			action1();
			break;
		case 2:
			// OK sub
			action2();
			break;
		case 3:
			// OK mul
			action3();
			break;
		case 4:
			// OK div
			action4();
			break;
		case 5:
			// OK cte_inteira
			action5(token.getLexeme());
			break;
		case 6:
			// OK cte_real
			action6(token.getLexeme());
			break;
		case 7:
			// OK write
			action7();
			break;
		case 8:
			// OK soma unária
			action8();
			break;
		case 9:
			// OK subtração unária
			action9();
			break;
		case 10:
			// OK relacional
			action10();
			break;
		case 11:
			// OK salva ultimo operador para usar no relacional action10
			action11(token.getLexeme());
			break;
		case 12:
			// OK boolean true
			action12();
			break;
		case 13:
			// OK boolean false
			action13();
			break;
		case 14:
			// OK negação
			action14();
			break;
		case 15:
			// OK Cabeçalho do programa 
			action15(Memory.getInstance().getLastFileName());
			break;
		case 16:
			// OK fechamento de bloco
			action16();
			break;
		case 17:
			// OK fechamento de programa
			action17();
			break;
		case 18:
			// OK quebra
			action18();
			break;
		case 19:
			// OK and
			action19();
			break;
		case 20:
			// OK ou
			action20();
			break;
		case 21:
			// OK cte_caracter
			action21(token.getLexeme());
			break;
		}
	}

	/**
	 * add
	 * 
	 * @throws SemanticError
	 */
	private void action1() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if ((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER))) {
			if (type1.equals(FLOAT) || type2.equals(FLOAT)) {
				pilha.push(FLOAT);
			} else {
				pilha.push(INTEGER);
			}
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de adição");
		}

		codigo += BR + "add";
	}

	/**
	 * sub
	 * 
	 * @throws SemanticError
	 */
	private void action2() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if ((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER))) {
			if (type1.equals(FLOAT) || type2.equals(FLOAT)) {
				pilha.push(FLOAT);
			} else {
				pilha.push(INTEGER);
			}
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de subtração");
		}

		codigo += BR + "sub";
	}

	/**
	 * mul
	 * 
	 * @throws SemanticError
	 */
	private void action3() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if ((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER))) {
			if (type1.equals(FLOAT) || type2.equals(FLOAT)) {
				pilha.push(FLOAT);
			} else {
				pilha.push(INTEGER);
			}
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de multiplicação");
		}

		codigo += BR + "mul";
	}

	/**
	 * div
	 * 
	 * @throws SemanticError
	 */
	private void action4() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if ((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER))) {
			if (type1.equals(type2)) {
				pilha.push(type1);
			} else {
				throw new SemanticError("Tipos incompatíveis em operação de divisão");
			}
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de divisão");
		}

		codigo += BR + "div";
	}

	/**
	 * cte_inteira
	 * 
	 * @param lexeme
	 */
	private void action5(String lexeme) {
		pilha.push(INTEGER);
		codigo += BR + "ldc.i8 " + lexeme;
	}

	/**
	 * cte_real
	 * 
	 * @param lexeme
	 */
	private void action6(String lexeme) {
		pilha.push(FLOAT);
		codigo += BR + "ldc.r8 " + lexeme;
	}

	/**
	 * write
	 */
	private void action7() {
		String type1 = pilha.pop();
		codigo += BR + ("call void [mscorlib]System.Console::Write(" + type1 + ")");

	}

	/**
	 * soma unária
	 * 
	 * @throws SemanticError
	 */
	private void action8() throws SemanticError {
		String type1 = pilha.pop();

		if (type1.equals(FLOAT) || type1.equals(INTEGER)) {
			pilha.push(type1);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de soma unária");
		}
	}

	/**
	 * subtração unária
	 * 
	 * @throws SemanticError
	 */
	private void action9() throws SemanticError {
		String type1 = pilha.pop();

		if (type1.equals(FLOAT) || type1.equals(INTEGER)) {
			pilha.push(type1);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de subtração unária");
		}

		codigo += BR + "ldc.i8 -1";
		codigo += BR + "mul";
	}

	/**
	 * relacional
	 * 
	 * @throws SemanticError
	 */
	private void action10() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if (type1.equals(type2)) {
			pilha.push(BOOLEAN);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação relacional");
		}

		switch (operador) {
		case "=":
			codigo += BR + "ceq";
			break;
		case "<":
			codigo += BR + "clt";
			break;
		case ">":
			codigo += BR + "cgt";
			break;
		case "<>":
			codigo += BR + "cgt";
			codigo += BR + "ldc.i4.1";
			codigo += BR + "xor";
			break;
		case "<=":
			codigo += BR + "clt";
			//TODO
//			String[] split = codigo.split("\\r?\\n");
//			if(split.length > 3) {
//				String lastCommand = split[split.length - 2];
//				String secondLastCommand = split[split.length - 3];
//				codigo += "\r\n" + secondLastCommand;
//				codigo += "\r\n" + lastCommand;
//				codigo += BR + "ceq";
//				codigo += BR + "or";
//				break;
//			}
			codigo += BR + "ceq";
			codigo += BR + "or";
			break;
		case ">=":
			codigo += BR + "cgt";
			//TODO			
//			split = codigo.split("\\r?\\n");
//			if(split.length > 3) {
//				String lastCommand = split[split.length - 2];
//				String secondLastCommand = split[split.length - 3];
//				codigo += "\r\n" + secondLastCommand;
//				codigo += "\r\n" + lastCommand;
//				codigo += BR + "ceq";
//				codigo += BR + "or";
//				break;
//			}
			codigo += BR + "ceq";
			codigo += BR + "or";
			break;
		}
	}

	/**
	 * salva ultimo operador
	 * 
	 * @param lexeme
	 */
	private void action11(String lexeme) {
		operador = lexeme;
	}

	/**
	 * boolean true
	 */
	private void action12() {
		pilha.push(BOOLEAN);
		codigo += BR + "ldc.i4.1";
	}

	/**
	 * boolean false
	 */
	private void action13() {
		pilha.push(BOOLEAN);
		codigo += BR + "ldc.i4.0";
	}

	/**
	 * negação
	 * 
	 * @throws SemanticError
	 */
	private void action14() throws SemanticError {
		String type1 = pilha.pop();

		if (type1.equals(BOOLEAN)) {
			pilha.push(type1);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação NOT");
		}

		codigo += BR + "ldc.i4.1";
		codigo += BR + "xor";
	}

	/**
	 * Cabeçalho do programa
	 * 
	 * @param fileName
	 */
	private void action15(String fileName) {
		String header = ".assembly extern mscorlib {}\r\n" + ".assembly " + fileName + "{}\r\n" + ".module " + fileName
				+ ".exe\r\n\r\n" + ".class public _Principal{\r\n\r\n" + ".method static public void _principal()\r\n"
				+ " { .entrypoint";

		codigo += header;
	}

	/**
	 * fechamento de bloco
	 */
	private void action16() {
		codigo += BR + "ret";
		codigo += "\r\n }";
	}

	/**
	 * fechamento de programa
	 */
	private void action17() {
		codigo += "\r\n}";
		System.out.println(codigo);
		saveFile(codigo, Memory.getInstance().getLastFileName(), "il");
	}

	/**
	 * quebra
	 */
	private void action18() {
		pilha.push(STRING);
		codigo += BR + "ldstr \"\\n\"";
	}

	/**
	 * and
	 * 
	 * @throws SemanticError
	 */
	private void action19() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if (type1.equals(BOOLEAN) && type2.equals(BOOLEAN)) {
			pilha.push(BOOLEAN);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação lógica AND");
		}

		codigo += BR + "and";
	}

	/**
	 * ou
	 * 
	 * @throws SemanticError
	 */
	private void action20() throws SemanticError {
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if (type1.equals(BOOLEAN) && type2.equals(BOOLEAN)) {
			pilha.push(BOOLEAN);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação lógica OU");
		}

		codigo += BR + "or";
	}

	/**
	 * cte_caracter
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action21(String lexeme) throws SemanticError {
		pilha.push(STRING);

		codigo += BR + "ldstr " + lexeme;
	}

	public static void main(String[] args) throws SemanticError {
		testeAction1();
	}

	private void saveFile(String content, String nameFile, String extension) {
		File file = new File(nameFile + "." + extension);
	    BufferedWriter writer = null;
	    try {
	        writer = new BufferedWriter(new FileWriter(nameFile + "." + extension));
	        writer.write(content);
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", file.getAbsolutePath());
	}
	
	private static void testeAction1() throws SemanticError {
		Stack<String> pilha = new Stack();
		String codigo = "";
		// action 6 5
		pilha = new Stack();
		codigo = "";

		pilha.push(INTEGER);
		// pilha.push(BOOLEAN);
		codigo += BR + "ldc.i8 " + "1";

		pilha.push(FLOAT);
		codigo += BR + "ldc.r8 " + "1.0";
		// pilha.push(INTEGER);
		// codigo += BR + "ldc.i8 " + "1";

		System.out.println("\nactions 5 6");
		System.out.println("\ncodigo: " + codigo);
		System.out.println("\npilha: " + pilha);

		// action 1
		String type1 = pilha.pop();
		String type2 = pilha.pop();

		if ((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER))) {
			if (type1.equals(FLOAT) || type2.equals(FLOAT)) {
				pilha.push(FLOAT);
			} else {
				pilha.push(INTEGER);
			}
		} else {
			throw new SemanticError("Tipos incompatíveis em operação aritmética binária");
		}

		codigo += BR + "add";

		System.out.println("\nactions 1");
		System.out.println("\ncodigo: " + codigo);
		System.out.println("\npilha: " + pilha);
	}

}
