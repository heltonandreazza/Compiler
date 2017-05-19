/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old_compilador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rafael
 */
public class Interface extends javax.swing.JFrame {

	/**
	 * Creates new form Interface
	 */
	public Interface() {
		initComponents();
		pad = " ";
		loadedFile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		loadedFile.setFileFilter(filter);
		areaMensagens.setText("");
		editorTexto.setText("");
		initialLength = editorTexto.getText().length();
		jLabel1.setText("n�o modificado");
		jLabel2.setText("");
		setIcones();
		iniciaEditor();
		setAtalhos();
	}

	private String pad;
	private JFileChooser loadedFile;
	private int initialLength;

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jBarraFerramentas = new javax.swing.JPanel();
		btnCompilar = new javax.swing.JButton();
		btnRecortar = new javax.swing.JButton();
		btnColar = new javax.swing.JButton();
		btnCopiar = new javax.swing.JButton();
		btnSalvar = new javax.swing.JButton();
		btnAbrir = new javax.swing.JButton();
		btnNovo = new javax.swing.JButton();
		btnGerarCodigo = new javax.swing.JButton();
		btnEquipe = new javax.swing.JButton();
		jBarraStatus = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		cScrollEditor = new javax.swing.JScrollPane();
		editorTexto = new javax.swing.JTextArea();
		cScrollMensagens = new javax.swing.JScrollPane();
		areaMensagens = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Compilador");
		setMinimumSize(new java.awt.Dimension(900, 632));
		setSize(new java.awt.Dimension(900, 620));

		jBarraFerramentas.setMinimumSize(new java.awt.Dimension(144, 544));
		jBarraFerramentas.setPreferredSize(new java.awt.Dimension(144, 544));

