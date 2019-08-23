import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Animation
{
	int r = 20;
	int x = 0;
	int y = 100;
	boolean anyKey = true;
	public static void main(String[] args)
	{
		Animation animation = new Animation();		// constructor, create the object
		animation.game();				// call the metod for the object
	}

	public void game()
	{
		JFrame frame = new JFrame("Snake");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();	
		drawPanel.setFocusTraversalKeysEnabled(false);
		frame.add(drawPanel);				// put the panel for drawing on frame
		frame.setFocusTraversalKeysEnabled(false);
		frame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_UP) {anyKey = false;}
			}
		});

/********************************************************************************		
*				equivalent for cycle 				*
*										*
*				movement going on until press key UP		*
********************************************************************************/
		while (anyKey)
		{
			drawPanel.repaint();
			try {Thread.sleep(50);} catch (Exception ex){}
			x += 20;
			if (x == frame.getWidth()) {x = 0;}
		}

/********************************************************************************/

	}


	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.gray);
			g.fillOval(x, y, r, r);
		}

	}

}


