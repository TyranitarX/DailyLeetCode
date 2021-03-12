public class M331_isValidSerialization {
    public boolean isValidSerialization(String preorder) {
        int slot = 1;
        int n = preorder.length();
        for (int i = 0; i < n; i++) {
            if (slot == 0)
                return false;
            if(preorder.charAt(i)==','){}
            else if(preorder.charAt(i)=='#')
                slot--;
            else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
            }
        }
        return slot == 0;
    }
}
