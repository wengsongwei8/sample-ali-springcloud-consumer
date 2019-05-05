package com.weng.framework.sample.consumer.controller;

import com.weng.framework.core.model.ResponseData;
import com.weng.framework.sample.consumer.feign.UserServiceFeign;
import com.weng.framework.sample.consumer.model.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/*
 * 测试类
 * 记录启动类中记得添加注解：@EnableFeignClients
 * @param
 * @return
 */
@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserServiceFeign userServiceFeign;

	@Autowired
	private DiscoveryClient discoveryClient;



	@GetMapping("/feign/user/get" )
	public ResponseData get(String id) {
		return userServiceFeign.get(id);
	}

	@GetMapping(value = "/feign/user/list")
	public ResponseData list(Integer pageNo,Integer pageSize){
		return userServiceFeign.list(pageNo, pageSize);
	}

	@PostMapping(value = "/feign/user/add")
	public ResponseData add(@Valid @RequestBody UserReq userReq) {
		return userServiceFeign.add(userReq);
	}

	@PostMapping(value = "/feign/user/update")
	public ResponseData update(@Valid @RequestBody UserReq userReq) {
		return userServiceFeign.update(userReq);
	}

	@PostMapping(value = "/feign/user/delete")
	public ResponseData delete(@RequestParam("ids") String ids) {
		return userServiceFeign.delete(ids);
	}



	@RequestMapping(value = "/services/{service}", method = RequestMethod.GET)
	public Object client(@PathVariable String service) {
		return discoveryClient.getInstances(service);
	}

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public Object services() {
		return discoveryClient.getServices();
	}
}
