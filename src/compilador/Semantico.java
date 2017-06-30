package compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants {
	// TYPES
	private static final String FLOAT = "float64";
	private static final String INTEGER = "int64";
	private static final String STRING = "string";
	private static final String BOOLEAN = "bool";
	private static final String FUNCTION = "function";
	private static final String PROCEDURE = "procedure";

	private Map<String, Simbolo> tabelaSimbolos = new HashMap<String, Simbolo>();
	private Map<String, Simbolo> tabelaSimbolosLocal = new HashMap<String, Simbolo>(); // apenas
																						// para
																						// #37
																						// e
																						// #16
																						// funções
																						// e
																						// procedimentos
	private ArrayList<String> listaIdentificadores = new ArrayList<String>();
	private Stack<String> pilhaRotulos = new Stack<String>();
	private int countRotulo = 0;

	private static final String BR = "\r\n\t  ";
	// inicializar pilha de types
	Stack<String> pilha = new Stack();
	// inicializar codigo String
	private static String codigo = "";
	String operador;
	private String lastProcOrFun;
	private boolean thereWasAction39Before;
	// inicializar tabela de símbolos
	// private HashMap<String, TIPO> table;
	// enumeration TIPO

	public static String getCodigo() {
		return codigo;
	}

	public static void cleanCodigo() {
		codigo = "";
	}

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
			action3(token.getLexeme());
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
		case 22:
			// save tipo
			action22(token.getLexeme());
			break;
		case 23:
			// Armazena identificador
			action23(token.getLexeme());
			break;
		case 24:
			// Guarda ids na tabela de simbolos
			action24(token.getLexeme());
			break;
		case 25:
			// lista de identificadores
			action25(token.getLexeme());
			break;
		case 26:
			// lista de identificadores
			action26(token.getLexeme());
			break;
		case 27:
			// resultado expressão
			action27();
			break;
		case 28:
			// Seleção expressão
			action28();
			break;
		case 29:
			// Seleção fim
			action29();
			break;
		case 30:
			// Seleção senão
			action30();
			break;
		case 31:
			// Repetição repita
			action31();
			break;
		case 32:
			// Repetição expressão
			action32(token.getLexeme());
			break;
		case 33:
			action33(token.getLexeme());
			break;
		case 34:
			// Guarda id na tabela de simbolos
			action34(token.getLexeme());
			break;
		case 35:
			action35(token.getLexeme());
			break;
		case 36:
			action36();
			break;
		case 37:
			action37(token.getLexeme());
			break;
		case 38:
			action38();
			break;
		case 39:
			action39();
			break;
		case 40:
			action40(token.getLexeme());
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
			throw new SemanticError("Tipos incompatíveis em operação aritmética binária");
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
			throw new SemanticError("Tipos incompatíveis em operação aritmética binária");
		}

		codigo += BR + "sub";
	}

	/**
	 * mul
	 * 
	 * @throws SemanticError
	 */
	private void action3(String lexeme) throws SemanticError {
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

		for (int i = listaIdentificadores.size() - 1; i > 0; i--) {
			if (listaIdentificadores.get(i).equals(lexeme)) {
				System.out.println("removo");
				listaIdentificadores.remove(i);
			}
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

		if ((type1.equals(FLOAT) && type2.equals(INTEGER)) || (type2.equals(FLOAT) && type1.equals(INTEGER))) {
			pilha.push(FLOAT);
		} else if (type1.equals(INTEGER) && type2.equals(INTEGER)) {
			pilha.push(INTEGER);
		} else {
			throw new SemanticError("Tipos incompatíveis em operação aritmética binária");
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
			throw new SemanticError("Tipo incompatível em operação aritmética unária");
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

		if (((type1.equals(FLOAT) || type1.equals(INTEGER)) && (type2.equals(FLOAT) || type2.equals(INTEGER)))
				|| (type1.equals(STRING) && type2.equals(STRING))) {
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
			codigo += BR + "cgt";
			codigo += BR + "ldc.i4.0";
			codigo += BR + "ceq";
			break;
		case ">=":
			codigo += BR + "clt";
			codigo += BR + "ldc.i4.0";
			codigo += BR + "ceq";
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
			throw new SemanticError("Tipo incompatível em operação lógica unária");
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
				+ " { \r\n" + BR + ".entrypoint\r\n" + BR + ".locals(";

		codigo += header;
	}

	/**
	 * fechamento de bloco
	 */
	private void action16() {
		codigo += BR + "ret";
		codigo += "\r\n }";
		tabelaSimbolosLocal.clear(); // #37 tem que limpar pra ser reutilizada
										// para prox função / procedimento
		listaIdentificadores.clear();
	}

	/**
	 * fechamento de programa
	 */
	private void action17() {
		// limpar .locals vazios
		codigo = codigo.replaceAll(".localsdelete", "");

		codigo += "\r\n}";
		System.out.println(codigo);
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
			throw new SemanticError("Tipos incompatíveis em operação lógica binária");
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
			throw new SemanticError("Tipos incompatíveis em operação lógica binária ");
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

	/**
	 * save tipo
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action22(String lexeme) throws SemanticError {
		switch (lexeme) {
		case "inteiro":
			pilha.push(INTEGER);
			break;
		case "real":
			pilha.push(FLOAT);
			break;
		case "caracter":
			pilha.push(STRING);
			break;
		case "lógico":
			pilha.push(BOOLEAN);
			break;
		default:
			throw new SemanticError(
					"Tipos incompatíveis ao armazenar tipo, os tipos válidos são \"inteiro\", \"real\", \"caracter\" ou \"lógico\" ");
		}
	}

	/**
	 * Armazena identificador
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action23(String lexeme) throws SemanticError {
		if (lexeme.equalsIgnoreCase(Memory.getInstance().getLastFileName())) {
			throw new SemanticError(
					"Identificador não deve ser igual ao nome do programa " + Memory.getInstance().getLastFileName());
		}
		listaIdentificadores.add(0, lexeme);
		Simbolo simbolo = tabelaSimbolos.get(lexeme);
		if (simbolo != null && (simbolo.procedimento == true || simbolo.funcao == true)) {
			this.lastProcOrFun = lexeme;
		}
	}

	/**
	 * Guarda ids na tabela de simbolos
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action24(String lexeme) throws SemanticError {
		int count = 0;
		String lastItem = ",";
		String type1 = pilha.pop();
		for (String id : listaIdentificadores) {
			count++;
			if (tabelaSimbolosLocal.size() > 0) { // é dentro de função ou
													// procedimento
				if (tabelaSimbolosLocal.containsKey(id)) {
					throw new SemanticError("Identificador " + id + " já declarado");
				}
				tabelaSimbolosLocal.put(id, new Simbolo(type1));
			} else { // é dentro do principal
				if (tabelaSimbolos.containsKey(id)) {
					throw new SemanticError("Identificador " + id + " já declarado");
				}
				tabelaSimbolos.put(id, new Simbolo(type1));
			}
			codigo += type1 + " " + id + lastItem;
		}

		listaIdentificadores.clear();
	}

	/**
	 * lista de identificadores
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action25(String lexeme) throws SemanticError {
		for (String id : listaIdentificadores) {
			if (!tabelaSimbolos.containsKey(id)) {
				throw new SemanticError("Identificador " + id + " não declarado");
			}
			System.out.println("simbolo 25: " + tabelaSimbolos.get(id));
			// ignorar função e procedimento
			if (tabelaSimbolos.get(id).procedimento != true && tabelaSimbolos.get(id).funcao != true) {
				System.out.println("simbolo 25 entrou " + tabelaSimbolos.get(id));
				String type1 = tabelaSimbolos.get(id).tipo;
				codigo += BR + "call string [mscorlib]System.Console::ReadLine()";
				if (type1.equals(INTEGER)) {
					codigo += BR + "call int64 [mscorlib]System.Int64::Parse(string)";
				} else if (type1.equals(FLOAT)) {
					codigo += BR + "call float64 [mscorlib]System.Double::Parse(string)";
				}

				codigo += BR + "stloc " + id;
			}
		}

		listaIdentificadores.clear();
	}

	/**
	 * lista de identificadores
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action26(String lexeme) throws SemanticError {
		String type1;

		if (tabelaSimbolosLocal.size() > 0) { // se estiver dentro do escopo da
												// função ou procedimento
			if (!tabelaSimbolosLocal.containsKey(lexeme)) {
				throw new SemanticError("Identificador " + lexeme + " não declarado");
			}

			type1 = tabelaSimbolosLocal.get(lexeme).tipo;
			pilha.push(type1);
			codigo += BR + "ldarg " + lexeme;
		} else { // senão é dentro do principal
			if (!tabelaSimbolos.containsKey(lexeme)) {
				throw new SemanticError("Identificador " + lexeme + " não declarado");
			}

			type1 = tabelaSimbolos.get(lexeme).tipo;
			pilha.push(type1);
			codigo += BR + "ldloc " + lexeme;
		}
	}

	/**
	 * resultado expressão
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action27() throws SemanticError {
		for (int i = 0; i < listaIdentificadores.size(); i++) {
			System.out.println("id " + i + ":" + listaIdentificadores.get(i));
		}
		String id = listaIdentificadores.get(listaIdentificadores.size() - 1);
		if (!tabelaSimbolos.containsKey(id)) {
			throw new SemanticError("Identificador " + id + " não declarado");
		}

		// expressão
		String type1 = pilha.pop();
		// id
		String type2 = tabelaSimbolos.get(id).tipo;
		if (type1 != type2) {
			throw new SemanticError("Tipos incompatíveis em atribuição, recebido " + type1 + ", esperado " + type2);
		}
		codigo += BR + "stloc " + id;
		listaIdentificadores.clear();
	}

	/**
	 * Guarda ids chamada procedimento na tabela de simbolos
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action38() throws SemanticError {
		System.out.println("38: " + this.lastProcOrFun);
		String nomeProcedimento = this.lastProcOrFun;
		this.lastProcOrFun = null;
		Simbolo simboloProcedimento = tabelaSimbolos.get(nomeProcedimento);

		int count = 0;
		String lastItem = ",";
		codigo += BR + "call void _Principal::_" + nomeProcedimento + "(";
		for (String id : listaIdentificadores) {
			count++;
			if (!tabelaSimbolos.containsKey(id)) {
				throw new SemanticError("Identificador " + id + " não declarado");
			}

			if (listaIdentificadores.size() == count) {
				lastItem = ")";
			}

			String type1 = tabelaSimbolos.get(id).tipo;
			if(type1 == null) type1 = ""; // evitar null -> call void _Principal::_Nome(null)
			codigo += type1 + lastItem; // só tipo separado por virgula, sem id
		}
	}

	/**
	 * Guarda ids chamada função na tabela de simbolos
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action39() throws SemanticError {
		System.out.println("39: " + this.lastProcOrFun);
		String nomeFuncao = this.lastProcOrFun;
		Simbolo simboloFuncao = tabelaSimbolos.get(nomeFuncao);
		this.lastProcOrFun = null;
		int qtdParametros = simboloFuncao.parametros.size();
		String lastItem = ",";
		codigo += BR + "call " + simboloFuncao.tipo + " _Principal::_" + nomeFuncao + "(";
		for (int i = listaIdentificadores.size() - 1; i > qtdParametros; i--) {
			String id = listaIdentificadores.get(i);
			if (!tabelaSimbolos.containsKey(id)) {
				throw new SemanticError("Identificador " + id + " não declarado");
			}
			
			if ( (i-1) == qtdParametros) {
				lastItem = ")";
			}
			
			String type1 = tabelaSimbolos.get(id).tipo;
			codigo += type1 + lastItem; // só tipo separado por virgula, sem id
		}
	}

	/**
	 * Remover ultima , por ) no fechamento do .locals das variaveis
	 * 
	 * @throws SemanticError
	 */
	private void action40(String lexeme) throws SemanticError {
		char myChar = codigo.charAt(codigo.length() - 1);
		System.out.println("charAt " + myChar);
		if (myChar == ',') { //.locals procedimento
			codigo = codigo.substring(0, codigo.length() - 1);
			codigo += ")";
		} else if (myChar == 'F'){ //funcao
			codigo = codigo.substring(0, codigo.length() - 2);
			codigo += ") \n\r{";			
		} else {
			codigo = codigo.substring(0, codigo.length() - 1);
			codigo += "delete";
		}
	}

	/**
	 * Seleção se expressão
	 * 
	 * @throws compilador.SemanticError
	 */
	private void action28() throws compilador.SemanticError {
		String type1 = pilha.pop();
		if (!type1.equalsIgnoreCase(BOOLEAN)) {
			throw new SemanticError(
					"Tipo incompativel para comando de selação, esperado boleano, encontrado " + getTipo(type1));
		}
		String labelElse = "r" + countRotulo;
		countRotulo++;
		pilhaRotulos.push(labelElse);
		codigo += BR + "brfalse " + labelElse;
	}

	/**
	 * Seleção fim
	 */
	private void action29() {
		codigo += BR + pilhaRotulos.pop() + ":";
	}

	/**
	 * Seleção senão
	 */
	private void action30() {
		String rotuloElse = pilhaRotulos.pop();
		String labelSaida = "r" + countRotulo;
		countRotulo++;
		pilhaRotulos.push(labelSaida);

		codigo += BR + "br " + labelSaida;
		codigo += BR + rotuloElse + ":";
		// String rotulo = "r" + countRotulo++;
		// codigo += BR + rotulo + ":";
		// pilhaRotulos.push(rotulo);
	}

	/**
	 * Repetição repita
	 */
	private void action31() {
		String rotulo = "r";
		countRotulo++;
		codigo += BR + rotulo + ":";
		pilhaRotulos.push(rotulo);
	}

	/**
	 * Repetição até
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action32(String lexeme) throws SemanticError {
		String type1 = pilha.pop();
		if (!type1.equals(BOOLEAN)) {
			throw new SemanticError(
					"Tipo incompativel para comando de repetição, esperado lógico, encontrado " + getTipo(type1));
		}
		codigo += BR + "brfalse " + pilhaRotulos.pop();
	}

	/**
	 * incluir ids função e procedimento
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action33(String lexeme) throws SemanticError {
		if (tabelaSimbolos.containsKey(lexeme)) {
			throw new SemanticError("Identificador " + lexeme + " já declarado");
		}

		listaIdentificadores.add(0, lexeme); // guardar pra funcão 34/35
		tabelaSimbolos.put(lexeme, new Simbolo());
	}

	/**
	 * Guarda tipo função na tabela de simbolos
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action34(String lexeme) throws SemanticError {
		String funcaoTipoRetorno = pilha.pop(); // pega tipo armazenado pela
												// acão 22
		// ultimo da lista de ids que é pra ser a função
		String id = listaIdentificadores.get(listaIdentificadores.size() - 1);
		Simbolo simboloFuncao = tabelaSimbolos.get(id);
		simboloFuncao.funcao = true;
		simboloFuncao.tipo = funcaoTipoRetorno;

		System.out.println("#34 " + simboloFuncao.toString());
		listaIdentificadores.clear();
	}

	/**
	 * Guarda procedimento na tabela de simbolos
	 * 
	 * @param lexeme
	 * @throws SemanticError
	 */
	private void action35(String lexeme) throws SemanticError {
		// pega ultimo id que deve ser procedimento
		String id = listaIdentificadores.get(listaIdentificadores.size() - 1);
		Simbolo simboloProcedimento = tabelaSimbolos.get(id);
		simboloProcedimento.procedimento = true;

		System.out.println("#35 " + simboloProcedimento.toString());
		listaIdentificadores.clear();
	}

	/**
	 * Guarda ids das funções na tabela de simbolos
	 * 
	 * @throws SemanticError
	 */
	private void action36() throws SemanticError {
		// pega ultimo id que deve ser função
		String idFuncao = listaIdentificadores.get(listaIdentificadores.size() - 1);
		listaIdentificadores.remove(listaIdentificadores.size() - 1);

		Simbolo simboloFuncao = tabelaSimbolos.get(idFuncao);

		String type1 = pilha.pop();
		for (String id : listaIdentificadores) {
			if (tabelaSimbolos.containsKey(id)) {
				throw new SemanticError("Identificador " + id + " já declarado");
			}
			simboloFuncao.parametros.add(new Parametro(id, type1)); // add
																	// parametros
																	// da função
		}

		System.out.println("simboloFuncao items ");
		for (int i = 0; i < simboloFuncao.parametros.size(); i++) {
			System.out.println(i + " - id :" + simboloFuncao.parametros.get(i).id);
			System.out.println(i + " - tipo :" + simboloFuncao.parametros.get(i).tipo);
		}

		listaIdentificadores.clear();
		listaIdentificadores.add(0, idFuncao);// add idFunção de volta pra lista
												// de ids para ser acessada na
												// action 34
	}

	/**
	 * monta procedimento/função com base na declaração
	 * 
	 * @param lexeme
	 *            (sempre função/procedimento)
	 * @throws SemanticError
	 */
	private void action37(String lexeme) throws SemanticError {
		Simbolo simbolo = tabelaSimbolos.get(lexeme);
		String cabecalho = "";

		if (simbolo.funcao == true) {
			cabecalho = ".method public static " + simbolo.tipo + " _" + lexeme + "(";
		} else if (simbolo.procedimento == true) {
			cabecalho = ".method public static void _" + lexeme + "()" + " { \n\r .locals(";
		}

		String lastItem = ",";
		codigo += BR + cabecalho;
		for (int i = 0; i < simbolo.parametros.size(); i++) {
			Parametro parametro = simbolo.parametros.get(i);
			if (tabelaSimbolosLocal.containsKey(parametro.id)) {
				throw new SemanticError(
						"Identificador " + parametro.id + " já declarado na função ou procedimento " + lexeme);
			}
			System.out.println("asd" + parametro.id);
			tabelaSimbolosLocal.put(parametro.id, new Simbolo(parametro.tipo));
			if ((simbolo.parametros.size()) == i) {
				lastItem = ")";
			}
			codigo += parametro.tipo + " " + parametro.id + lastItem;
		}
		
		if(simbolo.funcao == true) {
			codigo += "F"; //funcao 
		}
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

	private String getTipo(String tipo) {
		switch (tipo) {
		case INTEGER:
			return "inteiro";
		case FLOAT:
			return "real";
		case STRING:
			return "caracter";
		case BOOLEAN:
			return "lógico";
		}
		return tipo;
	}
}
