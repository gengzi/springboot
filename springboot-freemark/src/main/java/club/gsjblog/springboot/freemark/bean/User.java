package club.gsjblog.springboot.freemark.bean;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;  
	private int age;
	private boolean ismarry; //是否结婚
	private List<String> username = new ArrayList<String>(); // 网名
	
	private List<Hobby> hobbys = new ArrayList<Hobby>(); //爱好
	
	public List<Hobby> getHobbys() {
		return hobbys;
	}
	public void setHobbys(List<Hobby> hobbys) {
		this.hobbys = hobbys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isIsmarry() {
		return ismarry;
	}
	public void setIsmarry(boolean ismarry) {
		this.ismarry = ismarry;
	}
	public List<String> getUsername() {
		return username;
	}
	public void setUsername(List<String> username) {
		this.username = username;
	}
	

}
