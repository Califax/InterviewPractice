package leetcode;

public class MySquareRoot {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return mySqrt(x, 1, x/2);
    }

    private int mySqrt(int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (mid > target/mid) {
            return mySqrt(target, low, mid-1);
        } else {
            if (mid + 1 > target / (mid+1)) {
                return mid;
            }
            return mySqrt(target, mid+1, high);
        }
    }

    public int mySqrt2(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
