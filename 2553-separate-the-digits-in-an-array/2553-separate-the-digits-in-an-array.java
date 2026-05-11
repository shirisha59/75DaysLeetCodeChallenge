class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int num : nums){
            Stack<Integer> stack=new Stack<>();
            while(num>0){
                stack.push(num%10);
                num=num/10;
            }
            while(!stack.isEmpty()){
                res.add(stack.pop());
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;

    }
}