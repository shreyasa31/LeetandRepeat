class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0;int j=0;
        while(i<v1.length || j<v2.length){
            int k1=i<v1.length ? Integer.parseInt(v1[i]):0;
            int k2=j<v2.length ? Integer.parseInt(v2[j]):0;

            if(k1<k2)return -1;
            if(k2<k1)return 1;
            i++;j++;
        }
        return 0;
    }
}