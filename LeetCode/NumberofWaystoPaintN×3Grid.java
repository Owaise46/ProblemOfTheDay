class Solution {
    public int numOfWays(int n) {
        long aba=6;
        long abc=6;
        long mod=1_000_000_007;

        for(int i=1; i<n; i++){
            long neatAba=(3*aba + 2*abc)%mod;
            long neatAbc=(2*aba + 2*abc)%mod;
            aba=neatAba;
            abc=neatAbc;
        }
        return (int)((aba+abc)%mod);
    }
}
