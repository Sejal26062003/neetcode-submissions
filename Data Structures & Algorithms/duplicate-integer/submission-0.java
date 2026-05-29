class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> map=new HashSet<>();
        for(int res:nums){
            if(map.contains(res)){
                return true;
            }
            map.add(res);
        }
        return false;
    }
}