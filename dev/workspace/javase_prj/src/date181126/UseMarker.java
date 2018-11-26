package date181126;

import date181123.Marker;

public class UseMarker {

	public static void main(String[] args) {
		
		Marker m = new Marker();
		Marker r = new Marker("»¡°£»ö", 5, 5);
		
		System.out.printf("%s»ö ¸¶Ä«´Â ¶Ñ²± %d°³ ¸öÃ¼ %d°³ ÀÖ½À´Ï´Ù.\n",
				m.getColor(), m.getCap(), m.getBody());
		
		System.out.printf("%s»ö ¸¶Ä«´Â ¶Ñ²± %d°³ ¸öÃ¼ %d°³ ÀÖ½À´Ï´Ù.\n",
				r.getColor(), r.getCap(), r.getBody());
		
	}
}
