/*
 * MatchThreeGameBorard
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.genesis.codinggame;

/**
 * @author piyush
 */
public class MatchThreeGameBorard {

    private int maxRows;
    private int maxCols;
    private int nextPlayer;

    public static final int EMPTY = 0;
    private static final int PLAYER1 = 1;
    public static final int TIE = -1;

    private int[][] grid;

    public MatchThreeGameBorard(int rows, int columns) {
        maxRows = rows;
        maxCols = columns;
    }

}
