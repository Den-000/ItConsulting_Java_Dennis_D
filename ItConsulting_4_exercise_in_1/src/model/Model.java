package model;

public class Model {

    // Somma di due numeri
    public int sum(int a, int b) {
        return a + b;
    }

    // Overload: moltiplicazione interi
    public int multiply(int a, int b) {
        return a * b;
    }

    // Overload: moltiplicazione float
    public float multiply(float a, float b, float c) {
        return a * b * c;
    }

    // Somma ricorsiva dei primi n numeri naturali
    public int recursiveSum(int n) {
        if (n <= 1) return n;
        return n + recursiveSum(n - 1);
    }

    // Modifica di una variabile primitiva (boolean)
    public boolean toggleBoolean(boolean value) {
        System.out.println("Prima della modifica: " + value);
        value = !value;
        System.out.println("Dopo la modifica: " + value);
        return value;
    }

    // Modifica array di nomi
    public void modifyArray(String[] names, int index, String newName) {
        System.out.print("Array prima della modifica: ");
        printArray(names);

        if (index >= 0 && index < names.length) {
            names[index] = newName;
        } else {
            System.out.println("Indice non valido. Nessuna modifica eseguita.");
            return;
        }

        System.out.print("Array dopo la modifica: ");
        printArray(names);
    }

    private void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i + "] " + arr[i] + " ");
        }
        System.out.println();
    }
}