package club.gsjblog.springboot.freemark.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import club.gsjblog.springboot.freemark.bean.City;
import club.gsjblog.springboot.freemark.service.ICityService;


@Controller
public class CityController {
	
	@Autowired
	private ICityService cityservice;

	@RequestMapping(value="/api/city/{cityname}",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public City findOneCity(@PathVariable("cityname") String cityname) {
	  return cityservice.findCityInfo(cityname);
	}
	
	/**
	 * @ResponseBody 将响应信息转化为json
	 * @RequestMapping 匹配请求
	 *      value - 请求的路径  {cityname} 路径中的参数 restful 风格
	 * 		produces - 指定响应的数据类型，加上 produces 防止中文乱码
	 *      method - 指定请求的方法类型：POST/GET/DELETE/PUT 等
	 *      consumes - 指定处理请求的提交内容类型，例如 Content-Type 头部设置application/json, text/html
	 *      params - 指定request中必须包含某些参数值是，才让该方法处理
	 * @PathVariable("cityname") String cityname URL 映射时，用于绑定请求参数到方法参数
	 * 
	 */

}
