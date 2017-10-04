package cube;

import java.util.Observable;

import static java.lang.System.arraycopy;

/** Models an instance of the Cube puzzle: a cube with color on some sides
 *  sitting on a cell of a square grid, some of whose cells are colored.
 *  Any object may register to observe this model, using the (inherited)
 *  addObserver method.  The model notifies observers whenever it is modified.
 *  @author P. N. Hilfinger
 */
public class CubeModel extends Observable {


    int _side;
    int r;
    int c;
    int moves;
    boolean[] _facePainted;
    boolean[][] boardPainted;

    /** A blank cube puzzle of size 4. */
    public CubeModel() {
        _side = 4;
        r = 0;
        c = 0;
        moves = 0;
        _facePainted = new boolean[6];
        boardPainted = new boolean[_side][_side];
        //FIX ME
    }

    /** A copy of CUBE. */
    public CubeModel(CubeModel cube) {
        initialize(cube);
    }

    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c], and
     *  with face k painted iff FACEPAINTED[k] (see isPaintedFace).
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     *    * FACEPAINTED has length 6.
     */
    public void initialize(int side, int row0, int col0, boolean[][] painted,
                    boolean[] facePainted) {
        // FIXME

        _side = side;
        r = row0;
        c = col0;
        boardPainted = painted;
        _facePainted = facePainted;

        setChanged();
        notifyObservers();
    }

    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c].
     *  The cube is initially blank.
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     */
    public void initialize(int side, int row0, int col0, boolean[][] painted) {
        initialize(side, row0, col0, painted, new boolean[6]);
    }

    /** Initialize puzzle to be a copy of CUBE. */
    public void initialize(CubeModel cube) {
        // FIX ME

        initialize(cube._side, cube.r, cube.c, cube.boardPainted, cube._facePainted);

        setChanged();
        notifyObservers();
    }

    /** Move the cube to (ROW, COL), if that position is on the board and
     *  vertically or horizontally adjacent to the current cube position.
     *  Transfers colors as specified by the rules.
     *  Throws IllegalArgumentException if preconditions are not met.
     */
    public void move(int row, int col) {
        // FIXME
        setChanged();
        notifyObservers();
    }

    /** Return the number of squares on a side. */
    public int side() {
        return _side; // FIXME
    }

    /** Return true iff square ROW, COL is painted.
     *  Requires 0 <= ROW, COL < board size. */
    public boolean isPaintedSquare(int row, int col) {
        //System.out.println("ROW: " + row);
        //System.out.println("COL: " + col);
        //System.out.println("ARRAY: " + boardPainted.toString());
        if (0 <= row && row < _side) {
            if (0 <= col && col < _side) {
                return boardPainted[row][col];
            }
        }
        throw new IndexOutOfBoundsException("Square not on board."); // FIXME
    }

    /** Return current row of cube. */
    public int cubeRow() {
        return r; // FIXME
    }

    /** Return current column of cube. */
    public int cubeCol() {
        return c; // FIXME
    }

    /** Return the number of moves made on current puzzle. */
    public int moves() {
        return moves; // FIXME
    }

    /** Return true iff face #FACE, 0 <= FACE < 6, of the cube is painted.
     *  Faces are numbered as follows:
     *    0: Vertical in the direction of row 0 (nearest row to player).
     *    1: Vertical in the direction of last row.
     *    2: Vertical in the direction of column 0 (left column).
     *    3: Vertical in the direction of last column.
     *    4: Bottom face.
     *    5: Top face.
     */
    public boolean isPaintedFace(int face) {
        return _facePainted[face];
         // FIXME
    }

    /** Return true iff all faces are painted. */
    public boolean allFacesPainted() {
        int count = 0;
        for (int i = 0; i < _facePainted.length; i++) {
            if (_facePainted[i]) {
                count++;
            }
        }

        if (count == 6) {
            return true; // FIXME
        }
        return false;
    }

    // ADDITIONAL FIELDS AND PRIVATE METHODS HERE, AS NEEDED.

}
