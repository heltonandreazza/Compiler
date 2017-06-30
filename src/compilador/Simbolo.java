package compilador;

import java.util.ArrayList;

public class Simbolo {
	public String tipo;
	public boolean funcao;
	public boolean procedimento;
	public ArrayList<Parametro> parametros;

	Simbolo() {
		this.parametros = new ArrayList<Parametro>();
	};

	Simbolo(String tipo) {
		this.tipo = tipo;
		this.parametros = new ArrayList<Parametro>();
	}

	@Override
	public String toString() {
		return "\nSimbolo [tipo=" + tipo + ", funcao=" + funcao + ", procedimento=" + procedimento + ", parametros="
				+ parametros + "]";
	}
}
