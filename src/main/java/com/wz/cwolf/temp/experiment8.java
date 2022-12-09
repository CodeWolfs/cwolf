package com.wz.cwolf.temp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @className experiment8
 * @description 实验8:GUI设计 分别用Swing. JavaFX设计窗体、标签、按钮、文本框
 * @date 2022/12/2 16:18
 */
//如果图片加载不出来就用绝对路径
public class experiment8 {
    public static void main(String[] args) {
        WoodFish woodFish = new WoodFish("电子木鱼器", 600, 250, 700, 650);
    }
}

class WoodFish extends JFrame {
    private Box rootBox;
    private Box nameBox;
    private JLabel nameLabel;
    private JTextField nameInput;
    private JButton nameButton;
    private JProgressBar progressBar;
    public static int level = 1;


    public WoodFish(String title, int posX, int posY, int width, int height) {
        init();
        setTitle(title);
        setLocation(posX, posY);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        //根布局
        rootBox = Box.createVerticalBox();
        Component rootV = Box.createVerticalStrut(10);
        Font defaultFont = new Font("", Font.BOLD, 20);

        //姓名框布局
        nameBox = Box.createHorizontalBox();
        Component nameH = Box.createHorizontalStrut(30);
        nameLabel = new JLabel("姓名：");
        nameLabel.setFont(defaultFont);
        nameInput = new JTextField();
        nameInput.setFont(defaultFont);
        nameInput.setColumns(8);
        nameButton = new JButton("确定");
        nameButton.setFont(defaultFont);
        nameBox.add(nameLabel);
        nameBox.add(nameH);
        nameBox.add(nameInput);
        nameBox.add(nameH);
        nameBox.add(nameButton);

        JLabel levelLabel = new JLabel("LV" + level + ": 陈意涵");
        levelLabel.setFont(new Font("", Font.BOLD, 25));
        levelLabel.setVisible(false);

        //进度条
        progressBar = new JProgressBar();
        progressBar.setVisible(true);
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setValue(0);
        progressBar.setPreferredSize(new Dimension(300, 10));
        progressBar.setBorderPainted(true);
        progressBar.setForeground(new Color(32, 121, 212));

        //木鱼
        WoodFishJPanel woodFishJPanel = new WoodFishJPanel(null);
        woodFishJPanel.setLayout(null);
        woodFishJPanel.setBackground(Color.blue);
        woodFishJPanel.setPreferredSize(new Dimension(600, 410));
        JLabel woodFishLabel = new JLabel("功德+1");
        woodFishJPanel.add(woodFishLabel);
        woodFishLabel.setFont(new Font("", Font.BOLD, 25));
        woodFishLabel.setForeground(Color.RED);
        woodFishLabel.setBounds(450, 20, 120, 50);
        woodFishLabel.setVisible(false);
        JLabel levelUpLabel = new JLabel("恭喜您！功德等级提升！功德无量");
        woodFishJPanel.add(levelUpLabel);
        levelUpLabel.setFont(new Font("", Font.BOLD, 25));
        levelUpLabel.setForeground(Color.RED);
        levelUpLabel.setBounds(100, 350, 450, 50);
        levelUpLabel.setVisible(false);


        //敲木鱼按钮
        JButton hitWoodFishBtn = new JButton("敲木鱼");
        hitWoodFishBtn.setFont(defaultFont);
        //vip 敲木鱼
        JButton hitVipWoodFishBtn = new JButton("VIP自动敲木鱼");
        hitVipWoodFishBtn.setFont(defaultFont);
        setLayout(null);
        add(nameBox);
        add(levelLabel);
        add(progressBar);
        add(woodFishJPanel);
        add(hitWoodFishBtn);
        add(hitVipWoodFishBtn);
        nameBox.setBounds(200, 20, 350, 30);
        levelLabel.setBounds(270, 20, 600, 30);
        progressBar.setBounds(40, 70, 600, 30);
        woodFishJPanel.setBounds(40, 120, 600, 400);
        hitWoodFishBtn.setBounds(80, 540, 250, 30);
        hitVipWoodFishBtn.setBounds(350, 540, 250, 30);

        nameButton.addActionListener(new NameBtnListener(nameBox, levelLabel, nameInput));
        hitWoodFishBtn.addActionListener(new HitBtnListener(levelLabel, woodFishLabel, levelUpLabel, progressBar, nameInput));
        hitVipWoodFishBtn.addActionListener(new HitVipBtnListener(levelLabel, woodFishLabel, levelUpLabel, progressBar, nameInput));

    }

}

