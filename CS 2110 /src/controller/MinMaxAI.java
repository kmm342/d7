package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import model.Board;
import model.Board.State;
import model.Game;
import model.Location;
import model.NotImplementedException;
import model.Player;

/**
 * A MinMaxAI is a controller that uses the minimax algorithm to select the next
 * move.  The minimax algorithm searches for the best possible next move, under
 * the assumption that your opponent will also always select the best possible
 * move.
 *
 * <p>The minimax algorithm assigns a score to each possible game configuration
 * g.  The score is assigned recursively as follows: if the game g is over and
 * the player has won, then the score is infinity.  If the game g is over and
 * the player has lost, then the score is negative infinity.  If the game is a
 * draw, then the score is 0.
 * 
 * <p>If the game is not over, then there are many possible moves that could be
 * made; each of these leads to a new game configuration g'.  We can
 * recursively find the score for each of these configurations.
 * 
 * <p>If it is the player's turn, then they will choose the action that
 * maximizes their score, so the score for g is the maximum of all the scores
 * of the g's.  However, if it is the opponent's turn, then the opponent will
 * try to minimize the score for the player, so the score for g is the
 * <em>minimum</em> of all of the scores of the g'.
 * 
 * <p>You can think of the game as defining a tree, where each node in the tree
 * represents a game configuration, and the children of g are all of the g'
 * reachable from g by taking a turn.  The minimax algorithm is then a
 * particular traversal of this tree.
 * 
 * <p>In practice, game trees can become very large, so we apply a few
 * strategies to narrow the set of paths that we search.  First, we can decide
 * to only consider certain kinds of moves.  For five-in-a-row, there are
 * typically at least 70 moves available at each step; but it's (usually) not
 * sensible to go on the opposite side of the board from where all of the other
 * pieces are; by restricting our search to only part of the board, we can
 * reduce the space considerably.
 * 
 * <p>A second strategy is that we can look only a few moves ahead instead of
 * planning all the way to the end of the game.  This requires us to be able to
 * estimate how "good" a given board looks for a player.
 * 
 * <p>This class implements the minimax algorithm with support for these two
 * strategies for reducing the search space.  The abstract method {@link
 * #moves(Board)} is used to list all of the moves that the AI is willing to
 * consider, while the abstract method {@link #estimate(Board)} returns
 * the estimation of how good the board is for the given player.
 */
public abstract class MinMaxAI extends Controller {

	/**
	 * Return an estimate of how good the given board is for me.
	 * A result of infinity means I have won.  A result of negative infinity
	 * means that I have lost.
	 */
	protected abstract int estimate(Board b);
	
	/**
	 * Return the set of moves that the AI will consider when planning ahead.
	 * Must contain at least one move if there are any valid moves to make.
	 */
	protected abstract Iterable<Location> moves(Board b);
	
	private Player player;
	
	private int depth;
	
	/**
	 * Create an AI that will recursively search for the next move using the
	 * minimax algorithm.  When searching for a move, the algorithm will look
	 * depth moves into the future.
	 *
	 * <p>choosing a higher value for depth makes the AI smarter, but requires
	 * more time to select moves.
	 */
	protected MinMaxAI(Player me, int depth) {
		super(me);
		player = me;
		this.depth = depth;
	}

	/**
	 * Return the move that maximizes the score according to the minimax
	 * algorithm described above.
	 */
	protected @Override Location nextMove(Game g) {
		Iterator<Location> available = moves(g.getBoard()).iterator();
		List<Integer> scores = new ArrayList<>();
		
		
		
		for (int i = 0; i =, i++) {
			
		}
//		
//		Location potentialLocation = null;
//		
//		if (potentialLocation == new Location(5,5) && g.getBoard() == g.getBoard().EMPTY) {
//			return potentialLocation;
//		}
//		
//		while(available.hasNext()) {
//			Game g2 = new Game(player); //new game copy		 
//				potentialLocation = available.next();
//			//run minimax algorithm
//			minimax(g, depth, Max);
//		}
//			
		throw new NotImplementedException();
	}
	
	public boolean Max = true;
	private int value = 1;
	
	
	//helper method: needs to retrieve board from game via getBoard;
	//use update() to make copy of game's Board object
	
	public void helpermethod(Game g) {
		Board b = g.getBoard();
		
		b.update(player, loc); //loc is supposed to take cue of location from minimax?
	}
	

	
	 
	 //This function, minimax, runs the recursive MinMax algorithm to evaluate 
	 //each game state at a given depth to return the Location for the next best move.
	 public Location minimax (Game g, int depth, boolean Max) {
		 if (depth == 0) {
			 return estimate(g.getBoard());
			// return Node.data; //return evaluationScore for terminal node
		 }
		 Node childNodes = node.getChildNodes();
		 if (Max) {
			 value = -1;
			 //for each child of Node node, do minimax(child, depth -1, FALSE)
			 Node childNodes = node.getChildNodes();
			 for (int i = 0; i < childNodes.getLength(); i++) {
				 value = max(value, minimax(node.item(i), depth -1, FALSE));
			return value;
			 }
		 }
		 	 
		 else //minimizing score
			value = +1;
		 	for (int i = 0; i < childNodes.getLength(); i++) {
		 		value = max(value, minimax(node.item(i), depth -1, TRUE));
		 	return value;
		 	}
	 }
	 
	 for (moves)
	 
	 
}
	  