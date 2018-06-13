package HomeWork;

import java.util.*;
import java.io.*;

public class Question1 {
    public static void main(String[] args) {
        //
//        float[] points = new float[4];
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//        String value = null;
//        int count = 0;
//
//        while (count < points.length) {
//            count ++;
//            System.out.println("请输入第" + count + "位评委打分成绩:");
//            try {
//                value = br1.readLine();
//                float s = Float.parseFloat(value);
//                points[count - 1] = s;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        Question1.getAve(points);

        Judge j = new Judge(4);
        float s = j.endValues();
        System.out.println("平均分:" + s);
        System.out.println("最高分评委:" + (j.getMaxIndex() + 1));
        System.out.println("最低分评委:" + (j.getMinIndex() + 1));
        System.out.println("最差评委:" + (j.getBad() + 1));
        System.out.println("最优评委:" + (j.getNice() + 1));
    }

    public static void getAve(float[] points) {
        int minIndex = 0;
        int maxIndex = 0;
        float sum = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] >= points[maxIndex]) {
                maxIndex = i;
            } else if (points[i] <= points[minIndex]) {
                minIndex = i;
            }
            sum += points[i];
        }
        sum -= points[minIndex];
        sum -= points[maxIndex];
        System.out.println("平均分:" + (sum / (points.length - 2)));
        System.out.println("最高分评委: " + (maxIndex + 1));
        System.out.println("最低分评委: " + (minIndex + 1));
    }
}

class Judge {
    private  float[] points = null;
    private int minIndex = -1;
    private int maxIndex = -1;
    public Judge(int size) {
        points = new float[size];
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        for (int i = 0; i < size; i++) {
            System.out.println("请输入第" + (i + 1) + "位评委打分成绩:");
            try {
                value = br1.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                try {
//                    br1.close();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
            }
            float s = Float.parseFloat(value);
            points[i] = s;
        }
    }

    public float endValues() {
        float sum = 0;
        float allValues = 0;
        minIndex = this.getMinIndex();
        maxIndex = this.getMaxIndex();
        for (int i = 0; i < points.length; i++) {
            if (i != minIndex && i != maxIndex) {
                allValues += points[i];
            }
        }
        return allValues / (points.length - 2);
    }

    public int getMinIndex() {
        if (minIndex >= 0) {
            return minIndex;
        }
        int m = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] < points[m]) {
                m = i;
            }
        }
        return m;
    }
    public int getMaxIndex() {
        if (maxIndex >= 0) {
            return maxIndex;
        }
        int m = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] > points[m]) {
                m = i;
            }
        }
        return m;
    }

    public int getNice() {
        float avgVal = this.endValues();
        int niceIndex = 0;
        float abs = Math.abs( this.points[0] - avgVal);
        for (int i = 0; i < this.points.length; i++) {
            if (Math.abs(this.points[i] - avgVal) < abs) {
                niceIndex = i;
                abs = Math.abs(this.points[i] - avgVal);
            }
        }
        return niceIndex;
    }
    public int getBad() {
        float avgVal = this.endValues();
        int badIndex = 0;
        float abs = Math.abs( this.points[0] - avgVal);
        for (int i = 0; i < this.points.length; i++) {
            if (Math.abs(this.points[i] - avgVal) > abs) {
                badIndex = i;
                abs = Math.abs(this.points[i] - avgVal);
            }
        }
        return badIndex;
    }

}