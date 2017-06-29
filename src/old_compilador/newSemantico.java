package old_compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import br.com.furb.enumeracao.ETipo;
import br.com.furb.semantico.SemanticError;

public class newSemantico {

	private String fileName;

	private Stack<String> pilha = new Stack();
	private String codigo = "";

	private String relacional = "";

	private HashMap<String, ItemTabelaSimbolo> tabelaSimbolos;
	private HashMap<String, ItemTabelaSimbolo> tabelaSimbolosPrincipal;

	private ArrayList<String> lista = new ArrayList<>();
	private int indiceRotulo = 0;
	private Stack<String> pilhaRotulo = new Stack();
	private Stack<Integer> pilhaCount = new Stack();

	private ItemTabelaSimbolo tempItemTabelaSimbolo = null;

	private int idFim = -1;

	public Semantico(String fileName) {;
        this.fileName = fileName;
        tabelaSimbolos = new HashMap<>();
        tabelaSimbolosPrincipal = tabelaSimbolos;
    }
	//
	// Semantico() {
	// throw new UnsupportedOperationException("Not supported yet."); //To
	// change body of generated methods, choose Tools | Templates.
	// }

	public void executeAction(int action, Token token) throws SemanticError {
		switch (action) {

		case 1:
			System.out.println("1");
			this.action1(token);
			break;
		case 2:
			System.out.println("2");
			this.action2(token);
			break;
		case 3:
			System.out.println("3");
			this.action3(token);
			break;
		case 4:
			System.out.println("4");
			this.action4(token);
			break;
		case 5:
			System.out.println("5");
			this.action5(token);
			break;
		case 6:
			System.out.println("6");
			this.action6(token);
			break;
		case 7:
			System.out.println("7");
			this.action7(token);
			break;
		case 8:
			System.out.println("8");
			this.action8(token);
			break;
		case 9:
			System.out.println("9");
			this.action9(token);
			break;
		case 10:
			System.out.println("10");
			this.action10(token);
			break;
		case 11:
			System.out.println("11");
			this.action11(token);
			break;
		case 12:
			System.out.println("12");
			this.action12();
			break;
		case 13:
			System.out.println("13");
			this.action13();
			break;
		case 14:
			System.out.println("14");
			this.action14(token);
			break;
		case 15:
			System.out.println("15");
			this.action15();
			break;
		case 16:
			System.out.println("16");
			this.action16();
			break;
		case 17:
			System.out.println("17");
			this.action17();
			break;
		case 18:
			System.out.println("18");
			this.action18(token);
			break;
		case 19:
			System.out.println("19");
			this.action19(token);
			break;
		case 20:
			System.out.println("20");
			this.action20(token);
			break;
		case 21:
			System.out.println("21");
			this.action21(token);
			break;
		case 22:
			System.out.println("22");
			this.action22(token);
			break;
		case 23:
			System.out.println("23");
			this.action23(token);
			break;
		case 24:
			System.out.println("24");
			this.action24(token);
			break;
		case 25:
			System.out.println("25");
			this.action25(token);
			break;
		case 26:
			System.out.println("26");
			this.action26(token);
			break;
		case 27:
			System.out.println("27");
			this.action27(token);
			break;
		case 28:
			System.out.println("28");
			this.action28(token);
			break;
		case 29:
			System.out.println("29");
			this.action29(token);
			break;
		case 30:
			System.out.println("30");
			this.action30(token);
			break;
		case 31:
			System.out.println("31");
			this.action31(token);
			break;
		case 32:
			System.out.println("32");
			this.action32(token);
			break;
		case 33:
			System.out.println("33");
			this.action33(token);
			break;
		case 34:
			System.out.println("34");
			this.action34(token);
			break;
		case 35:
			System.out.println("35");
			this.action35(token);
			break;
		case 36:
			System.out.println("36");
			this.action36(token);
			break;
		case 37:
			System.out.println("37");
			this.action37(token);
			break;
		case 38:
			System.out.println("38");
			this.action38(token);
			break;
		default:
			throw new SemanticError("Ação não definida", token);
		}
	}

