package com.example.wojtekw.tre_i_rad;

/**
 * Created by Wojtek w on 2016-05-24.
 * <p/>
 * com.example.wojtekw.tre_i_rad
 */
import android.widget.ImageView;

public class GameLogic {

    private static ImageView[] Spaces;
    public static String Champion;
    public static int Set;

    // Reminder: final gör att variable kan inte ha ett annat värde än det den är nu
    public static final int O = 0;
    public static final int X = 1;

    private static boolean setIsIdentical(int first, int second, int third, int set) {

        boolean value = Spaces[first - 1].getId() == Spaces[second - 1].getId()
                && Spaces[second - 1].getId() == Spaces[third - 1].getId();
        if (value) {

            if (Spaces[first - 1].getId() == O)
                Champion = "O";

            else
                Champion = "X";
            Set = set;
        }

        return value;

    }

    public static boolean isDone(int position, ImageView[] spaces) {

        GameLogic.Spaces = spaces;

        boolean isDone = false;
        switch (position) {

            case 1:
                isDone = setIsIdentical(1, 2, 3, 1) ||
                        setIsIdentical(1, 4, 7, 4) ||
                        setIsIdentical(1, 5, 9, 7);
                break;

            case 2:
                isDone = setIsIdentical(1, 2, 3, 1) ||
                        setIsIdentical(2, 5, 8, 5);
                break;

            case 3:
                isDone = setIsIdentical(1, 2, 3, 1) ||
                        setIsIdentical(3, 6, 9, 6) ||
                        setIsIdentical(3, 5, 7, 8);
                break;

            case 4:
                isDone = setIsIdentical(4, 5, 6, 2) ||
                        setIsIdentical(1, 4, 7, 4);
                break;

            case 5:
                isDone = setIsIdentical(4, 5, 6, 2) ||
                        setIsIdentical(2, 5, 8, 5) ||
                        setIsIdentical(1, 5, 9, 7) ||
                        setIsIdentical(3, 5, 7, 8);
                break;

            case 6:
                isDone = setIsIdentical(4, 5, 6, 2) ||
                        setIsIdentical(3, 6, 9, 6);
                break;

            case 7:
                isDone = setIsIdentical(7, 8, 9, 3) ||
                        setIsIdentical(1, 4, 7, 4) ||
                        setIsIdentical(3, 5, 7, 8);
                break;

            case 8:
                isDone = setIsIdentical(7, 8, 9, 3) ||
                        setIsIdentical(2, 5, 8, 5);
                break;

            case 9:
                isDone = setIsIdentical(7, 8, 9, 3) ||
                        setIsIdentical(3, 6, 9, 6) ||
                        setIsIdentical(1, 5, 9, 7);
                break;

        }

        return isDone;

    }

}

