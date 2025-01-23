package br.com.locadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {

    private JMenuBar meuMenu = new JMenuBar();
    private JMenu menuArquivo = new JMenu("Arquivo");
    private JMenu menuCadastro = new JMenu("Cadastro");
    private JMenuItem menuItemFilme = new JMenuItem("Filme");
    private JMenuItem menuItemCliente = new JMenuItem("Cliente");
    private JMenuItem menuItemSair = new JMenuItem("Sair");

    // -->
    private JMenu menuMovimenta = new JMenu("Movimentação");
    private JMenuItem menuItemAluguel = new JMenuItem("Alugel");
    private JMenuItem menuItemDevolucao = new JMenuItem("Devolução");
    private JMenuItem menuItemMostraFilme = new JMenuItem("Mostra Filme");

    // -->
    private JMenu menuAjuda = new JMenu("Ajuda");
    private JMenuItem menuItemSobre = new JMenuItem("Sobre");

    // -->
    private JLabel labelUsuario = new JLabel("Usuário: ");

    public MenuPrincipal() {
        try {
            mostra();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void mostra() throws Exception {
        this.getContentPane().setLayout(null);
        this.setTitle("Menu Principal do Sistema");
        this.setSize(500, 350);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        menuArquivo.setMnemonic('A');
        menuCadastro.setMnemonic('C');
        menuItemFilme.setMnemonic('F');
        menuItemFilme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraFilme(e);
            }
        });

        menuItemCliente.setMnemonic('C');
        menuItemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraCliente(e);
            }
        });

        menuItemSair.setMnemonic('S');
        menuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuMovimenta.setMnemonic('M');
        menuItemAluguel.setMnemonic('A');
        menuItemAluguel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarFilme(e);
            }
        });

        menuItemDevolucao.setMnemonic('D');
        menuItemDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverFilme(e);
            }
        });

        menuItemMostraFilme.setMnemonic('M');
        menuItemMostraFilme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFilme(e);
            }
        });

        menuAjuda.setMnemonic('J');
        menuItemSobre.setMnemonic('S');
        menuItemSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sobreSistema(e);
            }
        });

        // -->
        meuMenu.add(menuArquivo);
        meuMenu.add(menuMovimenta);
        meuMenu.add(menuAjuda);

        menuArquivo.add(menuCadastro);
        menuArquivo.addSeparator();
        menuArquivo.add(menuItemSair);

        menuCadastro.add(menuItemFilme);
        menuCadastro.add(menuItemCliente);

        menuMovimenta.add(menuItemAluguel);
        menuMovimenta.add(menuItemDevolucao);
        menuMovimenta.addSeparator();
        menuMovimenta.add(menuItemMostraFilme);

        menuAjuda.add(menuItemSobre);

        this.setJMenuBar(meuMenu);
        this.getContentPane().add(labelUsuario, null);
    }

    private void sobreSistema(ActionEvent e) {
    }

    private void mostrarFilme(ActionEvent e) {
    }

    private void devolverFilme(ActionEvent e) {
    }

    private void alugarFilme(ActionEvent e) {
    }

    private void cadastraCliente(ActionEvent e) {
    }

    private void cadastraFilme(ActionEvent e) {
    }
}
