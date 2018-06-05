package club.gsjblog.springboot.freemark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjblog.springboot.freemark.bean.City;
import club.gsjblog.springboot.freemark.bean.CityExample;
import club.gsjblog.springboot.freemark.bean.CityExample.Criteria;
import club.gsjblog.springboot.freemark.dao.CityMapper;
import club.gsjblog.springboot.freemark.service.ICityService;

/**
 *  城市业务逻辑接口实现
 * @author gengzi
 * @time 2018年5月24日16:32:57
 *
 */
@Service
public class CityServiceImpl implements ICityService{

	@Autowired
	private CityMapper mapper;
	
	
	@Override
	public City findCityInfo(String cityname) {
		CityExample example  = new CityExample();
		Criteria cityCriteria = example.createCriteria();
		cityCriteria.andCityNameEqualTo(cityname);
		List<City> citys = mapper.selectByExample(example);
		if (citys.size() > 0 ) {
			return citys.get(0);
		}
		return null;
	}
	
	

}
