package ru.gb2.lesson2;

public class Exceptions {

    static int result;

    public static void main(String[] args) {

        /** 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
         * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
         *  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
         * Если в каком-то элементе массива преобразование не удалось
         * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
         * MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
         * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
         * MyArrayDataException, и вывести результат расчета. */

        String[][] arrayFive = {{"5", "5", "5", "5"},
                {"5", "5", "5", "5"},
                {"5", "5", "5", "5"},
                {"5", "5", "5", "five"}};

        try {
            lesson2(arrayFive);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("the result of the sum of the array: " + result);
        }
    }

    static void lesson2(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4 || arr.length != 4) {
                throw new MyArraySizeException("array size exceeded");
            }

            for (int j = 0; j < arr.length; j++) {
                try {
                    result = result + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("incorrect data in a cell: [%d][%d]. %s",
                            i, j, e.getLocalizedMessage()));
                }
            }
        }
    }
}


