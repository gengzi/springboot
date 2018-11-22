package club.gsjblog.springboot.freemark.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import club.gsjblog.springboot.freemark.future.RealData;
import club.gsjblog.springboot.freemark.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import club.gsjblog.springboot.freemark.bean.Hobby;
import club.gsjblog.springboot.freemark.bean.User;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

@Controller
public class HelloController {

	private FutureTask<String> futureTask;

	private Map<String,Future<String>> stringFuture = new HashMap<String, Future<String>>();

	//private SimpleAsyncTaskExecutor executorService;

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	@Autowired
	private AsyncService service;
	

	@RequestMapping("/hello")
	public String hello01(Model model, Map<String, Object> map) {
		map.put("name", "��˧��");
		map.put("age", 22);

		User user = new User();
		user.setName("�ž�");
		user.setAge(22);
		user.setIsmarry(false);
		ArrayList<String> usernames = new ArrayList<String>();
		usernames.add("С��Ů");
		usernames.add("�ɰ�");
		user.setUsername(usernames);
		
		List<Hobby> hobbys = user.getHobbys();
		Hobby hobby = new Hobby();
		hobby.setHobbyname("����");
		hobby.setHobbylike(1);
		
		Hobby hobby1 = new Hobby();
		hobby1.setHobbyname("���г�");
		hobby1.setHobbylike(2);
		
		hobbys.add(hobby);
		hobbys.add(hobby1);
		
		user.setHobbys(hobbys);
		
		

		map.put("object1", user);
		map.put("name2", "��˧��");
		map.put("name3", "��˧��");
//		map.put("name4","��˧��");
		return "hello";
	}


	@RequestMapping("/hellotwo")
	public String hello02(Model model, Map<String, Object> map) {
		map.put("result","数据同步开始，请稍等");
		futureTask = new FutureTask<String>(new RealData("Hello"));
		executorService.execute(futureTask);
		return "hello";
	}


	@RequestMapping("/querydata")
	public String hello03(Model model, Map<String, Object> map) {
		map.put("result","数据同步开始，请稍等");
		String  str  ="请稍等";
		try {
			//异步任务完成并且未被取消，则获取返回的结果
			if(futureTask.isDone() && !futureTask.isCancelled()){
				str = futureTask.get();
				System.out.println(str);
				map.put("result",str);
				return "hello";
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		map.put("result","还未完成，请稍等");
		return "hello";
	}





	@RequestMapping("/aysncrequest/{path}")
	public String hello04(@PathVariable(value = "path") Integer path, Model model, Map<String, Object> map) {
		map.put("result","数据同步开始，请稍等");
        stringFuture.put(""+path,service.asyncInvokeReturnFuture(path));

        return "hello";
	}


	@RequestMapping("/aysncresult/{path}")
	public String hello05(Model model, Map<String, Object> map,@PathVariable(value = "path") Integer path) {
		map.put("result","数据同步开始，请稍等");
		String  str  ="请稍等";
		try {
			
			//异步任务完成并且未被取消，则获取返回的结果
			if(stringFuture.get(path+"").isDone() && !stringFuture.get(path+"").isCancelled()){
				str = stringFuture.get(path+"").get();
				System.out.println(str);
				map.put("result",str);
				return "hello";
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		map.put("result","还未完成，请稍等");
		return "hello";
	}






}