class WoodFishJPanel extends JPanel {
    public WoodFishJPanel(Object o) {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("D:\\git\\cwolf\\src\\main\\java\\com\\wz\\cwolf\\temp\\woodFish.jpg");//[color=red]图片路径不能固定否则无法动态修改图片[/color]
        g.drawImage(icon.getImage(), 0, 0, null);
    }
}

class NameBtnListener implements ActionListener {
    private Box nameBox;
    private JLabel levelLabel;
    private JTextField nameInput;

    public NameBtnListener() {
    }

    public NameBtnListener(Box nameBox, JLabel levelLabel, JTextField nameInput) {
        this.nameBox = nameBox;
        this.levelLabel = levelLabel;
        this.nameInput = nameInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameInput.getText();
        levelLabel.setText("LV" + WoodFish.level + ": " + name);
        nameBox.setVisible(false);
        levelLabel.setVisible(true);

    }
}

class HitBtnListener implements ActionListener {
    private JLabel levelLabel;
    private JLabel woodFishLabel;
    private JLabel levelUpLabel;
    private JProgressBar progressBar;
    private JTextField nameInput;

    public HitBtnListener() {
    }

    public HitBtnListener(JLabel levelLabel, JLabel woodFishLabel, JLabel levelUpLabel, JProgressBar progressBar, JTextField nameInput) {
        this.levelLabel = levelLabel;
        this.woodFishLabel = woodFishLabel;
        this.levelUpLabel = levelUpLabel;
        this.progressBar = progressBar;
        this.nameInput = nameInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        woodFishLabel.setVisible(false);
        woodFishLabel.setText("功德+" + WoodFish.level * 2);
        woodFishLabel.setVisible(true);
        int charityUp = progressBar.getValue() + WoodFish.level * 2;
        if(WoodFish.level >= 100) {
            progressBar.setValue(100);
            levelUpLabel.setText("佛心四大皆空，贫僧尘念已绝");
            levelUpLabel.setVisible(true);
            return;
        }
        if (charityUp >= 100) {
            progressBar.setValue(100);
            levelUpLabel.setVisible(true);
            progressBar.setValue(0);
            WoodFish.level += 1;
            levelLabel.setText("LV" + WoodFish.level + ": " + nameInput.getText());

        } else {
            progressBar.setValue(charityUp);
            levelUpLabel.setVisible(false);
        }
    }
}


class HitVipBtnListener implements ActionListener {
    private JLabel levelLabel;
    private JLabel woodFishLabel;
    private JLabel levelUpLabel;
    private JProgressBar progressBar;
    private JTextField nameInput;
    private boolean flag = false;

    public HitVipBtnListener() {
    }

    public HitVipBtnListener(JLabel levelLabel, JLabel woodFishLabel, JLabel levelUpLabel, JProgressBar progressBar, JTextField nameInput) {
        this.levelLabel = levelLabel;
        this.woodFishLabel = woodFishLabel;
        this.levelUpLabel = levelUpLabel;
        this.progressBar = progressBar;
        this.nameInput = nameInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!flag) {
            flag = true;
            new Thread() {
                public void run() { // 你的事情都放在这里处理 }
                    while (true) {
                        woodFishLabel.setText("功德+" + WoodFish.level * 2);
                        woodFishLabel.setVisible(true);
                        int charityUp = progressBar.getValue() + WoodFish.level * 2;
                        if(WoodFish.level >= 100) {
                            progressBar.setValue(100);
                            levelUpLabel.setText("佛心四大皆空，贫僧尘念已绝");
                            levelUpLabel.setVisible(true);
                            break;
                        }
                        if (charityUp >= 100) {
                            progressBar.setValue(100);
                            levelUpLabel.setVisible(true);
                            progressBar.setValue(0);
                            WoodFish.level += 1;
                            levelLabel.setText("LV" + WoodFish.level + ": " + nameInput.getText());
                        } else {
                            progressBar.setValue(charityUp);
                            levelUpLabel.setVisible(false);
                        }

                        try {
                            Thread.sleep(500);
                            woodFishLabel.setVisible(false);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }.start();
        }

    }
}
