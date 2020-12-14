package com.example.demo;



import com.example.demo.entity.Params;
import com.example.demo.repository.ParamsRepository;

import java.util.Objects;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void testRedis() {
		redisTemplate.opsForValue().set("ok", "test");
		assert Objects.nonNull(redisTemplate.opsForValue().get("ok"));
	}

	@Autowired
	ParamsRepository paramsRepository;

	@Test
	public void testInsert() {
		Random random = new Random();
		Params params = new Params();
		params.setParam1("id1-" + random.nextInt(100));
		params.setParam2("id2-" + random.nextInt(100));
		assert Objects.nonNull( paramsRepository.save(params));
	}

}
