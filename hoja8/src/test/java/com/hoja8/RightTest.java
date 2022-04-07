package com.hoja8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class RightTest {

	@Test
	void testright() {
		VectorHeap test = new VectorHeap();
		int result = test.right(5);
		assertEquals(12, result);
	}
}