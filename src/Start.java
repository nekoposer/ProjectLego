import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Start extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel colorPanel = new JPanel();
    private JPanel legoGame = new JPanel();
    private DrawPanel test = new DrawPanel(1, 1);
    private LegoPanel legoPanel = new LegoPanel();
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private Font testFont;

    public Start() {
        super("Lego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        setSize(700, 500);
        Dimension panelSize = new Dimension(700, 532);
        setBounds(450, 100, 700, 500);
        panel.setPreferredSize(panelSize);

        JButton start = new JButton("Start game");
        JButton exit = new JButton("Exit game");
        JLabel title = new JLabel("2D LEGO");
        try {
            testFont = Font.createFont(Font.TRUETYPE_FONT, new File("data\\LEGO.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //title.setIcon(new ImageIcon("data\\title_main.png"));
        title.setFont(testFont.deriveFont(Font.BOLD, 55f));

        start.setBounds(290, 220, 120, 25);
        exit.setBounds(290, 250, 120, 25);
        title.setBounds(260, 80, 325, 106);


        panel.add(start);
        panel.add(exit);
        panel.add(title);

        cardPanel.add(panel, "start");
        cardPanel.add(gamePanel, "chooseSize");
        add(cardPanel);

        exit.addActionListener(new ActionListenerExit(this));
        start.addActionListener(new ActionListenerSwitch(cardLayout, cardPanel, "chooseSize"));

        JButton backToMenu = new JButton("Back");
        backToMenu.addActionListener(new ActionListenerSwitch(cardLayout, cardPanel, "start"));
        backToMenu.setBounds(630, 0, 70, 30);

        gamePanel.setLayout(null);

        JLabel label = new JLabel("<html><div align='center'>Choose field<br>size</div></html>", JLabel.CENTER);
        Font font = new Font("Verdana", Font.BOLD, 14);
        label.setFont(font);
        label.setBounds(250, 150, 200, 60);

        JButton firstSize = new JButton("8x8");
        JButton secondSize = new JButton("16x16");
        JButton thirdSize = new JButton("32x32");
        firstSize.setBounds(250, 250, 70, 70);
        secondSize.setBounds(318, 250, 70, 70);
        thirdSize.setBounds(386, 250, 70, 70);

        gamePanel.add(firstSize);
        gamePanel.add(secondSize);
        gamePanel.add(thirdSize);
        gamePanel.add(backToMenu);
        gamePanel.add(label);

        cardPanel.add(colorPanel, "chooseColor");

        firstSize.setActionCommand("8x8");
        secondSize.setActionCommand("16x16");
        thirdSize.setActionCommand("32x32");

        firstSize.addActionListener(new ActionListenerChangeSize(cardLayout, cardPanel, "chooseColor", legoGame, test));
        secondSize.addActionListener(new ActionListenerChangeSize(cardLayout, cardPanel, "chooseColor", legoGame, test));
        thirdSize.addActionListener(new ActionListenerChangeSize(cardLayout, cardPanel, "chooseColor", legoGame, test));

        colorPanel.setLayout(null);

        String label2Text = "<html><div align='center'>Choose field<br>color</div></html>";
        JLabel label2 = new JLabel(label2Text, JLabel.CENTER);
        font = new Font("Verdana", Font.BOLD, 14);
        label2.setFont(font);
        label2.setBounds(250, 150, 200, 60);


        JButton back = new JButton("Back");
        back.addActionListener(new ActionListenerSwitch(cardLayout, cardPanel, "chooseSize"));
        back.setBounds(630, 0, 70, 30);
        colorPanel.add(back);

        colorPanel.add(label2);

        JButton red = new JButton("Red");
        JButton orange = new JButton("Orange");
        JButton yellow = new JButton("Yellow");
        JButton green = new JButton("Green");
        JButton cyan = new JButton("Cyan");
        JButton blue = new JButton("Blue");
        JButton purple = new JButton("Purple");
        JButton clean = new JButton("Clean");
        JButton white = new JButton("White");
        JButton black = new JButton("Black");
        JButton lightGreen = new JButton("<html><div align='center'>Light<br>green</div></html>");
        JButton pink = new JButton("Pink");

        red.setBounds(220, 220, 90, 60);
        orange.setBounds(308, 220, 90, 60);
        pink.setBounds(396, 220, 90, 60);
        yellow.setBounds(220, 290, 90, 60);
        lightGreen.setBounds(308, 290, 90, 60);
        green.setBounds(396, 290, 90, 60);
        cyan.setBounds(220, 360, 90, 60);
        blue.setBounds(308, 360, 90, 60);
        purple.setBounds(396, 360, 90, 60);
        black.setBounds(220, 430, 90, 60);
        white.setBounds(308, 430, 90, 60);
        clean.setBounds(396, 430, 90, 60);

        red.setBackground(Color.RED);
        orange.setBackground(Color.ORANGE);
        yellow.setBackground(Color.YELLOW);
        green.setBackground(Color.GREEN);
        cyan.setBackground(Color.CYAN);
        blue.setBackground(Color.BLUE);
        purple.setBackground(new Color(128, 0, 128));
        white.setBackground(Color.WHITE);
        black.setBackground(Color.BLACK);
        lightGreen.setBackground(new Color(0, 255, 127));
        pink.setBackground(new Color(255, 192, 203));

        red.setActionCommand("red");
        orange.setActionCommand("orange");
        yellow.setActionCommand("yellow");
        green.setActionCommand("green");
        cyan.setActionCommand("cyan");
        blue.setActionCommand("blue");
        purple.setActionCommand("purple");
        clean.setActionCommand("clean");
        white.setActionCommand("white");
        black.setActionCommand("black");
        lightGreen.setActionCommand("lightGreen");
        pink.setActionCommand("pink");

        colorPanel.add(red);
        colorPanel.add(orange);
        colorPanel.add(yellow);
        colorPanel.add(green);
        colorPanel.add(cyan);
        colorPanel.add(blue);
        colorPanel.add(purple);
        colorPanel.add(new JPanel());
        colorPanel.add(lightGreen);
        colorPanel.add(pink);
        colorPanel.add(clean);
        colorPanel.add(white);
        colorPanel.add(black);

        for (int i = 0; i < 8; ++i) {
            colorPanel.add(new JPanel());
        }

        black.setForeground(Color.WHITE);

        red.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        orange.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        yellow.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        green.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        cyan.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        blue.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        purple.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        clean.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        white.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        black.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        lightGreen.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));
        pink.addActionListener(new ActionListenerChangeColor(cardLayout, cardPanel, "legoGame", legoGame, test));


        legoPanel.setLayout(null);
        cardPanel.add(legoPanel, "legoGame");
        //700 na 500
        JButton download = new JButton();
        JButton muteSound = new JButton();
        JButton clear = new JButton("Clear");
        JButton exitMenu = new JButton("Exit");
        JButton redDetail = new JButton();
        JButton orangeDetail = new JButton();
        JButton yellowDetail = new JButton();
        JButton greenDetail = new JButton();
        JButton cyanDetail = new JButton();
        JButton blueDetail = new JButton();
        JButton purpleDetail = new JButton();
        JButton whiteDetail = new JButton();
        JButton blackDetail = new JButton();
        JButton lightGreenDetail = new JButton();
        JButton pinkDetail = new JButton();

        JLabel colorDetail = new JLabel("Choose detail color", JLabel.CENTER);
        colorDetail.setFont(font);

        redDetail.setBackground(Color.RED);
        orangeDetail.setBackground(Color.ORANGE);
        yellowDetail.setBackground(Color.YELLOW);
        greenDetail.setBackground(Color.GREEN);
        cyanDetail.setBackground(Color.CYAN);
        blueDetail.setBackground(Color.BLUE);
        purpleDetail.setBackground(new Color(128, 0, 128));
        whiteDetail.setBackground(Color.WHITE);
        blackDetail.setBackground(Color.BLACK);
        lightGreenDetail.setBackground(new Color(0, 255, 127));
        pinkDetail.setBackground(new Color(255, 192, 203));

        colorDetail.setBounds(138, 483, 204, 23);
        lightGreenDetail.setBounds(2, 483, 68, 23);
        pinkDetail.setBounds(70, 483, 68, 23);
        whiteDetail.setBounds(342, 483, 68, 23);
        blackDetail.setBounds(410, 483, 68, 23);
        redDetail.setBounds(2, 506, 68, 27);
        orangeDetail.setBounds(70, 506, 68, 27);
        yellowDetail.setBounds(138, 506, 68, 27);
        greenDetail.setBounds(206, 506, 68, 27);
        cyanDetail.setBounds(274, 506, 68, 27);
        blueDetail.setBounds(342, 506, 68, 27);
        purpleDetail.setBounds(410, 506, 68, 27);

        clear.setBounds(484, 0, 108, 30);
        exitMenu.setBounds(593, 0, 108, 30);
        muteSound.setBounds(670, 502, 30, 30);
        download.setBounds(635, 502, 30, 30);


        redDetail.setActionCommand("red");
        orangeDetail.setActionCommand("orange");
        yellowDetail.setActionCommand("yellow");
        greenDetail.setActionCommand("green");
        cyanDetail.setActionCommand("cyan");
        blueDetail.setActionCommand("blue");
        purpleDetail.setActionCommand("purple");
        whiteDetail.setActionCommand("white");
        blackDetail.setActionCommand("black");
        lightGreenDetail.setActionCommand("lightGreen");
        pinkDetail.setActionCommand("pink");

        redDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        orangeDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        yellowDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        greenDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        cyanDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        blueDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        purpleDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        whiteDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        blackDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        lightGreenDetail.addActionListener(new ActionListenerChangeDetailColor(test));
        pinkDetail.addActionListener(new ActionListenerChangeDetailColor(test));

        test.setBounds(0, 0, 480, 480);
        test.setOpaque(false);
        legoPanel.add(test);

        exitMenu.addActionListener(new ActionListenerExitMenu(cardLayout, cardPanel, "start", test));
        clear.addActionListener(new ActionListenerClear(test));
        muteSound.addActionListener(new ActionListenerMute(test, muteSound));
        download.addActionListener(new ActionListenerDownload(test, legoGame));

        muteSound.setIcon(new ImageIcon("data\\unmute.png"));
        muteSound.setOpaque(false);
        download.setIcon(new ImageIcon("data\\download_icon4.jpg"));

        legoPanel.add(download);
        legoPanel.add(muteSound);
        legoPanel.add(clear);
        legoPanel.add(exitMenu);
        legoPanel.add(redDetail);
        legoPanel.add(orangeDetail);
        legoPanel.add(yellowDetail);
        legoPanel.add(greenDetail);
        legoPanel.add(cyanDetail);
        legoPanel.add(blueDetail);
        legoPanel.add(purpleDetail);
        legoPanel.add(colorDetail);
        legoPanel.add(whiteDetail);
        legoPanel.add(blackDetail);
        legoPanel.add(lightGreenDetail);
        legoPanel.add(pinkDetail);

        JLabel figures = new JLabel("Choose detail", JLabel.CENTER);
        figures.setFont(new Font("Verdana", Font.BOLD, 14));
        figures.setBounds(483, 33, 216, 25);
        legoPanel.add(figures);

        JButton oneXone = new JButton();
        JButton twoXone = new JButton();
        JButton twoXtwo = new JButton();
        JButton threeXone = new JButton();
        JButton threeXtwo = new JButton();

        oneXone.setBounds(538, 65, 30, 30);
        twoXone.setBounds(538, 105, 60, 30);
        twoXtwo.setBounds(538, 145, 60, 60);
        threeXone.setBounds(538, 225, 90, 30);
        threeXtwo.setBounds(538, 265, 90, 60);

        oneXone.setActionCommand("1x1");
        twoXone.setActionCommand("2x1");
        twoXtwo.setActionCommand("2x2");
        threeXone.setActionCommand("3x1");
        threeXtwo.setActionCommand("3x2");

        oneXone.addActionListener(new ActionListenerSetDetail(test));
        twoXone.addActionListener(new ActionListenerSetDetail(test));
        twoXtwo.addActionListener(new ActionListenerSetDetail(test));
        threeXone.addActionListener(new ActionListenerSetDetail(test));
        threeXtwo.addActionListener(new ActionListenerSetDetail(test));

        GridComponent gridForDetails = new GridComponent(2, 1);
        gridForDetails.setBounds(0, 0, 60, 30);
        twoXone.setLayout(null);
        twoXone.add(gridForDetails);

        gridForDetails = new GridComponent(2, 2);
        gridForDetails.setBounds(0, 0, 60, 60);
        twoXtwo.setLayout(null);
        twoXtwo.add(gridForDetails);

        gridForDetails = new GridComponent(3, 1);
        gridForDetails.setBounds(0, 0, 90, 30);
        threeXone.setLayout(null);
        threeXone.add(gridForDetails);

        gridForDetails = new GridComponent(3, 2);
        gridForDetails.setBounds(0, 0, 90, 60);
        threeXtwo.setLayout(null);
        threeXtwo.add(gridForDetails);

        legoPanel.add(oneXone);
        legoPanel.add(twoXone);
        legoPanel.add(twoXtwo);
        legoPanel.add(threeXone);
        legoPanel.add(threeXtwo);

        legoGame.setLayout(null);
        legoGame.setBounds(0, 0, 480, 480);
        legoPanel.add(legoGame);
    }
}
