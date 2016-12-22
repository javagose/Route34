package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint {
    private final float f5x;
    private final float f6y;

    public ResultPoint(float x, float y) {
        this.f5x = x;
        this.f6y = y;
    }

    public final float getX() {
        return this.f5x;
    }

    public final float getY() {
        return this.f6y;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof ResultPoint)) {
            return false;
        }
        ResultPoint otherPoint = (ResultPoint) other;
        if (this.f5x == otherPoint.f5x && this.f6y == otherPoint.f6y) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f5x) * 31) + Float.floatToIntBits(this.f6y);
    }

    public final String toString() {
        StringBuilder result = new StringBuilder(25);
        result.append('(');
        result.append(this.f5x);
        result.append(',');
        result.append(this.f6y);
        result.append(')');
        return result.toString();
    }

    public static void orderBestPatterns(ResultPoint[] patterns) {
        ResultPoint pointB;
        ResultPoint pointA;
        ResultPoint pointC;
        float zeroOneDistance = distance(patterns[0], patterns[1]);
        float oneTwoDistance = distance(patterns[1], patterns[2]);
        float zeroTwoDistance = distance(patterns[0], patterns[2]);
        if (oneTwoDistance >= zeroOneDistance && oneTwoDistance >= zeroTwoDistance) {
            pointB = patterns[0];
            pointA = patterns[1];
            pointC = patterns[2];
        } else if (zeroTwoDistance < oneTwoDistance || zeroTwoDistance < zeroOneDistance) {
            pointB = patterns[2];
            pointA = patterns[0];
            pointC = patterns[1];
        } else {
            pointB = patterns[1];
            pointA = patterns[0];
            pointC = patterns[2];
        }
        if (crossProductZ(pointA, pointB, pointC) < 0.0f) {
            ResultPoint temp = pointA;
            pointA = pointC;
            pointC = temp;
        }
        patterns[0] = pointA;
        patterns[1] = pointB;
        patterns[2] = pointC;
    }

    public static float distance(ResultPoint pattern1, ResultPoint pattern2) {
        return MathUtils.distance(pattern1.f5x, pattern1.f6y, pattern2.f5x, pattern2.f6y);
    }

    private static float crossProductZ(ResultPoint pointA, ResultPoint pointB, ResultPoint pointC) {
        float bX = pointB.f5x;
        float bY = pointB.f6y;
        return ((pointC.f5x - bX) * (pointA.f6y - bY)) - ((pointC.f6y - bY) * (pointA.f5x - bX));
    }
}
