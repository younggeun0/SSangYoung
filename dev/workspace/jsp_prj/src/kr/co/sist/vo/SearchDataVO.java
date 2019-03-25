package kr.co.sist.vo;

public class SearchDataVO {
	
	private String fieldName, keyword;
	
	public SearchDataVO() {
	}

	public SearchDataVO(String fieldName, String keyword) {
		this.fieldName = fieldName;
		this.keyword = keyword;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getKeyword() {
		return keyword;
	}

	@Override
	public String toString() {
		return "SearchDataVO [fieldName=" + fieldName + ", keyword=" + keyword + "]";
	}
}
