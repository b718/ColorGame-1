import javax.swing.*;
import java.awt.*;

public class GameApp {

    private final Color RED = Color.RED;
    private final Color BLUE = Color.BLUE;
    private final Color YELLOW = Color.YELLOW;
    private final Color GREEN = Color.GREEN;
    public static final Font SERIF_FONT = new Font("Serif Sans", Font.PLAIN, 20);
    public static final int WIDTH_WINDOW = 600;
    public static final int HEIGHT_WINDOW = 600;

    private JFrame window;
    private JPanel gamePanel;


    public GameApp(){
        window = new JFrame("Color Game");
        window.setBackground(Color.lightGray);
        window.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testing();
        window.setVisible(true);
    }

    public void testing() {
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);
        gamePanel.setBounds(128,420,350,60);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        gamePanel.setLayout(new GridLayout(1,4));

        JButton redButton = buttonHelper(RED, "Red");
        JButton blueButton = buttonHelper(BLUE, "Blue");
        JButton yellowButton = buttonHelper(YELLOW, "Yellow");
        JButton greenButton = buttonHelper(GREEN, "Green");

        gamePanel.add(redButton);
        gamePanel.add(blueButton);
        gamePanel.add(yellowButton);
        gamePanel.add(greenButton);

        window.add(gamePanel);
        window.setVisible(true);
        ((JComponent) window.getContentPane()).revalidate();
        window.repaint();
    }

    public JButton buttonHelper(Color g, String s) {
        JButton x = new JButton(s);
        x.setBackground(g);
        x.setFocusable(false);
        x.setFont(SERIF_FONT);
        x.setForeground(g);
        return x;
    }
}
