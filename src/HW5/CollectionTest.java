package HW5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CollectionTest
{
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("dictionary.txt"));

        Collection<String> input = new ArrayList<>();

        while (scanner.hasNext())
            input.add(scanner.next());
        
        Collection<String> filtered1 = new SortedCollection<>(new FilteredCollection<>(new StringLength(5), new FilteredCollection<>(new StringPrefix("ka"), input)), (o1, o2) -> o2.compareTo(o1));
        Collection<String> filtered2 = new SortedCollection<>(new MergedCollection<>(new FilteredCollection<>(new StringPrefix("vivi"), input), new FilteredCollection<>(new StringPrefix("pse"), input)), (o1, o2) -> new Integer(o1.length()).compareTo(o2.length()));

        System.out.println("---First---");
        filtered1.forEach(System.out::println);
        System.out.println("---Second---");
        filtered2.forEach(System.out::println);
    }
}
