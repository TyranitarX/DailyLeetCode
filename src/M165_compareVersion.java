public class M165_compareVersion {
    public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int index0 = 0;
        int index1 = 0;
        while (index0 < version1s.length && index1 < version2s.length) {
            int a = Integer.parseInt(version1s[index0++]);
            int b = Integer.parseInt(version2s[index1++]);
            if (a > b) return 1;
            if (a < b) return -1;
        }
        while (index0 < version1s.length) {
            int a = Integer.parseInt(version1s[index0++]);
            if (a > 0) return 1;
        }
        while (index1 < version2s.length) {
            int a = Integer.parseInt(version2s[index1++]);
            if (a > 0) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String ver1 = "1.01.01";
        String ver2 = "1.001";
        System.out.println(new M165_compareVersion().compareVersion(ver1, ver2));
    }
}
