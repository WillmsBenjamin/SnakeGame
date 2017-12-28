package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.Game;

public class Renderer extends JPanel {

	private static final long serialVersionUID = 8669219894045737438L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Game.game.repaint(g2);
	}
}
