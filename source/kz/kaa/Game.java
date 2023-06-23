import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class tetris {
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel mainPanel = new MyDrawPanel(); 
		frame.getContentPane().add(mainPanel);

		frame.setSize(500, 500);
		frame.setVisible(true);

		while(true) {
			
		}
	}
}

class MyDrawPanel extends JPanel {
	Foundation foundation;
	Figure dynamicFigure;

	public void paintComponent(Graphics g) {
		// Отрисовка фона
		for(int y = 1; y < 21; y++) {
			for(int x = 1; x < 11; x++) {
				g.setColor(Color.gray);
				g.fillRect(21 * x, 21 * y + 5, 20, 20);
			}
		}

		// Отрисовка отыграной части
		g.setColor(Color.black);

		// Отрисовка динамической фигуры
		g.setColor(Color.orange);
		//g.fillRect(21 * dynamicFigure.getX1, 21 * dynamicFigure.getY1, 20, 20);
		//g.fillRect(21 * dynamicFigure.getX2, 21 * dynamicFigure.getY2, 20, 20);
		//g.fillRect(21 * dynamicFigure.getX3, 21 * dynamicFigure.getY3, 20, 20);
		//g.fillRect(21 * dynamicFigure.getX4, 21 * dynamicFigure.getY4, 20, 20);
	}
	
	public void setFoundation(Foundation fnd) {
		foundation = fnd;
	}
	
	public void setFigure(Figure f) {
		dynamicFigure = f;
	}
}

class Block {
	int x;
	int y;
	
	public void setX(int x_loc) {
		x = x_loc;
	}
	
	public void setY(int y_loc) {
		y = y_loc;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

abstract class Figure {
	private int x;
	private int y;
	protected ArrayList<Block> figure;
	
	Figure() {
		figure = new ArrayList<Block>();
	}

	public void setX(int x_loc) {
		x = x_loc;
	}
	
	public void setY(int y_loc) {
		y = y_loc;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void down() {
		for(int i = 0; i < 4; i++) {
			figure.get(i).setY(figure.get(i).getY() + 1);
		}
	}

	public abstract void rotate();
}

class FStick extends Figure {
	FStick() {
		super();
		
		for(int i = 4; i < 8; i++) {
			Block a = new Block();
			a.setX(i);
			a.setY(0);
			figure.add(a);
		}
	}
	
	public void rotate() {
	}	
}

class DynamicFigure {

}

class Foundation {
	
}

// Test comment
