package date181126;

import date181123.Marker;

public class UseMarker {

	public static void main(String[] args) {
		
		Marker m = new Marker();
		Marker r = new Marker("������", 5, 5);
		
		System.out.printf("%s�� ��ī�� �Ѳ� %d�� ��ü %d�� �ֽ��ϴ�.\n",
				m.getColor(), m.getCap(), m.getBody());
		
		System.out.printf("%s�� ��ī�� �Ѳ� %d�� ��ü %d�� �ֽ��ϴ�.\n",
				r.getColor(), r.getCap(), r.getBody());
		
	}
}
