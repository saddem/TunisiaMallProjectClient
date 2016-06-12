package com.swing.luncher;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Client;
import com.esprit.entity.Utilisateur;
import com.swing.variableSession.VariableSession;

import delegate.UserServiceDelegate;

class UserLoginOld extends JFrame {
	JButton login, cancel;
	JTextField uname;
	JPasswordField pass;
	JLabel u, p;

	public UserLoginOld() {
		setTitle("Login");
		setLayout(new GridLayout(3, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		u = new JLabel("Username");
		p = new JLabel("Password");

		uname = new JTextField(20);
		pass = new JPasswordField(20);

		login = new JButton("Login");
		cancel = new JButton("Cancel");

		add(u);
		add(uname);

		add(p);
		add(pass);

		add(login);
		add(cancel);

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String un = uname.getText();
				String pa = new String(pass.getPassword());
				SuperAdmin u = new SuperAdmin();
				u.setLogin(un);
				u.setPassword(pa);
				Client u1 = new Client();
				u1.setLogin(un);
				u1.setPassword(pa);
				SuperAdmin admin = (SuperAdmin) UserServiceDelegate.getProxy().auth(u);
				Client client=(Client) UserServiceDelegate.getProxy().auth(u1);
				if ( admin!= null){
					VariableSession.getInstance().setCurrentUser(admin);
					dispose();
					 new FrameWelcome();
					 
				} else if ( client != null) {
					VariableSession.getInstance().setCurrentUser(client);
					dispose();
					 new FrameWelcome();
				} else {

					JOptionPane optionPane = new JOptionPane("Mdp inccorect ou nom utilisateur inccorect",
							JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}
		});

		KeyAdapter k = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER)
					login.doClick();
			}
		};

		pass.addKeyListener(k);
		uname.addKeyListener(k);

		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		new UserLoginOld();
	}

}