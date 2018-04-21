import java.util.Vector;

/**
 * Created by Armaghan on 4/16/2018.
 */
public class Cache {
    public Vector<Block> vec;

    private double hitRatio;
    private boolean isSpecialized;
    Victim victim;

    public Cache(boolean isSpecialized) {
        vec = new Vector<>();
        this.isSpecialized = isSpecialized;
        victim = new Victim();
        for (int i = 0; i < (int) Math.pow(2, 8); i++) {
            vec.add(new Block());
        }
    }

    public boolean found(String address) {
        String X = address.substring(0, address.length() - 4);
        String Y = X.substring(address.length() - 12, X.length());
        String tag = X.substring(0, address.length() - 12);
        Block b = vec.elementAt(toNumber(Y));
        if (!b.isValid){
            b.isValid = true;
            b.setTag(tag);
            return false;
        }
        else if (b.getTag().equals(tag)) {
            return true;
        } else if (!isSpecialized) {
            b.setTag(tag);
            return false;
        } else if (victim.found(address, X)) {
            return true;
        }
        b.setTag(tag);
        return false;
    }

    private int toNumber(String add) {
        return Integer.parseInt(add, 2);
    }

    public void process(String[] allAdds) {
        int hitNum = 0;
        for (int i = 0; i < allAdds.length; i++) {
            if (found(allAdds[i]))
                hitNum++;
        }
        hitRatio = ((double) hitNum/500);
        System.out.println(hitRatio);
    }
}
