package br.com.locadora;

import javax.swing.*;
import java.awt.*;

public class JanelaSobre extends JDialog {

    private Image imagem;

    public JanelaSobre(String imagem) {
        this.imagem = getToolkit().getImage(imagem);
        this.setSize(380,300);
        this.setTitle("Sobre o sistema...");
        this.setResizable(false);
        this.setModal(true);
        repaint();
    }

    public void paint(Graphics g) {
        char direitos = '\u00A9';
        g.drawImage(imagem, 0,22, this);
        g.drawImage(imagem, 0,112, this);
        g.drawImage(imagem, 0,202, this);

        g.drawString("Locadora" + direitos + "Jan/2001", 125, 125 );
        g.drawString("Autor" , 125, 140 );
        g.drawString("Sistema de Locadora", 125, 155 );
        g.drawString("Versão Demonstração - Didática", 125, 170 );
    }
}
