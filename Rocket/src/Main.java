import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;




public class Main {
    public static void main(String[] args) throws Exception {
        Rocket u1 = new Rocket();
        u1.name = "U-2";
        u1.cost = 120000000;
        u1.weight = 18;
        u1.maxWeight = 29;
        int price = 0;
        Scanner scan = null;
        File f = new File("items.txt");
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        boolean foundInts = false;
        List<String> itemList = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String currentLine = scan.nextLine();
            String words[] = currentLine.split(" ");

            for (String str : words) {

                try {
                    int num = Integer.parseInt(str);
                    itemList.add(str);
                    foundInts = true;
                } catch (NumberFormatException nfe) {
                }
                ;

            }
        }
        scan.close();

        List<Integer> itemInt = itemList.stream().map(s -> Integer.parseInt((s))).collect(Collectors.toList());
        boolean isEmpty=itemInt.isEmpty();
        System.out.println(itemInt);
        while (!isEmpty) {
            int j = 0;
            for (int i = 0; i < itemInt.size() - j; i++) {
                if (u1.weight + (itemInt.get(i) / 1000) <= u1.maxWeight) {
                    u1.weight += itemInt.get(i) / 1000;
                    System.out.println("Item weight: " + itemInt.get(i) + " Rocket wieght: " + u1.weight * 1000);
                    itemInt.remove(i);
                    j = 1;
                } else {
                    j = 0;
                }
            }

            double chanceExplosion = 0.04 * (u1.weight / u1.maxWeight);
            double chanceCrashing = chanceExplosion * 2;
            double random = Math.random();
            boolean successfulLaunch = true;
            boolean successfulLand = true;
            if (random > chanceExplosion) {
                System.out.println("Start was success");
            } else {
                System.out.println("Start was failure");
            }
            if (random > chanceCrashing) {
                System.out.println("Landing was success");
            } else {
                System.out.println("Landing ended up with crash");
            }
            price+=u1.cost;
            u1.weight=10;
            isEmpty=itemInt.isEmpty();


        }
        System.out.println("Cost for "+u1.name +" will be: " + price);
    }


}
