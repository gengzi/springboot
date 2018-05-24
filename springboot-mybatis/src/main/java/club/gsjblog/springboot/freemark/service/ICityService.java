package club.gsjblog.springboot.freemark.service;

import club.gsjblog.springboot.freemark.bean.City;

/**
 * 城市业务逻辑接口
 * @author gengzi
 * @time 2018年5月24日16:31:05
 *
 */
public interface ICityService {
	
	/**
	 * 根据城市名称查询城市信息
	 * @param cityname 城市名称
	 * @return City
	 */
	City findCityInfo(String cityname);

}
