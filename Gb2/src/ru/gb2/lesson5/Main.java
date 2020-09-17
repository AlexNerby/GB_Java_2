package ru.gb2.lesson5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        float[] arrCopyFirst = new float[h];
        float[] arrCopySecond = new float[h];

        Calculate simple = new Calculate(arr);
        simple.simpleMethod();

        multiThreadedMethod(arr, arrCopyFirst, arrCopySecond);

    }

    static float[] multiThreadedMethod(float[] arr, float[] arrCopyFirst, float[] arrCopySecond) {

        long start = System.currentTimeMillis();

        Calculate thread = new Calculate(divisionArr(arr, arrCopyFirst));
        Calculate thread2 = new Calculate(divisionArr2(arr, arrCopySecond));
        new Thread(thread).start();
        new Thread(thread2).start();

        System.arraycopy(thread.getArr(), 0, arr, 0, h);
        System.arraycopy(thread2.getArr(), 0, arr, h, h);

        long end = System.currentTimeMillis() - start;
        System.out.println(String.format("multiThreadedMethod time: [%s ms] ", thread2.getResult() + end));

        return arr;
    }

    static float[] divisionArr(float[] arr, float[] arrCopy) {
        System.arraycopy(arr, 0, arrCopy, 0, h);
        return arrCopy;
    }

    static float[] divisionArr2(float[] arr, float[] arrCopy) {
        System.arraycopy(arr, h, arrCopy, 0, h);
        return arrCopy;
    }


}
