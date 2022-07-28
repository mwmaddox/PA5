import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.*;

public class BSTTest {
	
	/* Test isEmpty(): boolean */
	@Test
	public void testEmpty() {
		@SuppressWarnings("rawtypes")
		BST testBST = new BST();
		assertEquals(true, testBST.isEmpty());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testNotEmpty() {
		BST testBST = new BST();
		testBST.put("mal", 3);
		assertEquals(false, testBST.isEmpty());
	}
	
	
	/* Test put( K key, V value): boolean */
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testPutPairs() {
		BST testBST = new BST();
		assertEquals(true, testBST.put("Mal", 19));
		assertEquals(false, testBST.put("Mal", 19));
		assertEquals(true, testBST.put("kenz", 19));
	}
	
	/* Test replace(K key, V newValue): boolean */
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testReplaceTrue() {
		BST testBST = new BST();
		testBST.put("Mal", 19);
		testBST.put("Kenz", 20);
		testBST.put("Jen", 21);
		assertEquals(true, testBST.replace("Mal", 51));
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testReplaceFalse() {
		BST testBST = new BST();
		testBST.put("Mal", 19);
		testBST.put("Kenz", 20);
		testBST.put("Jen", 21);
		assertEquals(false, testBST.replace("laugh", 51));
	}
	
	/* Test remove(K key): boolean */
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testRemoveNoSuchKey() {
		BST testBST = new BST();
		testBST.put("q", 19);
		testBST.put("k", 19);
		testBST.put("s", 19);
		testBST.put("r", 19);
		testBST.put("t", 19);
		testBST.put("b", 19);
		testBST.put("w", 19);
		testBST.put("a", 19);
		testBST.put("l", 19);
		testBST.put("+", 19);
		assertEquals(false, testBST.remove("8"));
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testRemoveNoChildren() {
		BST testBST = new BST();
		testBST.put("a", 19);
		assertEquals(true, testBST.remove("a"));
		assertEquals(0, testBST.size());
		assertEquals(testBST.put("a", 19), true);
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testRemoveLeaf() {
		BST testBST = new BST();
		testBST.put("m", 19);
		testBST.put("a", 19);
		testBST.put("z", 19);
		assertEquals(true, testBST.remove("a"));
		assertEquals(true, testBST.put("a", 19));

	}

	// Test set(K key, V value): void 
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSetValue() {
		BST testBST = new BST();
		testBST.set("Mal", 19);
		testBST.set("Kenz", 20);
		testBST.set("Jen", 21);
		assertEquals(19, testBST.get("Mal"));
		assertEquals(3, testBST.size());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSetChangeValue() {
		BST testBST = new BST();
		testBST.set("Mal", 19);
		testBST.set("Mal", 20);
		testBST.set("Jen", 21);
		assertEquals(20, testBST.get("Mal"));
	}

	// Test get(K key): V
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetV() {
		BST testBST = new BST();
		testBST.put("Mal", 19);
		testBST.put("Kenz", 20);
		testBST.put("Jen", 21);
		assertEquals(19, testBST.get("Mal"));
	}
	
	// Test size(): int
	@Test
	@SuppressWarnings({ "rawtypes"})
	public void testSizeZero() {
		BST testBST = new BST();
		assertEquals(0, testBST.size());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSizeSmall() {
		BST testBST = new BST();
		testBST.put("Mal", 19);
		testBST.put("Kenz", 19);
		testBST.put("Jen", 19);
		assertEquals(3, testBST.size());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSizeDuplicates() {
		BST testBST = new BST();
		testBST.put("Mal", 19);
		testBST.put("Mal", 19);
		assertEquals(1, testBST.size());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSizeLarge() {
		BST testBST = new BST();
		testBST.put("q", 19);
		testBST.put("k", 19);
		testBST.put("s", 19);
		testBST.put("r", 19);
		testBST.put("t", 19);
		testBST.put("b", 19);
		testBST.put("w", 19);
		testBST.put("a", 19);
		testBST.put("l", 19);
		testBST.put("+", 19);
		assertEquals(10, testBST.size());
	}
	
	/* Test containsKey(K key): boolean */
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testContainsKeyTrue() {
		BST testBST = new BST();
		testBST.put("q", 19);
		testBST.put("k", 19);
		testBST.put("s", 19);
		testBST.put("r", 19);
		testBST.put("t", 19);
		testBST.put("b", 19);
		testBST.put("w", 19);
		testBST.put("a", 19);
		testBST.put("l", 19);
		testBST.put("+", 19);
		assertEquals(true, testBST.containsKey("a"));
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testContainsKeyFalse() {
		BST testBST = new BST();
		testBST.put("q", 19);
		testBST.put("k", 19);
		testBST.put("s", 19);
		testBST.put("r", 19);
		testBST.put("t", 19);
		testBST.put("b", 19);
		testBST.put("w", 19);
		testBST.put("a", 19);
		testBST.put("l", 19);
		testBST.put("+", 19);
		assertEquals(false, testBST.containsKey("1"));
	}
	
	/* Test keys(): List<K> */
//	@Test
//	public void testKeys() {
//		BST testBST = new BST();
//		testBST.put("Mal", 19);
//		testBST.put("Kenz", 19);
//		List expected = new ArrayList<>();
//		expected.add("Kenz");
//		expected.add("Mal");
//		assertArraysEquals(expected, testBST.keys());
//	}

}
