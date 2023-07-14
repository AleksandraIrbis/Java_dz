
package market;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        Set<Notebook> set = new HashSet<>();
        set.add(new Notebook("товар 1", 8, "Windows10", 80000, "HP"));
        set.add(new Notebook("товар 2", 16, "Windows10", 85000, "Asus"));
        set.add(new Notebook("товар 3", 32, "linux", 85000, "Lenovo"));
        set.add(new Notebook("товар 4", 64, "linux", 90000, "Lenovo"));

        code operation = new code(set);
        operation.start();

    }
}

