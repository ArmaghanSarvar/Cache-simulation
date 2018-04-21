/**
 * Created by Armaghan on 4/17/2018.
 */
public class VictimBlock {
    public int counter;
    boolean isValid;
    private String tag = "0000000000000000000000000000";

    public VictimBlock() {
        isValid = false;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }


}
