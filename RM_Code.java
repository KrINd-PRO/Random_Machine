import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RM_Code {

    private int Items[] = new int[3];
    private int points = 0;
    private int bonus = 1;

    public RM_Code() {
        // Create the frame
        JFrame frame = new JFrame("Simple Frame");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        // Create the panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 400));
        panel.setLayout(null);

        // Create image labels
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        // Load and scale images
        ImageIcon imageIcon1 = new ImageIcon("Java_1.png");
        ImageIcon imageIcon2 = new ImageIcon("C_1.png");
        ImageIcon imageIcon3 = new ImageIcon("Python_1.png");
        ImageIcon imageIcon4 = new ImageIcon("LABEL_1.png");
        ImageIcon imageIcon5 = new ImageIcon("SPIN_1.png");

        // Set scaled icons for image labels
        label1.setIcon(scaleImage(imageIcon1, 200, 200));
        label2.setIcon(scaleImage(imageIcon2, 200, 200));
        label3.setIcon(scaleImage(imageIcon3, 200, 200));
        label4.setIcon(scaleImage(imageIcon4, 500, 200));
        label5.setIcon(scaleImage(imageIcon5, 100, 200));

        // Set layout with custom horizontal and vertical gaps
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        panel.setLayout(flowLayout);

        label4.setText("Points: " + points);
        label4.setHorizontalTextPosition(JLabel.CENTER);
        
        // Add MouseListener to label5
        label5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                Random random = new Random();
                Items[0] = random.nextInt(3);
                Items[1] = random.nextInt(3);
                Items[2] = random.nextInt(3);

                for(int i = 0; i < Items.length; i ++){
                    
                    switch(i){
                        case 0 -> {
                            switch (Items[i]) {
                                case 0 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Python_1.png");
                                    label1.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 1 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("C_1.png");
                                    label1.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 2 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Java_1.png");
                                    label1.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                default -> {
                                }
                            }
                        }

                        case 1 -> {
                            switch (Items[i]) {
                                case 0 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Python_1.png");
                                    label2.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 1 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("C_1.png");
                                    label2.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 2 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Java_1.png");
                                    label2.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                default -> {
                                }
                            }
                        }

                        case 2 -> {
                            switch (Items[i]) {
                                case 0 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Python_1.png");
                                    label3.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 1 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("C_1.png");
                                    label3.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                case 2 ->                                     {
                                    ImageIcon newImageIcon = new ImageIcon("Java_1.png");
                                    label3.setIcon(scaleImage(newImageIcon, 200, 200));
                                }
                                default -> {
                                }
                            }
                        }
                    }
                    
                    if(Items[i] == 1){bonus += 1;}
                    if(Items[i] == 2){bonus += 2;}

                    if(i != 0 && Items[i] == Items[i - 1]){
                        bonus *= 2;
                        if(bonus == 24){
                            bonus = 100;
                        }
                    }
                }
                
                points += bonus;
                label4.setText("Points: " + points);
                if(bonus == 100){label4.setText("JACKPOT!!!");}
                System.out.println(bonus);
                bonus = 1;
            }
        });
        
        // Add image labels to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label5);
        panel.add(label4);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.pack();

        frame.setVisible(true);
    }

    // Method to scale images
    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}