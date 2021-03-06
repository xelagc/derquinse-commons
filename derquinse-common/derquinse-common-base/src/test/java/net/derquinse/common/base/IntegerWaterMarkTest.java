/*
 * Copyright (C) the original author or authors.
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
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import net.derquinse.common.test.EqualityTests;

import org.testng.annotations.Test;

/**
 * Tests for IntegerWaterMark
 * @author Andres Rodriguez
 */
public class IntegerWaterMarkTest {
	private IntegerWaterMark m;

	private void test(int current, int min, int max) {
		assertNotNull(m);
		assertEquals(m.get(), current);
		assertEquals(m.getMin(), min);
		assertEquals(m.getMax(), max);
		assertTrue(min <= current);
		assertTrue(max >= current);
	}

	private void equalTo(IntegerWaterMark other) {
		EqualityTests.two(m, other);
	}

	/**
	 * Empty.
	 */
	@Test
	public void empty() {
		m = IntegerWaterMark.of();
		test(0, 0, 0);
	}

	/**
	 * Initial value.
	 */
	@Test(dependsOnMethods = "empty")
	public void initial() {
		m = IntegerWaterMark.of(7);
		test(7, 7, 7);
	}

	/**
	 * Mutations.
	 */
	@Test(dependsOnMethods = "initial")
	public void mutation() {
		m = m.inc();
		test(8, 7, 8);
		m = m.dec();
		test(7, 7, 8);
		m = m.dec();
		test(6, 6, 8);
		m = m.inc();
		test(7, 6, 8);
		m = m.add(4);
		test(11, 6, 11);
		m = m.add(-7);
		test(4, 4, 11);
		m = m.set(9);
		test(9, 4, 11);
	}

	/**
	 * Equality.
	 */
	@Test(dependsOnMethods = "mutation")
	public void equals() {
		equalTo(m);
		equalTo(m.inc().dec());
		equalTo(IntegerWaterMark.of(m.getMin()).set(m.getMax()).set(m.get()));
	}

	private void notEquals(IntegerWaterMark other) {
		assertNotEquals(m, other);
		assertNotEquals(other, m);
	}

	/**
	 * Inequality.
	 */
	@Test(dependsOnMethods = "equals")
	public void notEquals() {
		notEquals(null);
		notEquals(m.inc());
		notEquals(m.dec());
		notEquals(m.set(m.getMin() - 10).set(m.get()));
		notEquals(m.set(m.getMax() + 10).set(m.get()));
	}

}
