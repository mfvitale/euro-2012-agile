package com.uefa;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Eruro2012Gui {

	private String filePath;
	private JFrame frame;
	private final Action action = new Open();
	private FileMgmt filemgmt;
	private JList listsquadre;
	private DefaultListModel model;
	private JList list_1;
	private JList list_2;
	private JList list_3;
	private JList list_4;
	private JLabel lblSquadrePartecipanti;
	private JLabel lblGruppoA;
	private JLabel lblGruppoB;
	private JLabel lblGruppoC;
	private JLabel lblGruppoD;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eruro2012Gui window = new Eruro2012Gui();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Eruro2012Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open..");
		mntmOpen.setAction(action);
		mntmOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnFile.add(mntmOpen);
		
		model = new DefaultListModel();
		listsquadre = new JList(model);
		
		list_1 = new JList();
		
		list_2 = new JList();
		
		list_3 = new JList();
		
		list_4 = new JList();
		
		JButton btnGenera = new JButton("Genera");
		btnGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generaGironi();
			}

			private void generaGironi() 
			{
				if(filemgmt != null)
				{
					filemgmt.sort();
					
					HashMap<String, ArrayList<String>> groups = filemgmt.getGroups();
					
					list_1.setListData(groups.get("A").toArray());
					list_2.setListData(groups.get("B").toArray());
					list_3.setListData(groups.get("C").toArray());
					list_4.setListData(groups.get("D").toArray());
				}
				
			}
		});
		
		lblSquadrePartecipanti = new JLabel("Squadre Partecipanti");
		
		lblGruppoA = new JLabel("Gruppo A");
		
		lblGruppoB = new JLabel("Gruppo B");
		
		lblGruppoC = new JLabel("Gruppo C");
		
		lblGruppoD = new JLabel("Gruppo D");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Workspace eclipse\\Ericsson\\Uefa\\src\\main\\resources\\logo.jpg"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(listsquadre, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSquadrePartecipanti))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGruppoA))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list_4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGruppoB))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGruppoC))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGruppoD)
								.addComponent(list_3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGenera)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGruppoA)
								.addComponent(lblGruppoB)
								.addComponent(lblGruppoC)
								.addComponent(lblGruppoD))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(list_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addComponent(list_3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(btnGenera))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(29)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSquadrePartecipanti)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listsquadre, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {list_1, list_2, list_3, list_4});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {list_1, list_2, list_3, list_4});
		frame.getContentPane().setLayout(groupLayout);
	}

	private class Open extends AbstractAction {
		public Open() {
			putValue(NAME, "Open..");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File("D:\\Workspace eclipse\\Ericsson\\Uefa"));
			 // Demonstrate "Open" dialog:
		      int rVal = fileChooser.showOpenDialog(frame);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        filePath = fileChooser.getCurrentDirectory().getPath()+"\\"+fileChooser.getSelectedFile().getName();
		        
		        loadTeams(filePath);
		        
		      }
		      if (rVal == JFileChooser.CANCEL_OPTION) {
		       // fileName.setText("You pressed cancel");
		        //dir.setText("");
		      }
		}
		private void loadTeams(String filePath) {
			filemgmt = new FileMgmt(filePath);
			
			listsquadre.setListData(filemgmt.loadTeamList().toArray());
			//model.addElement(filemgmt.loadTeams().toString());
			
		}
	}
}
