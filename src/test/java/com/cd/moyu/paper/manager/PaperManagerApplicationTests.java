package com.cd.moyu.paper.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cd.moyu.paper.manager.exception.NormalException;
import com.cd.moyu.paper.manager.po.User;
import com.cd.moyu.paper.manager.service.PaperService;
import com.cd.moyu.paper.manager.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class PaperManagerApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	PaperService paperService;

	@Test
	void testService() throws NormalException {
		System.out.println(paperService.getFileNameFromUrl("./temp/hello.txt"));
	}

}
