package br.com.locadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JanelaSenha extends JDialog {

    //
    private JLabel labelUser = new JLabel("Usuario");
    private JTextField editUser = new JTextField("");
    private JPasswordField editPassword = new JPasswordField("");

    private JLabel labelPassword = new JLabel("Senha:");
    private JButton buttonOk = new JButton("OK");
    private JButton buttonCancel = new JButton("Cancelar");
    private JLabel labelStatus = new JLabel("Informe Usuario e senha: ");

    private boolean volta = false;
    private String login = "";

    public JanelaSenha() {

        this.getContentPane().setLayout(null);
        this.setSize(264, 197);
        this.setResizable(false);
        this.setModal(true);
        this.setTitle("Entrada do Sistema");
        labelUser.setBounds(new Rectangle(48, 28, 57, 13));
        this.getContentPane().add(labelUser, null);
        editUser.setBounds(110, 24, 100, 21);
        this.getContentPane().add(editUser, null);
        editPassword.setBounds(110, 53, 100, 21);
        this.getContentPane().add(editPassword, null);
        labelPassword.setBounds(52, 56, 57, 13);
        this.getContentPane().add(labelPassword);
        buttonOk.setBounds(6, 97, 100, 30);
        this.getContentPane().add(buttonOk, null);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acesso acesso = new Acesso();
                String senha = devSenha (editPassword.getPassword());
                login = editUser.getText();

                if (acesso.conecta()){
                    volta = (acesso.veExiste("tb_user where username = '" + login + "' and password = '" +
                            senha + "'") > 0 );
                    acesso.desconecta();
                }
                if (volta){
                    dispose();
                }
            }
        });
        buttonCancel.setBounds(146, 97, 100, 30);
        this.getContentPane().add(buttonCancel, null);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        labelStatus.setBounds(27, 147, 200, 13);
        this.getContentPane().add(labelStatus, null);
        /*
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }); */
    }

    private String devSenha(char[] password) {
        String senha = "";
        for (int i=0; i<password.length; i++) {
            senha += password[i];
        }
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isVolta() {
        return volta;
    }

}
