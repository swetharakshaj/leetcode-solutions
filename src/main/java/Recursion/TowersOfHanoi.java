package Recursion;

import java.util.Stack;

public class TowersOfHanoi {

    private Stack<Integer> disks;

    TowersOfHanoi()
    {
        disks = new Stack<>();
    }

    void add(int input) {
        if(disks.isEmpty() || disks.peek() > input)
            disks.add(input);
        else
            throw new IllegalArgumentException();
    }

    void moveToTop(TowersOfHanoi dest)
    {
        if(disks.isEmpty())
            throw new IllegalArgumentException();
        else
        {
            int top = disks.pop();
            dest.add(top);
        }
    }

    void moveToDest(int n, TowersOfHanoi dest, TowersOfHanoi buffer)
    {
        if(n > 0)
        {
            moveToDest(n-1, buffer, dest);
            moveToTop(dest);
            buffer.moveToDest(n-1, dest, this);
        }
    }
}
