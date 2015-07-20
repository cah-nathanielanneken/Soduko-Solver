import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu {

	private JFrame guiFrame;
	private CardLayout card;
	private JPanel cardPanel;
	private JButton switchCards;
	
	public Menu() {
		setFrame();
        
        card = new CardLayout();
        cardPanel = new JPanel(card);
        
        JPanel tabsPanel = new JPanel();
        tabsPanel.setLayout(new GridLayout(0,1));
        switchCards = new JButton("Solver");
        switchCards.setActionCommand("Solver");
        switchCards.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                card.show(cardPanel, "Solver");
            }
        });
        //JButton puzzleGenerator = new JButton("New Soduko Puzzle");
        //puzzleGenerator.addActionListener(new ActionListener()
        //{
           // @Override
            //public void actionPerformed(ActionEvent event)
            //{
              //  card.show(cardPanel, "New Soduko Puzzle");
           // }
        //});
        JButton info = new JButton("Information");
        info.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	System.exit(0);
            }
        });
        tabsPanel.add(switchCards);
        //tabsPanel.add(puzzleGenerator);
        tabsPanel.add(info);
        tabsPanel.add(exit);
        
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());
        JLabel title = new JLabel("Soduko");
		Font f = new Font("Veranda", Font.BOLD, 40);
		title.setFont(f);
		JPanel top = new JPanel();
		top.setBackground(Color.LIGHT_GRAY);
		top.setLayout(new FlowLayout());
		top.add(title);
        menu.add(tabsPanel, BorderLayout.CENTER);
        menu.add(top, BorderLayout.NORTH);
        
        
        tabsPanel.setBackground(Color.cyan);
        
        GUI g = new GUI();
        GeneratorGUI h = new GeneratorGUI();
        JButton back1 = g.getBack();
        JButton back2 = h.getBack();
        back1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                card.previous(cardPanel);
            }
        });
        back2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                card.show(cardPanel, "Menu");
            }
        });
        
        cardPanel.add(menu, "Menu");
        cardPanel.add(g.getFrame(), "Solver");
        //cardPanel.add(h.getFrame(), "New Soduko Puzzle");
        card.show(cardPanel, "Menu");
        
        guiFrame.add(cardPanel, BorderLayout.CENTER);
        guiFrame.setVisible(true);
        
	}
	
	private void setFrame() {
		guiFrame = new JFrame();
		guiFrame.setTitle("Soduko");
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setSize(700,700);
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setLayout(new BorderLayout());
	}
	
	public static void main(String[] args) {
	     
        //Use the event dispatch thread for Swing components
        EventQueue.invokeLater(new Runnable()
        {
            
           @Override
            public void run()
            {
                
                new Menu();         
            }
        });
             
   }
}
