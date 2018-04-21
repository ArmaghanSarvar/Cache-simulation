/**
 * Created by Armaghan on 4/10/2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("the program is making the input file...");
        for (int i = 1; i <= 5; i++) {
            InputGenerator inputGenerator = new InputGenerator(i);
            Cache cache;
            cache = new Cache(true);
            System.out.println("the Hit ratio of specialized cache in File "+i +" is: ");
            cache.process(inputGenerator.allAdds);
            cache = new Cache(false);
            System.out.println("the Hit ratio of Not specialized cache in File "+i +" is:");
            cache.process(inputGenerator.allAdds);
            System.out.println("------------------------------------");
        }
    }
}
