package ru.gb2.lesson5;

public class Calculate implements Runnable {

    private float[] arr;
    private long start;
    private long result;

    public Calculate(float[] arr) {
        this.arr = arr;
    }

    public long startTime() {
        start = System.currentTimeMillis();
        return start;
    }

    public long finishTime() {
        long finish = System.currentTimeMillis() - start;
        return finish;
    }

    public void printArray(float[] arr) {
        for (float a : arr) {
            System.out.println(a);
        }
    }

    public void addOne(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    private boolean addFormula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        return true;
    }

    public void simpleMethod() {
        addOne(arr);
        startTime();
        addFormula(arr);
        System.out.println(String.format("simpleMethod time: [%s ms] ", finishTime()));
    }

    @Override
    public void run() {
        addOne(arr);
        startTime();
        if (addFormula(arr)) {
            System.out.println(Thread.currentThread().getName() + " finished");
        }
        result = finishTime();
        System.out.println(String.format("RUN time: [%s ms] ", result));
    }

    public float[] getArr() {
        return arr;
    }

    public long getResult() {
        return result;
    }
}