package club.gsjblog.springboot.freemark.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import club.gsjblog.springboot.freemark.bean.Hobby;
import club.gsjblog.springboot.freemark.bean.User;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello01(Model model, Map<String, Object> map) {
		map.put("name", "¹¢Ë§¼Ñ");
		map.put("age", 22);

		User user = new User();
		user.setName("ÕÅ¾ê");
		user.setAge(22);
		user.setIsmarry(false);
		ArrayList<String> usernames = new ArrayList<String>();
		usernames.add("Ð¡ÏÉÅ®");
		usernames.add("¿É°®");
		user.setUsername(usernames);
		
		List<Hobby> hobbys = user.getHobbys();
		Hobby hobby = new Hobby();
		hobby.setHobbyname("ÀºÇò");
		hobby.setHobbylike(1);
		
		Hobby hobby1 = new Hobby();
		hobby1.setHobbyname("×ÔÐÐ³µ");
		hobby1.setHobbylike(2);
		
		hobbys.add(hobby);
		hobbys.add(hobby1);
		
		user.setHobbys(hobbys);
		
		

		map.put("object1", user);
		map.put("name2", "¹¢Ë§¼Ñ");
		map.put("name3", "¹¢Ë§¼Ñ");
		return "hello";
	}

}
