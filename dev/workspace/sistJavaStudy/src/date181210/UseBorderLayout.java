package date181210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * �Ϲ� Component�� LayoutManager�� ���
 * @author owner
 */
// 1. Window Component�� ���(����ڿ��� �������� ��)
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame {

	public UseBorderLayout() {
		super("BorderLayout ����");
		// 2. ����� �Ϲ� ������Ʈ�� ����
		TextField tfNorth = new TextField("North");
		Label lblEast = new Label("East");
		TextArea taCenter = new TextArea("Center");
		Label lblWest = new Label("West");
		Choice choSouth = new Choice();
		choSouth.add("South");
		
		// 3. ��ġ������ ����
		// Window Component�� Frame�̳� Dialog�� BoarderLayout�� �⺻ ����  
		setLayout(new BorderLayout());
		
		// 4.������Ʈ�� ��ġ�����ڸ� ����Ͽ� ��ġ
		// add("��ġ��ġ", ������Ʈ); add(���, ������Ʈ);
		// add(������Ʈ, ���); .. 
		// ���ڿ� ����� ����Ͽ� ��ġ
		add("North", tfNorth);
		// Center�� ��ġ�ϸ� �׵θ�(��������)�� �������. 
		add("Center", taCenter);
		// Constant( Field )�� ����Ͽ� ��ġ
		add(BorderLayout.EAST, lblEast);
		add(BorderLayout.WEST, lblWest);
		add(BorderLayout.SOUTH, choSouth);
		
		// 5. ������ ũ�� ����
		setSize(400, 400);
		
		// 6. ����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		
		// ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new UseBorderLayout();
	}
}