	private void action1(Token token) throws SemanticError {
		String tipo1 = pilha.pop(), tipo2 = pilha.pop();
		if (tipo1.equals(tipo2) && !tipo1.equals("bool") && !tipo1.equals("string")) {
			codigo += "\n\t\tadd";
			pilha.push(tipo1);
		} else if ((tipo1.equals("float64") && tipo2.equals("int64"))
				|| (tipo2.equals("float64") && tipo1.equals("int64"))) {
			pilha.push("float64");
			codigo += "\n\t\tadd";

		} else {
			throw new SemanticError("Tipos incompatíveis em operação de soma", token);
		}
	}

	private void action2(Token token) throws SemanticError {
		String tipo1 = pilha.pop(), tipo2 = pilha.pop();
		if (tipo1.equals(tipo2) && !tipo1.equals("bool") && !tipo1.equals("string")) {
			codigo += "\n\t\tsub";
			pilha.push(tipo1);
		} else if ((tipo1.equals("float64") && tipo2.equals("int64"))
				|| (tipo2.equals("float64") && tipo1.equals("int64"))) {
			codigo += "\n\t\tsub";
			pilha.push("float64");
		} else {
			throw new SemanticError("Tipos incompatíveis em operação de subtração", token);
		}
	}

	private void action3(Token token) throws SemanticError {
		String tipo1 = pilha.pop(), tipo2 = pilha.pop();
		if (tipo1.equals(tipo2) && !tipo1.equals("bool") && !tipo1.equals("string")) {
			codigo += "\n\t\tmul";
			pilha.push(tipo1);
		} else if ((tipo1.equals("float64") && tipo2.equals("int64"))
				|| (tipo2.equals("float64") && tipo1.equals("int64"))) {
			codigo += "\n\t\tmul";
			pilha.push("float64");
		} else {
			throw new SemanticError("Tipos incompatíveis na multiplicação", token);
		}
	}

	private void action4(Token token) throws SemanticError {
		String tipo1 = pilha.pop(), tipo2 = pilha.pop();
		if (tipo1.equals(tipo2) && !tipo1.equals("bool") && !tipo1.equals("string")) {
			codigo += "\n\t\tdiv";
			if (tipo1.equals("int64")) {
				pilha.push("float64");
			} else {
				pilha.push(tipo1);
			}
		} else if ((tipo1.equals("float64") && tipo2.equals("int64"))
				|| (tipo2.equals("float64") && tipo1.equals("int64"))) {
			codigo += "\n\t\tdiv";
			pilha.push("float64");
		} else {
			throw new SemanticError("Tipos incompatíveis na divisão", token);
		}
	}

	private void action5(Token token) {
		codigo += "\n\t\tldc.i8 " + token.getLexeme();
		pilha.push("int64");
	}

	private void action6(Token token) {
		codigo += "\n\t\tldc.r8 " + token.getLexeme();
		pilha.push("float64");
	}

	private void action7(Token token) {
		String tipo = pilha.pop();
		codigo += "\n\t\tcall void [mscorlib]System.Console::Write(" + tipo + ")";
	}

	private void action8(Token token) throws SemanticError {
		String tipo1 = pilha.pop();
		if (tipo1.equals("int64") || tipo1.equals("float64")) {
			pilha.push(tipo1);
		} else {
			throw new SemanticError("Sinal unário incompatível com este tipo", token);
		}
	}

	private void action9(Token token) throws SemanticError {
		String tipo1 = pilha.pop();
		if (tipo1.equals("int64") || tipo1.equals("float64")) {
			codigo += "\n\t\tldc.i8 -1";
			codigo += "\n\t\tmul";
			pilha.push(tipo1);
		} else {
			throw new SemanticError("Sinal unário incompatível com este tipo", token);
		}
	}

