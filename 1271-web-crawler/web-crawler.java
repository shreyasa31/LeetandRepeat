/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    String getHostName(String startUrl){
        return startUrl.split("/")[2];
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res=new ArrayList<>();
        String hostName=getHostName(startUrl);
        System.out.println(htmlParser.getUrls(startUrl));

       Queue<String> queue=new LinkedList<>();
       queue.add(startUrl);
      HashSet<String> set=new HashSet<>();
      set.add(startUrl);
      res.add(startUrl);
       while(!queue.isEmpty()){
        String curr=queue.poll();

        for(String s: htmlParser.getUrls(curr)){
            if( !set.contains(s) && s.contains(hostName)){
                res.add(s);
                set.add(s);
                queue.add(s);
            }
        }
       }
       return res;
    }
}