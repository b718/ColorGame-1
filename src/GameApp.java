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
    private JPanel displayPanel2;
    private JPanel displayPanelHelper;
    // We need this because putting it directly onto the frame causes errors

    private ArrayList<Color> correctList;
    private ArrayList<Color> ourList;
    private int colorHolderSize;
    private boolean c;
    private ArrayList<Color> allColors;

    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;
    private JButton confirmButton;
    private JButton nextButton;

    public GameApp() {
        window = new JFrame("Color Game");
        window.setBackground(Color.lightGray);
        window.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorHolderSize = 4;
        correctList = new ArrayList<>();
        ourList = new ArrayList<>();
        instantiate();
        randomizer();
        displayerMethod();
        window.setVisible(true);
    }

    public void instantiate() {
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);
        gamePanel.setBounds(105, 420, 400, 60);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        gamePanel.setLayout(new GridLayout(1, 5));

        displayPanelHelper = new JPanel();
        displayPanelHelper.setBackground(Color.black);
        displayPanelHelper.setBounds(105, 420, 400, 60);
        displayPanelHelper.setBorder(BorderFactory.createLineBorder(Color.blue));
        displayPanelHelper.setLayout(new GridLayout(1, 1));

        redButton = buttonHelper(RED, "Red");
        blueButton = buttonHelper(BLUE, "Blue");
        yellowButton = buttonHelper(YELLOW, "Yellow");
        greenButton = buttonHelper(GREEN, "Green");
        confirmButton = buttonHelper(Color.lightGray, "Confirm");
        nextButton = buttonHelper(Color.black, "Next");

        gamePanel.add(redButton);
        gamePanel.add(blueButton);
        gamePanel.add(yellowButton);
        gamePanel.add(greenButton);
        gamePanel.add(confirmButton);

        displayPanelHelper.add(nextButton);

        window.add(gamePanel);
        window.add(displayPanelHelper);
        displayPanelHelper.setVisible(false);
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
        //window.setVisible(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("reached here");
        displayPanel = new JPanel();
        displayPanel.setBounds(105, 55, 400, 300);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.black);

        for (int i = 0; i < correctList.size(); i++) {
            displayPanel.setBackground(correctList.get(i));
            window.add(displayPanel);
            window.setVisible(true);
            window.revalidate();
            window.repaint();
            try {
                Thread.sleep(2000);
                // This adds a 1-second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
                // We might need a better way then to simply print a stack trace
                // when we catch!
            }
        }
    }

 /*
 // This is to instantiate the jpanel we are putting the colors onto!
    public void displayerMethodHelper() {
        displayPanelHelper = new JPanel();
        displayPanelHelper.setBounds(105, 50, 420, 310);
        displayPanelHelper.setBorder(BorderFactory.createLineBorder(Color.blue));
        displayPanelHelper.setLayout(null);

        displayerMethod();
        window.add(displayPanelHelper);
        window.setVisible(true);
        ((JComponent) window.getContentPane()).revalidate();
        window.repaint();

}*/

    // This checks if the colors we have given is equal to the correct
    // colors that are randomly chosen!
    public void checkingMethod() {
        // We have to use ArrayLists here because order actually matters!
        // We would have to check each index, and we may even have to do hashCode!
        c = true;

        for (int i = 0; i < correctList.size(); i++) {
            if (!correctList.get(i).equals(ourList.get(i))) {
                c = false;
                System.out.println("wrong");
                // What we need to actually do here is display that we are wrong
                // and for the code not to keep running after we have failed!
            }
        }

        if (c) {
            System.out.println("correct");
            ourList = new ArrayList<>();
            colorHolderSize++;
            return;
        }
    }

    public void randomizer() {
        correctList = new ArrayList<>();
        for (int i = 0; i < colorHolderSize; i++) {
            allColors = randomizerHelper();
            Random rand = new Random();
            Color x = allColors.get(rand.nextInt(allColors.size()));
            System.out.println(x);
            correctList.add(x);
        }
        displayerMethod();
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
        if (e.getSource() == redButton) {
            ourList.add(RED);
            System.out.println("Added red!");

        } else if (e.getSource() == blueButton) {
            ourList.add(BLUE);
            System.out.println("Added blue!");

        } else if (e.getSource() == greenButton) {
            ourList.add(GREEN);
            System.out.println("Added green!");

        } else if (e.getSource() == yellowButton) {
            ourList.add(YELLOW);
            System.out.println("Added yellow!");

        } else if (e.getSource() == confirmButton) {
            displayPanel.setVisible(false);
            checkingMethod();
            randomizer();

        }else if (e.getSource() == nextButton){
            randomizer();
            gamePanel.setVisible(true);
        }

        System.out.println("reached here in actionPerformed!");
    }
}
