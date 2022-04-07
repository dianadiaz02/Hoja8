package com.hoja8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VectorHeapTest {

	@Test
	void testParent() {
		VectorHeap test = new VectorHeap();
		int result = test.parent(5);
		assertEquals(2, result);
		
	}
	

}