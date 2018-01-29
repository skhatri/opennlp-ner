package com.github.skhatri.utils;

public class ThisOrThat<L, R> {
    private final L left;
    private final R right;
    private boolean _left;
    private boolean _right;

    private ThisOrThat(L left, R right, boolean isLeft, boolean isRight) {
        this.left = left;
        this.right = right;
        this._left = isLeft;
        this._right = isRight;
    }

    public boolean isLeft() {
        return _left;
    }

    public boolean isRight() {
        return _right;
    }

    public L left() {
        return left;
    }

    public R right() {
        return right;
    }

    public static final <L, R> ThisOrThat left(L left) {
        return new ThisOrThat<L, R>(left, null, true, false);
    }

    public static final <L, R> ThisOrThat right(R right) {
        return new ThisOrThat<L, R>(null, right, false, true);
    }
}
