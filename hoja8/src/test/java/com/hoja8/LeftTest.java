package com.hoja8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class LeftTest {

	@Test
	void testleft() {
		VectorHeap test = new VectorHeap();
		int result = test.left(5);
		assertEquals(11, result);

	}
	
}
