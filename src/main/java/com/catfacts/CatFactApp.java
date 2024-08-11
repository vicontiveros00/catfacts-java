package com.catfacts;

import java.awt.BorderLayout; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CatFactApp {
    public static void main(String[] args) {
        // System.out.println(APIUtils.callMeowFacts());
        
        JFrame frame = new JFrame("Cat Fact Generator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel factLabel = new JLabel("Click the button to get a cat fact!", JLabel.CENTER);
        panel.add(factLabel, BorderLayout.CENTER);

        JButton getFactButton = new JButton("Get Cat Fact");
        panel.add(getFactButton, BorderLayout.SOUTH);

        getFactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String catFact = APIUtils.callMeowFacts();
                if (catFact != null && !catFact.isEmpty()) {
                    factLabel.setText("<html>" + catFact + "</html>");
                } else {
                    factLabel.setText("Failed to get cat fact, check logs");
                }
            }
        });

        frame.setVisible(true);
    }
}