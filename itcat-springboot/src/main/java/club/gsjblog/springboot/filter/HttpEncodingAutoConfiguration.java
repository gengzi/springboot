package club.gsjblog.springboot.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import club.gsjblog.springboot.settings.HttpEncodingProperties;

/**
 *  
 * @author Administrator
 *
 */
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class)
@ConditionalOnClass(CharacterEncodingFilter.class)
@ConditionalOnProperty(prefix="spring.http.encoding",value="enabled",matchIfMissing= true)
public class HttpEncodingAutoConfiguration {
	
	@Autowired
	private HttpEncodingProperties httpEncodingProperties;

	@Bean
	@ConditionalOnMissingBean(CharacterEncodingFilter.class)
	public CharacterEncodingFilter characterEncodingFilter(){
		CharacterEncodingFilter characterEncodingFilter  = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding(this.httpEncodingProperties.getCharset().name());
		characterEncodingFilter.setForceEncoding(this.httpEncodingProperties.isForce());
		return characterEncodingFilter;
	}
}
