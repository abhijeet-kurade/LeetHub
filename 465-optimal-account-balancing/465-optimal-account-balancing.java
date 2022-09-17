class Solution {
    public int minTransfers(int[][] transactions) {
        return minTransactions(transactions);
    }
    
    public int minTransactions(int[][] transactions){
        HashMap<Integer, Integer> account = new HashMap<>();
        for(int[] transaction : transactions){
            int amount = transaction[2];
            int r = transaction[0], s = transaction[1];
            account.put(r, account.getOrDefault(r, 0) + amount);
            account.put(s, account.getOrDefault(s, 0) - amount);
        }
        List<Integer> nums = new ArrayList<>();

        for(int key : account.keySet()){
            if(account.get(key) == 0) continue;
            nums.add(account.get(key));
        }
        return dfs(0, nums);
    }
    public int dfs(int idx, List<Integer> nums){
        int n = nums.size();
        if(idx >= n) return 0;
        if(nums.get(idx) == 0) return dfs(idx+1, nums);
        int curr = nums.get(idx);
        int minTransactions = Integer.MAX_VALUE;
        for(int i=idx+1; i<n; i++){
            int next = nums.get(i);
            if(curr * next < 0){
                nums.set(i, curr + next);
                int transactions = dfs(idx+1, nums) + 1;
                minTransactions = Math.min(minTransactions, transactions);
                //if(curr + next == 0) break;
                nums.set(i, next);
            }

        }
        return minTransactions;
    }
}