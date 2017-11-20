/*
 * Copyright (c) 2017年11月20日13时34分52秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.test;
import com.linjiahao.computer.data.GetUndergroundMileage;
import org.junit.Test;

import static org.junit.Assert.*;
public class GetUndergroundMileageTest {
	@Test
	public void testSearch() throws Exception {
		GetUndergroundMileage getUndergroundMileage = new GetUndergroundMileage();
		getUndergroundMileage.search("小北");
	}
}