	private void action10(Token token) throws SemanticError {
		String tipo1 = pilha.pop(), tipo2 = pilha.pop();
		System.out.println(tipo1);
		System.out.println(tipo2);
		if (tipo1.equals(tipo2) || ((tipo1.equals("float64") && tipo2.equals("int64"))
				|| (tipo2.equals("float64") && tipo1.equals("int64")))) {
			if (!relacional.equals("==") && (tipo1.equals("bool") || tipo1.equals("string"))) {
				throw new SemanticError("Comparação entre tipos incompatíveis", token);
			}
			switch (relacional) {
			case "==":
				if (tipo1.equals("string")) {
					codigo += "\n\t\tcall int32 [mscorlib]System.String::Compare(string, string)";
					codigo += "\n\t\tldc.i4 0";
				}
				codigo += "\n\t\tceq";
				break;
			case "<>":
				codigo += "\n\t\tceq";
				codigo += "\n\t\tnot";
				break;
			case "<":
				codigo += "\n\t\tclt";
				break;
			case "<=":
				codigo += "\n\t\tcgt";
				codigo += "\n\t\tnot";
				break;
			case ">":
				codigo += "\n\t\tcgt";
				break;
			case ">=":
				codigo += "\n\t\tclt";
				codigo += "\n\t\tnot";
				break;
			}
			relacional = "";
			pilha.push("bool");
		} else {
			throw new SemanticError("Comparação entre tipos incompatíveis", token);
		}
	}

	private void action11(Token token) {
		relacional = token.getLexeme();
	}

	private void action12() {
		this.pilha.push("bool");
		this.codigo += "\n\t\tldc.i4.1";
	}

	private void action13() {
		this.pilha.push("bool");
		this.codigo += "\n\t\tldc.i4.0";
	}

	private void action14(Token token) throws SemanticError {
		String tipo = this.pilha.pop();
		if (!tipo.equals("bool")) {
			throw new SemanticError("Tipo incompatível no operador 'não'", token);
		}
		this.pilha.push("bool");
		this.codigo += "\n\t\tldc.i4.1" + "\n\t\txor";
	}

	private void action15() {
		this.codigo += ".assembly extern mscorlib {}\n" + ".assembly " + this.fileName + " {}\n" + ".module "
				+ this.fileName + ".exe\n" + ".class public " + this.fileName + "{" + ".class public _Principal{\n"
				+ ".method static public void _principal() " + "{ .entrypoint";
	}

	private void action16() {
		this.codigo += "ret\n" + "}\n";
	}

	private void action17() {
		this.codigo += "\n\t\tret\n" + "\t}\n" + "}";
	}

	private void action18(Token token) {
		this.pilha.push("string");
		this.codigo += "\n";
	}

	private void action19(Token token) throws SemanticError {
		String tipo1 = this.pilha.pop();
		String tipo2 = this.pilha.pop();
		if (!tipo1.equals("bool") || !tipo2.equals("bool")) {
			throw new SemanticError("Tipo incompatível no operador 'e'", token);
		}
		this.pilha.push("bool");
		this.codigo += "\n\t\tand";
	}

	private void action20(Token token) throws SemanticError {
		String tipo1 = this.pilha.pop();
		String tipo2 = this.pilha.pop();
		if (!tipo1.equals("bool") || !tipo2.equals("bool")) {
			throw new SemanticError("Tipo incompatível no operador 'ou'", token);
		}
		this.pilha.push("bool");
		this.codigo += "\n\t\tor";
	}

	private void action21(Token token) {
		this.pilha.push("string");
		this.codigo += "\n\t\tldstr " + token.getLexeme();
	}

	private void action22(Token token) throws SemanticError {
		switch (token.getLexeme()) {
		case "inteiro":
			pilha.push("int64");
			break;
		case "real":
			pilha.push("float64");
			break;
		case "string":
			pilha.push("string");
			break;
		case "boolean":
			pilha.push("bool");
			break;
		default:
			throw new SemanticError("ERRO SEMÂNTICO, tipo inválido.");

		}
	}

	private void action23(Token token) {
		this.lista.add(token.getLexeme());

	}

	private void action24(Token token) throws SemanticError {
		String tipo = "";
		switch (token.getLexeme()) {

		case "inteiro":
			tipo = "int64";
		case "real":
			tipo = "float64";

			for (Iterator<String> iterator = lista.iterator(); iterator.hasNext();) {
				if (tabelaSimbolos.containsKey(iterator.next())) {
					throw new SemanticError("ERRO SEMÂNTICO, id já declarado", token);
				}
				ItemTabelaSimbolo item = new ItemTabelaSimbolo(tipo, true);
				tabelaSimbolos.put(tipo, item);
				this.codigo += "\n\t\t.locals(" + tipo + " " + token.getLexeme() + ")";
			}

			lista.clear();

		}

	}

