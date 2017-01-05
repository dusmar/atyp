package com.atyp.scorerecorder;

import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author dmarusca
 *
 */
public class ScoreRecorderTest {

	/**
	 *        			 4:2 
	 *         			 / \ 
	 *         			2:1 5:2 
	 *         			/     \ 
	 *         		1:1	      6:1 

	 */
	@Test
	public void scoresToTreeUnbalancedCommonCaseTest() {
		Integer[] input = { 4, 2, 5, 5, 6, 1, 4 };
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("4:2, 2:1, 5:2, 1:1, , , 6:1", result);
	}

	/**
	 *        			   4:2 
	 *         			 /     \ 
	 *         			2:1    6:2 
	 *         		   / \     /  \ 
	 *         		1:1	  3:1 5:1 7:1 

	 */
	@Test
	public void scoresToTreeBalancedTreeCaseTest() {
		Integer[] input = { 4, 2, 6, 6, 7,  5, 1, 4, 3};
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("4:2, 2:1, 6:2, 1:1, 3:1, 5:1, 7:1", result);
	}


	/**
	 *        			 4:2 
	 *         			 / \ 
	 *         			2:1 7:2 
	 *         			/    / 
	 *         		1:1	     6:1 

	 */
	@Test
	public void scoresToTreeUnbalancedTreeEmptyChildredAtTheEndCaseTest() {
		Integer[] input = { 4, 2, 7, 7, 6, 1, 4 };
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("4:2, 2:1, 7:2, 1:1, , 6:1, ,", result);
	}

	

	@Test
	public void scoresToTreeJustRootNodeTest() {
		Integer[] input = { 4};
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("4:1", result);
	}

	@Test
	public void scoresToTreeEmptyArrayTest() {
		Integer[] input = {};
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("", result);
		input = null;
		result = rec.scoresToTree(input);
		Assert.assertEquals("", result);
	}

	
	
	
	@Test
	/**
	 *        			 4:2 
	 *         			 /  
	 *         			2:1  
	 *         			/      
	 *         		1:1	      

	 */
	public void scoresToTreeUncommonCaseTest() {
		Integer[] input = { 4, 2, 1, 4, 2, 1};
		ScoreRecorder rec = new ScoreRecorder();
		String result = rec.scoresToTree(input);
		Assert.assertEquals("4:2, 2:2, , 1:2, ,", result);
	}

	
}
