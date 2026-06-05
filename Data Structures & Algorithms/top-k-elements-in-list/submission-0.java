class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Step 2: Create bucket
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for (int key : map.keySet()) {
            int f = map.get(key);
            freq[f].add(key);
        }

        // Step 4: Collect result
        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
                if (index == k) return res;
            }
        }

        return res;
    }
}