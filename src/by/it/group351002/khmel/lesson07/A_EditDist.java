package by.it.group351002.khmel.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/
Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.
Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Рекурсивно вычислить расстояние редактирования двух данных непустых строк
    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0
    Sample Input 2:
    short
    ports
    Sample Output 2:
    3
    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5
*/
/* Расстояние Левенштейна — это минимальное количество односимвольных изменений (вставок, удалений или замен),
необходимых для замены одной строки другой.*/
public class A_EditDist {

/* Базовый случай = 0-  конца одной из строк.mВ этом случае расстояние редактирования — это
длина оставшейся подстроки из другой строки (необходимы вставки или удаления).
Рекурсивный случай рассматривает три возможности:
Удаление символа по индексу i-1из строки a.
Удаление символа по индексу j-1из строки b.
Если символы в индексах i-1и j-1одинаковы, никаких действий не требуется. В противном случае требуется замена.
*/
    int rec(int i, int j, String a, String b) {
        if (Math.min(i, j) == 0)
            return Math.max(i, j);
        return Math.min(Math.min(rec(i, j - 1, a, b), rec(i - 1, j, a, b)) + 1, rec(i - 1, j - 1, a, b) + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1));
    }

    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return rec(one.length(), two.length(), one, two);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group351002/khmel.lesson07/dataABC.txt");
        A_EditDist instance = new A_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    }
}