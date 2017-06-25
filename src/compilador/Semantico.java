package compilador;

import java.util.Stack;

import javax.sound.midi.Soundbank;

import compilador.Token;

public class Semantico implements Constants {
	// TYPES
	private static final String FLOAT = "float64";
	private static final String INTEGER = "int64";
	private static final String STRING = "string";
	private static final String BOOLEAN = "bool";

	private static final String BR = "\n";
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
			// add
			action1();
			break;
		case 2:
			// sub
			action2();
			break;
		case 3:
			// mul
			action3();
			break;
		case 4:
			// div
			action4();
			break;
		case 5:
			// cte_inteira
			action5(token.getLexeme());
			break;
		case 6:
			// cte_real
			action6(token.getLexeme());
			break;
		case 7:
			// write
			action7();
			break;
		case 8:
			// soma unária
			action8();
			break;
		case 9:
			// subtração unária
			action9();
			break;
		case 10:
			// relacional
			action10();
			break;
		case 11:
			// salva ultimo operador para usar no relacional action10
			action11(token.getLexeme());
			break;
		case 12:
			// boolean true
			action12();
			break;
		case 13:
			// boolean false
			action13();
			break;
		case 14:
			// negação
			action14();
			break;
		case 15:
			// Cabeçalho do programa
			action15(Memory.getInstance().getLastFileName());
			break;
		case 16:
			// fechamento de bloco
			action16();
			break;
		case 17:
			// fechamento de programa
			action17();
			break;
		case 18:
			// quebra
			action18();
			break;
		case 19:
			// and
			action19();
			break;
		case 20:
			// ou
			action20();
			break;
		case 21:
			// cte_caracter
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
			codigo += BR + "ceq";
			codigo += BR + "or";
			break;
		case ">=":
			codigo += BR + "cgt";
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
		String header = ".assembly extern mscorlib {}\n" + ".assembly " + fileName + "{}\n" + ".module " + fileName
				+ ".exe\n\n" + ".class public _Principal{\n\n" + ".method static public void _principal()\n"
				+ "{ .entrypoint";

		codigo += BR + header;
	}

	/**
	 * fechamento de bloco
	 */
	private void action16() {
		codigo += BR + "ret";
		codigo += BR + "}";
	}

	/**
	 * fechamento de programa
	 */
	private void action17() {
		codigo += BR + "}";
	}

	/**
	 * quebra
	 */
	private void action18() {
		pilha.push(STRING);
		codigo += BR + "ldstr\n\"\\n\"";
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
