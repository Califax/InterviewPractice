package leetcode;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> iterators;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterators = new Stack<>();
        iterators.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return iterators.peek().next().getInteger();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        while (!iterators.isEmpty()) {
            if (!iterators.peek().hasNext()) {
                iterators.pop(); // remove iterator with no more elements
            } else {
                final NestedInteger currNested = iterators.peek().next();
                if (iterators.peek().next().isInteger()) {
                    iterators.peek().previous(); // go back on stack so it isn't moved by hasNext
                    return true;
                } else {
                    iterators.push(currNested.getList().listIterator());
                }
            }
        }
        return false;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();

    }
}