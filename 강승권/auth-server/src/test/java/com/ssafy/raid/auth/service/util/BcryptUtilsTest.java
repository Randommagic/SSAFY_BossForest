package com.ssafy.raid.auth.service.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BcryptUtilsTest {
	
	@Test
	public void test() {
		assertTrue(BcryptUtils.match("1234","$2a$12$mraqWYi2bVgn4po1O7TB3OnbeGwAr16oiGsPXe4b8nsawwuLYtk.G"));
	}

}
