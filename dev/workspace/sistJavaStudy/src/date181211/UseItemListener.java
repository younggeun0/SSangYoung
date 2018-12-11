package date181211;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ItemEvent를 처리하는 ItemListener의 사용
 * @author owner
 */
@SuppressWarnings("serial")
// 1. Frame 상속, 이벤트를 처리할 수 있는 itemListener를 구현
public class UseItemListener extends Frame implements ItemListener {

	private List list;
	private Label lbl;

	public UseItemListener() {
		
		list = new List();
		list.add("이재찬/27");
		list.add("정택성/26");
		list.add("공선의/27");
		lbl = new Label("이름 :                           나이 : ");
		
		add(BorderLayout.CENTER, list);
		add(BorderLayout.SOUTH, lbl);
		
		list.addItemListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new UseItemListener();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 리스트의 아이템이 선택되면 선택한 아이템을 가져와서
		// 라벨의 값 변경
		String[] nameAndAge = list.getSelectedItem().split("/");
		String name = nameAndAge[0];
		String age = nameAndAge[1];
		// 긴 문자열이기 때문에 StringBuilder로 처리
		StringBuilder viewData = new StringBuilder();
		viewData.append("이름 : ").append(name).append("              나이 : ").append(age);
		lbl.setText(viewData.toString());
	}
}
