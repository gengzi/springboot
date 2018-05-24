package club.gsjblog.springboot.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "author")
/**
 * 类型安全的配置
 * @author Administrator
 *
 */
public class AuthorSettings {

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AuthorSettings [name=" + name + ", age=" + age + "]";
	}
	
	
}
