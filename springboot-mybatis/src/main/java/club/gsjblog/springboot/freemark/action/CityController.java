package club.gsjblog.springboot.freemark.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

	/**
	 *  produces  还可以写成常亮
	 * @param cityname
	 * @return
	 */
	@RequestMapping(value="/api/city/{cityname}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public City findOneCity1(@PathVariable("cityname") String cityname) {
		return cityservice.findCityInfo(cityname);
	}


	/**
	 *  produces  还可以写成常亮
	 * @param cityname
	 * @return
	 */
//	@RequestMapping(value="/api/city/{cityname}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping(value = "/api/city/{cityname}/{cityarea}")
	@ResponseBody
	public String findOthers(@PathVariable("cityname") String cityname ,
						   @MatrixVariable(value = "low" , pathVar = "cityarea") int filterParams,@RequestParam String param) {

		System.out.println(cityname);
//        Set<String> cityareas = filterParams.keySet();
//        if (cityareas.contains("low")){
//            List<String> low = filterParams.get("low");
//            for (String  str: low) {
//                System.out.println("low"+str);
//            }
//        }
        System.out.println(filterParams);

        System.out.println(param);

		return "";
	}



}
