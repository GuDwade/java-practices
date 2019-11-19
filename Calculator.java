import   java.awt.BorderLayout;
public class  Calculator extends JFrame{
	private static final long serialVersionUID=6626440733001287873L;
	private JTextField textField;
	private static void main(String[]args){
		try{
			UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Throwable e){
			e.printStackTrace();
		}
		Calculator frame=new Calculator();
		frame.setVisible(true);
	}
	public Calculator(){
		super();
		BorderLayout borderLayout=(BorderLayout)getContentPane().getLayout();
		borderLayout.setHgap(20);
		borderLayout.setVgap(20);
		setTitle("按钮数组实现计算器界面");
		setBounds(100,100,290,282);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField=new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setPreferredSize(new DImension(12,50));
		getContentPane().add(textField,BorderLayout.NORTH);
		textField.setColumns(10);
		final GridLayout gridLayout=new GirdLayout(4,0);
		gridLayout.setHgap(5);
		gridLayout.setVgap(5);
		JPanel panel=new JPanel();
		panel.setLayout(gridLayout);
		getContentPane().add(panel,BorderLayout.CENTER);
		String[][]names={{"1","2","3","+"},{"4","5","6","-"},{"7","8","9","*"},{".","0","=","/"}};
		JButton[][]buttons=new JButton[4][4];
		for(int row=0;row<names.length;row++){
			for(int col=0;col<names.length;col++){
				buttons[row][col]=new JButton(names[row][col]);
				panel.add(buttons[row][col]);
			}
		}
	}
}