	private void action25(Token token) throws SemanticError {
		for (Iterator<String> iterator = lista.iterator(); iterator.hasNext();) {
			if (!tabelaSimbolos.containsKey(token.getLexeme())) {
				throw new SemanticError("ERRO SEMÂNTICO, id não declarado", token);
			}
			ItemTabelaSimbolo item = tabelaSimbolos.get(token.getLexeme());
			String tipo = item.getTipo();
			this.codigo += "\n\t\tcall string [mscorlib]System.Console::Readline()";
			switch (tipo) {
			case "int64":
				this.codigo += "call int64 [mscorlib]System.Int64::Parse(string)";
			case "float64":
				this.codigo += "call int64 [mscorlib]System.Double::Parse(string)";
			}
		}
		codigo += "\n\t\tstloc " + token.getLexeme();
		this.lista.clear();
	}

	private void action26(Token token) throws SemanticError {
		String id = token.getLexeme();
		if (!tabelaSimbolos.containsKey(id)) {
			throw new SemanticError("ERRO SEMÂNTICO, id não declarado", token);
		}
		codigo += "\n\t\tstloc " + token.getLexeme();
	}

	private void action27(Token token) throws SemanticError {
		String id = this.lista.remove(lista.size() - 1);
		if (!tabelaSimbolos.containsKey(id)) {
			throw new SemanticError("ERRO SEMÂNTICO, id não declarado", token);
		}
		String tipo_id = tabelaSimbolos.get(id).getTipo();
		String tipo_exp = pilha.pop();
		if (tipo_id != tipo_exp) {
			throw new SemanticError("ERRO SEMÂNTICO, tipos incompatíveis em atribuição", token);
		}
		codigo += "\n\t\tstloc " + token.getLexeme();
		

	}

	private void action28(Token token) {
		this.codigo += "\n\t\t" + this.pilhaRotulo.pop() + ":";
	}

	private void action29(Token token) {
		String rotulo = "r" + this.indiceRotulo++;
		this.codigo += "\n\t\tbr " + rotulo;
		this.codigo += "\n\t\t" + this.pilhaRotulo.pop() + ":";
		this.pilhaRotulo.push(rotulo);
	}

	private void action30(Token token) {
		String rotulo = "r" + this.indiceRotulo++;
		this.codigo += "\n\t\t" + rotulo + ":";
		this.pilhaRotulo.push(rotulo);
	}

	private void action31(Token token) {
		this.codigo += "\n\t\tbrfalse " + this.pilhaRotulo.pop();
	}

	private void action32(Token token) throws SemanticError {
		String lex = this.lista.remove(lista.size() - 1);
		System.out.println(lex);
		ItemTabelaSimbolo item = this.tabelaSimbolos.get(lex);
		if (item != null) {
			if (item.isVar()) {
				if (item.isArg()) {
					this.codigo += "\n\t\tldarg " + lex;
				} else {
					this.codigo += "\n\t\tldloc " + lex;
				}
				this.pilha.add(item.getTipo());
			} else {
				throw new SemanticError("Identificador (" + lex + ") não pode ser uma função", token);
			}
		} else {
			throw new SemanticError("Identificador (" + lex + ") não declarado", token);
		}
	}

	private void action33(Token token) {
		this.lista.add(token.getLexeme());
	}

	private void action34(Token token) {
		String tipo = "";
		switch (token.getLexeme()) {

		case "inteiro":
			tipo = "int64";
		case "real":
			tipo = "float64";
		case "string":
			tipo = "string";
		case "boolean":
			tipo = "bool";

			ItemTabelaSimbolo item = new ItemTabelaSimbolo(tipo, true);
			tabelaSimbolos.put(tipo, item);

			lista.clear();

		}
	}

	private void action35(Token token) {
	}

	private void action36(Token token) {
	}

	private void action37(Token token) {
	}

	private void action38(Token token) {
	}

	public String getCodigo() {
		return this.codigo;
	}

}
