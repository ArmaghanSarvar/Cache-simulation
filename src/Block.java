/**
 * Created by Armaghan on 4/16/2018.
 */
public class Block {
    String [] adds = new String[(int) Math.pow(2,4)];
    boolean isValid;
    private String tag = "00000000000000000000";

    public Block() {
        isValid = false;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
