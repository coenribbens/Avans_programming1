public class StringUtils {


    public static boolean included(String word, String searched) {
        searched.trim();
        if (searched.toLowerCase().contains(word.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
