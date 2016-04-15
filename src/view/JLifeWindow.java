package view;

import controller.JGameController;
import model.JUniverse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

/**
 * Created by eroshin on 15.04.2016.
 */
public class JLifeWindow extends JFrame implements ActionListener {

    private JButton button1;
    public java.util.Timer timer;

    public int size = 20;

    public JGameController game;

    public JLifeWindow(){
        super("Life");
        setBounds(100,100,740,580);

        game = new JGameController(20);
        timer = new Timer();

        button1 = new JButton("1 day");
        button1.addActionListener(this);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(button1);
        add(panel);
        printField(game.getCurUniverse());
        timer.schedule(new myTimer(),1000,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JLifeWindow game = new JLifeWindow();
        game.setVisible(true);
    }

    public void printField(JUniverse uni){
        for(int i=0;i<uni.getUniverseSize();i++){
            for(int j=0;j<uni.getUniverseSize();j++){
                if(uni.getCell(new int[]{j,i}).isLive()) System.out.print("0");
                else System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.println("====================================");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.getIsGame()) printField(game.getCurUniverse());
        game.liveOneDay();
        repaint();
    }

    public void paint(Graphics g){
        for (int i=0;i<game.getCurUniverse().getUniverseSize();i++)
            for(int j=0;j<game.getCurUniverse().getUniverseSize();j++){
                g.setColor(Color.white);
                if(game.getCurUniverse().getCell(new int[]{i,j}).isLive()){
                    g.setColor(Color.gray);
                }
                g.drawRect(size+i*size,size+j*size,size,size);
                g.fillRect(size+i*size,size+j*size,size,size);
            }

    }

    public class myTimer extends TimerTask{
        @Override
        public void run() {
            if(game.getIsGame()) printField(game.getCurUniverse());
            game.liveOneDay();
            repaint();
        }
    }
}
