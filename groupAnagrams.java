class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> lst = new ArrayList<>();
        lst.add(strs[0]);
        map.put(strs[0],lst);
        Stack<String> temp=new Stack<>();
        for (int i=1;i<strs.length;i++) {
            temp.push(strs[i]);
        }
        while (temp.size()!=0) {
            String out=temp.pop();
            boolean flag=false;
            for (String k:map.keySet()) {
                if (comp(k,out)) {
                    flag=true;
                    ArrayList<String> t=map.get(k);
                    t.add(out);
                    map.put(k,t);
                } 
            }
            if (!flag) {
                ArrayList<String> t=new ArrayList<>();
                t.add(out);
                if (!map.containsKey(out)) map.put(out,t);
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        for (String k:map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }
    public boolean comp(String s, String r) {
        if (r.length()!=s.length()) return false;
        for (int i=0;i<s.length();i++) {
            if (r.indexOf(s.charAt(i))<0) return false;
            else r=r.substring(0,r.indexOf(s.charAt(i)))+r.substring(r.indexOf(s.charAt(i))+1);
        }
        return true;
    }
}
