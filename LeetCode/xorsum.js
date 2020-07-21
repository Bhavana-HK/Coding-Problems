/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function(n, start) {
    let ans = start;
    for(let i=0; i<n; i++){
        ans ^= ((i<<1)+start);
    }
    return ans;
};

xorOperation(1, 7);