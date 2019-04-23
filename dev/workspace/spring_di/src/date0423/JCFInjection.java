package date0423;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JCFInjection {

	private Set<String> set;
	
	private List<String> list;
	private Map<String, String> map;
	
	public JCFInjection(Map<String,String> map) {
		this.map = map;
		System.out.println("Map Injection");
	}
	
	public Map<String,String> getMap() {
		return map;
	}
	
	
	private List<TestVO> voList;
	public JCFInjection(List<TestVO> voList, int i) {
		this.voList = voList;
		System.out.println("voList Injection");
	}
	
	public JCFInjection(List<String> list) {
		this.list = list;
		System.out.println("List Injection");
	}
	
	public JCFInjection(Set<String> set) {
		this.set = set;
		System.out.println("Set Injection");
	}
	
	public List<String> getList() {
		return list;
	}
	
	public Set<String> getSet() {
		return set;
	}
	
	public List<TestVO> getVoList() {
		return voList;
	}
}
