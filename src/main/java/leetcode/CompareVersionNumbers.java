package leetcode;

/**
 * https://leetcode.com/problems/compare-version-numbers/#/description
 * <p>
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] splitOne = version1.split("\\.");
        String[] splitTwo = version2.split("\\.");

        for (int i = 0; i < Math.max(splitOne.length, splitTwo.length); i++) {
            Integer signifOne = i < splitOne.length ? Integer.valueOf(splitOne[i]) : 0;
            Integer signifTwo = i < splitTwo.length ? Integer.valueOf(splitTwo[i]) : 0;
            int compare = signifOne.compareTo(signifTwo);

            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public int compareVersionWithoutSplit(String version1, String version2) {
        int temp1 = 0;
        int temp2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;
        while (i<len1 || j<len2) {
            temp1 = 0;
            temp2 = 0;

            while(i<len1 && version1.charAt(i) != '.') {
                temp1 = temp1*10 + version1.charAt(i++)-'0';

            }
            while (j<len2 && version2.charAt(j) != '.') {
                temp2 = temp2*10 + version2.charAt(j++)-'0';

            }
            if (temp1>temp2) {
                return 1;
            }
            else if(temp1<temp2) {
                return -1;
            } else {
                i++;
                j++;

            }

        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();

        System.out.println(obj.compareVersion("11", "12"));
        System.out.println(obj.compareVersion("1", "1.1"));
    }
}
