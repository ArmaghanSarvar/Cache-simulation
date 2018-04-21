import java.util.Vector;

/**
 * Created by Armaghan on 4/17/2018.
 */
public class Victim {
    public Vector<VictimBlock> vec;

    public Victim() {
        vec = new Vector<>();
        for (int i = 0; i < (int) Math.pow(2, 4); i++) {
            vec.add(new VictimBlock());
        }
    }

    public boolean found(String address, String victim) {
        String tag = address.substring(0, 28);
        boolean found = false;
        for (int i = 0; i < vec.size(); i++) {
            if (!vec.get(i).getTag().equals(tag)) {
                vec.get(i).counter++;
            } else {
                found = true;
            }
        }
        if (!found) {
            add(victim);
        }
        return found;
    }

    private void add(String victim) {
        int i = 0;
        boolean w = true;
        while (w && i<16) {
            VictimBlock b = vec.get(i);
            if (!b.isValid) {
                b.isValid = true;
                b.setTag(victim);
                w = false;
            }
            i++;
        }
        if (w) {
            int m = getMaxCounter();
            vec.get(m).counter = 0;
            vec.get(m).setTag(victim);
        }
    }

    private int getMaxCounter() {
        int max = 0, j = 0;
        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).counter > max) {
                max = vec.get(i).counter;
                j = i;
            }
        }
        return j;
    }
}
