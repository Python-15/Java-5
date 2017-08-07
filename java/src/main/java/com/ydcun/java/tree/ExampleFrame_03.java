package com.ydcun.java.tree;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ExampleFrame_03 extends JFrame {

	private DefaultMutableTreeNode root;

	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}

	public ExampleFrame_03() {
		super();
		setTitle("遍历树节点");
		setBounds(100, 100, 290, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		root = new DefaultMutableTreeNode("ROOT");

		DefaultMutableTreeNode nodeFirstA = new DefaultMutableTreeNode("FirstA");
		nodeFirstA.add(new DefaultMutableTreeNode("SecondAA"));
		nodeFirstA.add(new DefaultMutableTreeNode("SecondAB"));
		root.add(nodeFirstA);

		DefaultMutableTreeNode nodeFirstB = new DefaultMutableTreeNode("FirstB");
		root.add(nodeFirstB);

		DefaultMutableTreeNode nodeFirstC = new DefaultMutableTreeNode("FirstC");
		nodeFirstC.add(new DefaultMutableTreeNode("SecondCA"));
		DefaultMutableTreeNode nedeSecondCB = new DefaultMutableTreeNode(
				"SecondCB");
		nedeSecondCB.add(new DefaultMutableTreeNode("SecondCBA"));
		nedeSecondCB.add(new DefaultMutableTreeNode("SecondCBB"));
		nodeFirstC.add(nedeSecondCB);
		nodeFirstC.add(new DefaultMutableTreeNode("SecondCC"));
		root.add(nodeFirstC);

		JTree tree = new JTree(root);
		getContentPane().add(tree, BorderLayout.CENTER);

		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		getContentPane().add(panel, BorderLayout.EAST);

		final JButton button = new JButton("按前序遍历节点");
		button.addActionListener(new ButtonActionListener("按前序遍历"));
		panel.add(button);

		final JButton button_1 = new JButton("按后序遍历节点");
		button_1.addActionListener(new ButtonActionListener("按后序遍历"));
		panel.add(button_1);

		final JButton button_2 = new JButton("以广度优先遍历");
		button_2.addActionListener(new ButtonActionListener("以广度优先遍历"));
		panel.add(button_2);

		final JButton button_3 = new JButton("以深度优先遍历");
		button_3.addActionListener(new ButtonActionListener("以深度优先遍历"));
		panel.add(button_3);

		final JButton button_4 = new JButton("遍历直属子节点");
		button_4.addActionListener(new ButtonActionListener("遍历子节点"));
		panel.add(button_4);
		//
	}

	private class ButtonActionListener implements ActionListener {

		private String mode;

		public ButtonActionListener(String mode) {
			this.mode = mode;
		}

		public void actionPerformed(ActionEvent e) {
			Enumeration enumeration;// 声明节点枚举对象
			if (mode.equals("按前序遍历"))
				enumeration = root.preorderEnumeration(); // 按前序遍历所有树节点
			else if (mode.equals("按后序遍历"))
				enumeration = root.postorderEnumeration();// 按后序遍历所有树节点
			else if (mode.equals("以广度优先遍历"))
				enumeration = root.breadthFirstEnumeration();// 以广度优先遍历所有树节点
			else if (mode.equals("以深度优先遍历"))
				enumeration = root.depthFirstEnumeration(); // 以深度优先遍历所有树节点
			else
				enumeration = root.children(); // 遍历该节点的子节点
			while (enumeration.hasMoreElements()) {// 遍历节点枚举对象
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration
						.nextElement();// 获得节点
				for (int l = 0; l < node.getLevel(); l++) {// 根据节点级别输出占位符
					System.out.print("----");
				}
				System.out.println(node.getUserObject());// 输出节点标签
			}
			System.out.println();
			System.out.println();
		}
	}

}
