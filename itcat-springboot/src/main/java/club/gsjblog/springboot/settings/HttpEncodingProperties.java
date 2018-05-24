package club.gsjblog.springboot.settings;

import java.nio.charset.Charset;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.http.encoding")
/**
 * 配置http的编码方式
 * @author Administrator
 *
 */
public class HttpEncodingProperties {
	
	//默认的编码方式是 utf-8
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	private Charset  charset = DEFAULT_CHARSET;
	
	private boolean force  = true;

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public boolean isForce() {
		return force;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

}
