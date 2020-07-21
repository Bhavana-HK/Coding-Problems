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

dataRows = [];
const rowGetter =(i) => ({ ...dataRows[i], id: i });
console.log(rowGetter(0));
console.log(rowGetter(1));