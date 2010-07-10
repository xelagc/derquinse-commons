/*
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.derquinse.common.base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

/**
 * Tests for CIString
 * @author Andres Rodriguez
 */
public class CIStringTest {
	private static final String VALUE0 = "VaLue0";
	private static final String VALUE1 = "VaLuE1";

	/**
	 * Test equality.
	 */
	@Test
	public void same() {
		CIString cis1 = CIString.valueOf(VALUE0);
		CIString cis2 = CIString.valueOf(VALUE0.toLowerCase());
		CIString cis3 = CIString.valueOf(VALUE0.toUpperCase());
		assertEquals(cis1, cis1);
		assertEquals(cis1, cis2);
		assertEquals(cis2, cis1);
		assertEquals(cis1, cis3);
		assertEquals(cis3, cis1);
		assertEquals(cis2, cis3);
		assertEquals(cis3, cis2);
		assertEquals(cis1.hashCode(), cis2.hashCode());
		assertEquals(cis1.hashCode(), cis3.hashCode());
		assertEquals(cis2.hashCode(), cis3.hashCode());
	}

	/**
	 * Test non-equality.
	 */
	@Test
	public void distinct() {
		CIString cis0 = CIString.valueOf(VALUE0);
		CIString cis1 = CIString.valueOf(VALUE1);
		assertNotSame(cis0, cis1);
		assertNotSame(cis1, cis0);
	}

	/**
	 * Test null value.
	 */
	@Test
	public void nullValue() {
		assertNull(CIString.valueOf(null));
	}

}
