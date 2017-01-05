package com.atyp.scorerecorder;

import java.util.LinkedList;
import java.util.Queue;

import com.atyp.binarytree.BTNode;

/**
 * Main class
 * 
 * @author dmarusca
 *
 */
public class ScoreRecorder {

	/**
	 * Method takes an array of integer scores, and put them into binary
	 * unbalanced tree while counting the number of times each score is seen.
	 * The first score from the given list should occupy the root node. *
	 * 
	 * @param scores
	 *            array of integer scores
	 * @return String representation of the tree generated by breadth-first
	 *         approach. Scores are to be inserted into the tree in the order
	 *         that they are given. For example, if you were given the stream of
	 *         scores: 4, 2, 5, 5, 6, 1, 4. That would result in the tree with
	 *         the following structure where each node is represented as
	 *         <score>:<count>. 
	 *         
	 *         			<pre>	4:2 
	 *         					/ \ 
	 *         			       2:1 5:2
	 *         				   / 	\ 
	 *          			 1:1 	6:1
	 * 					</pre>
	 *         When serialized this tree is represented by the string: 4:2, 2:1,
	 *         5:2, 1:1, , , 6:1 Each <score>:<count> entry is delimited with a
	 *         comma. Empty children with a sibling do not output anything, but
	 *         retain the comma delimiter.
	 * 
	 */
	public String scoresToTree(Integer[] scores) {
		if (scores == null || scores.length == 0) {
			return "";
		}
		BTNode<SRNodeData> root = initTree(scores);
		return treeToStringUsingBF(root);
	}

	/**
	 * 
	 * @param root
	 */
	private void addScoreToTree(BTNode<SRNodeData> currentNode, Integer score) {
		if (currentNode.getData().getScore().compareTo(score) < 0) { // right
			if (currentNode.getRight() != null) {
				addScoreToTree(currentNode.getRight(), score);
			} else {
				currentNode.setRight(createNewNode(score));
			}

		} else if (currentNode.getData().getScore().compareTo(score) > 0) { // left
			if (currentNode.getLeft() != null) {
				addScoreToTree(currentNode.getLeft(), score);
			} else {
				currentNode.setLeft(createNewNode(score));
			}
		} else { // merge
			currentNode.getData().increaseCount();
		}
	}

	private String treeToStringUsingBF(BTNode<SRNodeData> root) {
		Queue<BTNode<SRNodeData>> queue = new LinkedList<BTNode<SRNodeData>>();
		StringBuffer result = new StringBuffer();
		queue.add(root);
		while (!queue.isEmpty()) {
			BTNode<SRNodeData> curNode = queue.poll();
			result.append(getStringNodeRepresentation(curNode, queue.isEmpty()));
			if (!isEmptyNode(curNode)) { // not empty node
				if (hasSomeChild(curNode)) {
					if (curNode.getLeft() != null) {
						queue.add(curNode.getLeft());
					} else {
						// Empty children with a sibling do not output anything,
						// but retain the comma delimiter.
						queue.add(createEmptyNode());
					}

					if (curNode.getRight() != null) {
						queue.add(curNode.getRight());
					} else {
						// Empty children with a sibling do not output anything,
						// but retain the comma delimiter.
						queue.add(createEmptyNode());
					}

				}
				if (!queue.isEmpty()) {
					result.append(", ");
				}
			}

		}
		return result.toString();
	}

	private String getStringNodeRepresentation(BTNode<SRNodeData> curNode, Boolean lastRecord) {
		if (curNode.getData() != null) {
			return String.format("%d:%d", curNode.getData().getScore(), curNode.getData().getCount());
		} else {
			if (lastRecord) {
				return ",";
			} else { // no more nodes
				return ", "; // no additional space at the end
			}
		}
	}

	private BTNode<SRNodeData> initTree(Integer[] scores) {
		BTNode<SRNodeData> root = createNewNode(scores[0]);
		if (scores.length > 1) {
			for (int i = 1; i < scores.length; i++) {
				addScoreToTree(root, scores[i]);
			}
		}
		return root;
	}
	
	
	private boolean hasSomeChild(BTNode<SRNodeData> curNode){
		return curNode.getLeft() != null || curNode.getRight() != null;
	}
	
	private BTNode<SRNodeData> createEmptyNode(){
		return new BTNode<SRNodeData>(null);
	}
	
	private boolean isEmptyNode(BTNode<SRNodeData> curNode){
		return curNode.getData()==null;
	}
	
	private BTNode<SRNodeData> createNewNode(Integer score) {
		SRNodeData data = new SRNodeData(score, 1);
		return new BTNode<SRNodeData>(data);
	}

	public static void main(String[] args) {
		Integer[] input = { 4, 2, 5, 5, 6, 1, 4 };
		ScoreRecorder rec = new ScoreRecorder();
		System.out.println(rec.scoresToTree(input));
	}

}
