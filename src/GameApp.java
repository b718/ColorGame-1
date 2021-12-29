import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GameApp implements ActionListener {

    private final Color RED = Color.RED;
    private final Color BLUE = Color.BLUE;
    private final Color YELLOW = Color.YELLOW;
    private final Color GREEN = Color.GREEN;
    public static final Font SERIF_FONT = new Font("Serif Sans", Font.PLAIN, 14);
    public static final int WIDTH_WINDOW = 600;
    public static final int HEIGHT_WINDOW = 600;

    private JFrame window;
    private JPanel gamePanel;
    private JPanel displayPanel;

    private ArrayList<Color> correctList;
    private ArrayList<Color> ourList;
    private int colorHolderSize;


    public GameApp() {
        window = new JFrame("Color Game");
        window.setBackground(Color.lightGray);
        window.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instantiate();
        colorHolderSize = 1;
        correctList = new ArrayList<>();
        ourList = new ArrayList<>();
        window.setVisible(true);
    }

    public void instantiate() {
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);
        gamePanel.setBounds(105, 420, 400, 60);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        gamePanel.setLayout(new GridLayout(1, 5));

        JButton redButton = buttonHelper(RED, "Red");
        JButton blueButton = buttonHelper(BLUE, "Blue");
        JButton yellowButton = buttonHelper(YELLOW, "Yellow");
        JButton greenButton = buttonHelper(GREEN, "Green");
        JButton confirmButton = buttonHelper(Color.lightGray, "Confirm");

        gamePanel.add(redButton);
        gamePanel.add(blueButton);
        gamePanel.add(yellowButton);
        gamePanel.add(greenButton);
        gamePanel.add(confirmButton);

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
        x.addActionListener(this);
        return x;
    }

    // This displays the randomly chosen colors we get from our random choosing concept!
    public void displayerMethod() {
        // We take our parameter C and display that bih!
        displayPanel = new JPanel();

        for(int i = 0; i < correctList.size(); i++) {
            displayPanel.setBackground(correctList.get(i));
        }

    }

    // This checks if the colors we have given is equal to the correct
    // colors that are randomly chosen!
    public void checkingMethod() {
        // We have to use ArrayLists here because order actually matters!
        // We would have to check each index, and we may even have to do hashCode!

        boolean c = true;

        for (int i = 0; i < correctList.size(); i++) {
            if (!correctList.get(i).equals(ourList.get(i))) {
                c = false;
                // What we need to actually do here is display that we are wrong
                // and for the code not to keep running after we have failed!
            }
        }

        if (c) {
            colorHolderSize++;
        }
    }


    public void randomizer() {
        for (int i = 0; i < colorHolderSize; i++) {
            ArrayList<Color> allColors = randomizerHelper();
            Random rand = new Random();
            correctList = new ArrayList<>();
            correctList.add(allColors.get(rand.nextInt(allColors.size())));
        }
    }


    public ArrayList<Color> randomizerHelper() {
        ArrayList<Color> x = new ArrayList<>();
        x.add(RED);
        x.add(GREEN);
        x.add(YELLOW);
        x.add(BLUE);
        return x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
