// https://leetcode.com/problems/xor-operation-in-an-array/

/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function(n, start) {
    let ans = start;
    for(let i=1; i<n; i++){
        ans ^= start + (i<<1);
    }
    return ans;
};