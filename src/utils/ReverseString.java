package Utils;

public class ReverseString {
    public void reverseString(char[] s) {
        int low = 0;
        int hight = s.length - 1;

        while (hight > low) {
            char temp = s[low];
            s[low] = s[hight];
            s[hight] = temp;
            low++;
            hight--;
        }
    }
}