		btnCompilar.setText("compilar [F8]");
		btnCompilar.setMaximumSize(new java.awt.Dimension(144, 61));
		btnCompilar.setMinimumSize(new java.awt.Dimension(144, 60));
		btnCompilar.setPreferredSize(new java.awt.Dimension(144, 61));
		btnCompilar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCompilarActionPerformed(evt);
			}
		});

		btnRecortar.setText("recortar [ctrl-x]");
		btnRecortar.setMaximumSize(new java.awt.Dimension(144, 61));
		btnRecortar.setMinimumSize(new java.awt.Dimension(144, 60));
		btnRecortar.setPreferredSize(new java.awt.Dimension(144, 61));
		btnRecortar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRecortarActionPerformed(evt);
			}
		});

		btnColar.setText("colar [ctrl-v]");
		btnColar.setMaximumSize(new java.awt.Dimension(144, 61));
		btnColar.setMinimumSize(new java.awt.Dimension(144, 60));
		btnColar.setPreferredSize(new java.awt.Dimension(144, 61));
		btnColar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnColarActionPerformed(evt);
			}
		});

		btnCopiar.setText("copiar [ctrl-c]");
		btnCopiar.setMaximumSize(new java.awt.Dimension(144, 61));
		btnCopiar.setMinimumSize(new java.awt.Dimension(144, 60));
		btnCopiar.setPreferredSize(new java.awt.Dimension(144, 61));
		btnCopiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCopiarActionPerformed(evt);
			}
		});

		btnSalvar.setText("salvar [ctrl-s]");
		btnSalvar.setMaximumSize(new java.awt.Dimension(144, 61));
		btnSalvar.setMinimumSize(new java.awt.Dimension(144, 60));
		btnSalvar.setPreferredSize(new java.awt.Dimension(144, 61));
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		btnAbrir.setText("abrir [ctrl-o]");
		btnAbrir.setMaximumSize(new java.awt.Dimension(144, 61));
		btnAbrir.setMinimumSize(new java.awt.Dimension(144, 60));
		btnAbrir.setPreferredSize(new java.awt.Dimension(144, 61));
		btnAbrir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAbrirActionPerformed(evt);
			}
		});

		btnNovo.setText("novo [ctrl-n]");
		btnNovo.setMaximumSize(new java.awt.Dimension(144, 60));
		btnNovo.setMinimumSize(new java.awt.Dimension(144, 60));
		btnNovo.setPreferredSize(new java.awt.Dimension(144, 61));
		btnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNovoActionPerformed(evt);
			}
		});

		btnGerarCodigo.setText("gerar c�digo [F9]");
		btnGerarCodigo.setMaximumSize(new java.awt.Dimension(144, 60));
		btnGerarCodigo.setMinimumSize(new java.awt.Dimension(144, 61));
		btnGerarCodigo.setPreferredSize(new java.awt.Dimension(144, 60));
		btnGerarCodigo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGerarCodigoActionPerformed(evt);
			}
		});

		btnEquipe.setText("equipe [F1]");
		btnEquipe.setMaximumSize(new java.awt.Dimension(144, 61));
		btnEquipe.setMinimumSize(new java.awt.Dimension(144, 60));
		btnEquipe.setPreferredSize(new java.awt.Dimension(144, 60));
		btnEquipe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEquipeActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jBarraFerramentasLayout = new javax.swing.GroupLayout(jBarraFerramentas);
		jBarraFerramentas.setLayout(jBarraFerramentasLayout);
		jBarraFerramentasLayout.setHorizontalGroup(
				jBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnColar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRecortar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGerarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEquipe, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
		jBarraFerramentasLayout
				.setVerticalGroup(jBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jBarraFerramentasLayout.createSequentialGroup()
								.addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnColar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnRecortar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(btnGerarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0).addComponent(btnEquipe, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		jBarraStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jBarraStatus.setMinimumSize(new java.awt.Dimension(900, 25));
		jBarraStatus.setPreferredSize(new java.awt.Dimension(900, 25));

		jLabel1.setText("jLabel1");

		jLabel2.setText("jLabel2");

		javax.swing.GroupLayout jBarraStatusLayout = new javax.swing.GroupLayout(jBarraStatus);
		jBarraStatus.setLayout(jBarraStatusLayout);
		jBarraStatusLayout
				.setHorizontalGroup(jBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jBarraStatusLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
								.addGap(69, 69, 69).addComponent(jLabel2).addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jBarraStatusLayout
				.setVerticalGroup(jBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jBarraStatusLayout.createSequentialGroup().addGap(0, 7, Short.MAX_VALUE)
										.addGroup(jBarraStatusLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1).addComponent(jLabel2))));

		cScrollEditor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cScrollEditor.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		cScrollEditor.setMinimumSize(new java.awt.Dimension(742, 480));
		cScrollEditor.setPreferredSize(new java.awt.Dimension(742, 480));

		editorTexto.setColumns(100);
		editorTexto.setRows(5);
		editorTexto.setToolTipText("");
		editorTexto.setMinimumSize(new java.awt.Dimension(4, 4));
		cScrollEditor.setViewportView(editorTexto);

		cScrollMensagens.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cScrollMensagens.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		cScrollMensagens.setMinimumSize(new java.awt.Dimension(742, 90));
		cScrollMensagens.setPreferredSize(new java.awt.Dimension(750, 90));

		areaMensagens.setEditable(false);
		areaMensagens.setColumns(20);
		areaMensagens.setRows(5);
		areaMensagens.setMargin(new java.awt.Insets(0, 0, 0, 0));
		areaMensagens.setMinimumSize(new java.awt.Dimension(750, 90));
		areaMensagens.setPreferredSize(new java.awt.Dimension(1600, 90));
		cScrollMensagens.setViewportView(areaMensagens);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cScrollEditor, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cScrollMensagens, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addComponent(jBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
						.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(cScrollEditor, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(0, 0, 0).addComponent(cScrollMensagens,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jBarraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 570,
										Short.MAX_VALUE))
						.addGap(0, 0, 0).addComponent(jBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCompilarActionPerformed
		areaMensagens.setText("");
		String str = editorTexto.getText();
		str = str.replace("\n", "").replace("\r", "").replace("\t", "").replace(" ", "");
		if (str.length() <= 0) {
			areaMensagens.setText("nenhum programa para compilar");
			return;
		}

		LineNumberReader in = new LineNumberReader(new StringReader(editorTexto.getText()));

		compilar(in);
	}// GEN-LAST:event_btnCompilarActionPerformed

	private void compilar(LineNumberReader in) {
		Lexico lexico = new Lexico();
		Sintatico sintatico = new Sintatico();
		Semantico semantico = new Semantico();

		lexico.setInput(in);

		try {
			sintatico.parse(lexico, semantico);
		} catch (LexicalError e) {
			// Trada erros l�xicos
			char lastLexeme = Memory.getInstance().getLastLexeme();
			int errorLine = Memory.getInstance().getErrorLine();

			String msg;
			if (lastLexeme == ' ') {
				msg = "Erro na linha " + errorLine + " - " + e.getMessage();
			} else {
				msg = "Erro na linha " + errorLine + " - " + lastLexeme + " " + e.getMessage();
			}
			areaMensagens.setText(msg);
			e.printStackTrace();
		} catch (SyntaticError e) {
			// Trada erros sint�ticos
			String lastToken = Memory.getInstance().getLastToken();
			int errorLine = Memory.getInstance().getErrorLine();

			areaMensagens.setText("Erro na linha " + errorLine + " - encontrado " + lastToken + " " + e.getMessage());
			e.printStackTrace();
		} catch (SemanticError e) {
			// Trada erros sem�nticos
			e.printStackTrace();
		}

		if (areaMensagens.getText().equals("")) {
			areaMensagens.setText("programa compilado com sucesso");
		}
	}

	private void compilarLexico(LineNumberReader in) {
		Lexico lexico = new Lexico();
		Sintatico sintatico = new Sintatico();
		// Semantico semantico = new Semantico();

		// L�XICO
		try {
			lexico.setInput(in);
			Token t = null;
			while ((t = lexico.nextToken()) != null) {
				System.out.println("lexeme " + t);
			}

		} catch (LexicalError e) {
			char lastLexeme = Memory.getInstance().getLastLexeme();
			int errorLine = Memory.getInstance().getErrorLine();

			String msg;
			if (lastLexeme == ' ') {
				msg = "Erro na linha " + errorLine + " - " + e.getMessage();
			} else {
				msg = "Erro na linha " + errorLine + " - " + lastLexeme + " " + e.getMessage();
			}
			System.err.println(msg);
			areaMensagens.setText(msg);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (areaMensagens.getText().equals("")) {
			areaMensagens.setText("programa compilado com sucesso");
		}
	}

	private void btnRecortarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRecortarActionPerformed
		// TODO add your handling code here:
		pad = editorTexto.getSelectedText();
		editorTexto.replaceRange("", editorTexto.getSelectionStart(), editorTexto.getSelectionEnd());
	}// GEN-LAST:event_btnRecortarActionPerformed

	private void btnColarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnColarActionPerformed
		// TODO add your handling code here:
		editorTexto.insert(pad, editorTexto.getCaretPosition());
	}// GEN-LAST:event_btnColarActionPerformed

	private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCopiarActionPerformed
		// TODO add your handling code here:
		pad = editorTexto.getSelectedText();
	}// GEN-LAST:event_btnCopiarActionPerformed

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
		// TODO add your handling code here:
		// limpar areamensages
		if (loadedFile.getSelectedFile() != null) {
			writeValores();
			String name = loadedFile.getSelectedFile().getPath().toString();
			jLabel1.setText("n�o modificado ");
			jLabel2.setText((name.contains(".txt") ? name : name + ".txt"));
			areaMensagens.setText("");
			return;
		}
		// only open dialog if there is not a selected file
		int rVal = loadedFile.showSaveDialog(this);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			areaMensagens.setText("");
			// get valores do editText e salvar no arquivo
			if (editorTexto.getText().length() > 0) {
				writeValores();
				String name = loadedFile.getSelectedFile().getPath().toString();
				jLabel1.setText("n�o modificado ");
				jLabel2.setText((name.contains(".txt") ? name : name + ".txt"));
			}
		}
		if (rVal == JFileChooser.CANCEL_OPTION) {
			// jLabel1.setText("You pressed cancel");
		}
	}// GEN-LAST:event_btnSalvarActionPerformed

	private void writeValores() {
		BufferedWriter writer = null;
		try {
			String name = loadedFile.getSelectedFile().getAbsoluteFile().toString();
			writer = new BufferedWriter(new FileWriter(name.contains(".txt") ? name : name + ".txt"));
			// System.out.println(editorTexto.getText());
			writer.write(editorTexto.getText());
		} catch (IOException e) {
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
			}
		}

	}

	private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAbrirActionPerformed
		// TODO add your handling code here:
		loadedFile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		loadedFile.setFileFilter(filter);
		// Demonstrate "Open" dialog:
		int rVal = loadedFile.showOpenDialog(this);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			// limpar mensagens
			areaMensagens.setText("");

			// set nome barra de status
			jLabel1.setText("n�o modificado ");
			jLabel2.setText(loadedFile.getSelectedFile().getPath().toString());

			// set valores do editText
			try {
				// make a 'file' object
				File file = new File(loadedFile.getSelectedFile().getAbsoluteFile().toString());
				// Get data from this file using a file reader.
				FileReader fr = new FileReader(file);
				// To store the contents read via File Reader
				BufferedReader reader = new BufferedReader(fr);
				String line = reader.readLine();

				String data = line;
				while (line != null) {
					// Print read line
					System.out.println(line);

					// Read next line for while condition
					line = reader.readLine();
					if (line != null) {
						data = data + '\n' + line;
					}
				}
				editorTexto.setText(data);
				initialLength = editorTexto.getText().length();
			} catch (IOException e) {
				System.out.println("bad !");
			}
		}
		if (rVal == JFileChooser.CANCEL_OPTION) {
			// jLabel1.setText("You pressed cancel");
		}
	}// GEN-LAST:event_btnAbrirActionPerformed

	private void btnGerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGerarCodigoActionPerformed
		areaMensagens.setText("Gera��o de c�digo ainda n�o foi implementada");
	}// GEN-LAST:event_btnGerarCodigoActionPerformed

	private void btnEquipeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEquipeActionPerformed
		areaMensagens.setText("Alunos: \n \t Rafael Rossi \n \t Helton Andreazza");
	}// GEN-LAST:event_btnEquipeActionPerformed

	private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNovoActionPerformed
		clean();
	}// GEN-LAST:event_btnNovoActionPerformed

	private void clean() {
		pad = " ";
		loadedFile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		loadedFile.setFileFilter(filter);
		areaMensagens.setText("");
		editorTexto.setText("");
		initialLength = editorTexto.getText().length();
		jLabel1.setText("n�o modificado");
		jLabel2.setText("");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Interface().setVisible(true);
			}
		});
	}

	private void iniciaEditor() {
		NumberedBorder borda = new NumberedBorder();
		editorTexto.setBorder(borda);
		editorTexto.setText("");
		initialLength = editorTexto.getText().length();
		// editorTexto.setLineWrap(true);
		editorTexto.setWrapStyleWord(true);
	}

	private void list(InputMap map, KeyStroke[] keys) {
		if (keys == null) {
			return;
		}
		for (int i = 0; i < keys.length; i++) {
			// System.out.println(keys[i].getKeyChar());
			map.put(keys[i], "Editor");
		}
	}

	private void setAtalhos() {
		// System.out.println("oi");
		// InputMap map =
		// editorTexto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		// list(map, map.allKeys());
		// editorTexto.getActionMap().put("Editor", new AbstractAction() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("foi");
		// }
		// });

		editorTexto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// throw new UnsupportedOperationException("Not supported
				// yet."); //To change body of generated methods, choose Tools |
				// Templates.
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyChar());
				// System.out.println(editorTexto.getText().length());
				if (editorTexto.getText().length() != initialLength) {
					jLabel1.setText("modificado");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// throw new UnsupportedOperationException("Not supported
				// yet."); //To change body of generated methods, choose Tools |
				// Templates.
			}
		});

		btnEquipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Equipe");
		btnEquipe.getActionMap().put("Equipe", new javax.swing.AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEquipeActionPerformed(e);
			}
		});

		btnAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "Abrir");
		btnAbrir.getActionMap().put("Abrir", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAbrirActionPerformed(e);
			}

		});

		btnGerarCodigo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F9"), "Gerar c�digo");
		btnGerarCodigo.getActionMap().put("Gerar c�digo", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnGerarCodigoActionPerformed(e);
			}

		});

		btnCompilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F8"), "Compilar");
		btnCompilar.getActionMap().put("Compilar", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCompilarActionPerformed(e);
			}

		});

		btnNovo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "Novo");
		btnNovo.getActionMap().put("Novo", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNovoActionPerformed(e);
			}

		});

		btnSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "Salvar");
		btnSalvar.getActionMap().put("Salvar", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}

		});

		btnAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), "Abrir");
		btnAbrir.getActionMap().put("Abrir", new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAbrirActionPerformed(e);
			}

		});
	}

	private void setIcones() {
		try {
			Image iColar = ImageIO.read(getClass().getResource("/icones/colar.png"));
			Image iCompilar = ImageIO.read(getClass().getResource("/icones/compilar.png"));
			Image iCopiar = ImageIO.read(getClass().getResource("/icones/copiar.png"));
			Image iRecortar = ImageIO.read(getClass().getResource("/icones/recortar.png"));
			Image iEquipe = ImageIO.read(getClass().getResource("/icones/equipe.png"));
			Image iGerarCodigo = ImageIO.read(getClass().getResource("/icones/gerarcodigo.png"));
			Image iSalvar = ImageIO.read(getClass().getResource("/icones/salvar.png"));
			Image iNovo = ImageIO.read(getClass().getResource("/icones/novo.png"));
			Image iAbrir = ImageIO.read(getClass().getResource("/icones/abrir.png"));
			btnCompilar.setIcon(new ImageIcon(iCompilar));
			btnCompilar.setHorizontalTextPosition(btnCompilar.CENTER);
			btnCompilar.setVerticalTextPosition(btnCompilar.BOTTOM);
			btnCopiar.setIcon(new ImageIcon(iCopiar));
			btnCopiar.setHorizontalTextPosition(btnCopiar.CENTER);
			btnCopiar.setVerticalTextPosition(btnCopiar.BOTTOM);
			btnNovo.setIcon(new ImageIcon(iNovo));
			btnNovo.setHorizontalTextPosition(btnNovo.CENTER);
			btnNovo.setVerticalTextPosition(btnNovo.BOTTOM);
			btnEquipe.setIcon(new ImageIcon(iEquipe));
			btnEquipe.setHorizontalTextPosition(btnEquipe.CENTER);
			btnEquipe.setVerticalTextPosition(btnEquipe.BOTTOM);
			btnColar.setIcon(new ImageIcon(iColar));
			btnColar.setHorizontalTextPosition(btnColar.CENTER);
			btnColar.setVerticalTextPosition(btnColar.BOTTOM);
			btnAbrir.setIcon(new ImageIcon(iAbrir));
			btnAbrir.setHorizontalTextPosition(btnAbrir.CENTER);
			btnAbrir.setVerticalTextPosition(btnAbrir.BOTTOM);
			btnGerarCodigo.setIcon(new ImageIcon(iGerarCodigo));
			btnGerarCodigo.setHorizontalTextPosition(btnGerarCodigo.CENTER);
			btnGerarCodigo.setVerticalTextPosition(btnGerarCodigo.BOTTOM);
			btnRecortar.setIcon(new ImageIcon(iRecortar));
			btnRecortar.setHorizontalTextPosition(btnRecortar.CENTER);
			btnRecortar.setVerticalTextPosition(btnRecortar.BOTTOM);
			btnSalvar.setIcon(new ImageIcon(iSalvar));
			btnSalvar.setHorizontalTextPosition(btnSalvar.CENTER);
			btnSalvar.setVerticalTextPosition(btnSalvar.BOTTOM);
		} catch (IOException ex) {
		}

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextArea areaMensagens;
	private javax.swing.JButton btnAbrir;
	private javax.swing.JButton btnColar;
	private javax.swing.JButton btnCompilar;
	private javax.swing.JButton btnCopiar;
	private javax.swing.JButton btnEquipe;
	private javax.swing.JButton btnGerarCodigo;
	private javax.swing.JButton btnNovo;
	private javax.swing.JButton btnRecortar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JScrollPane cScrollEditor;
	private javax.swing.JScrollPane cScrollMensagens;
	private javax.swing.JTextArea editorTexto;
	private javax.swing.JPanel jBarraFerramentas;
	private javax.swing.JPanel jBarraStatus;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration//GEN-END:variables

}