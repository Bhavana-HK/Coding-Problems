// https://leetcode.com/problems/trapping-rain-water

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let result=0;
    let maxLeft = 0;
    let maxRight = 0;
    let leftMaxArray = [0];
    let rightMaxArray = [0];
    
    for(let i=1;i<height.length; i++){
        maxLeft =maxLeft > height[i-1] ? maxLeft : height[i-1];
        leftMaxArray.push(maxLeft);
    }
    
    for(let i=height.length-2; i>=0; i--){
        maxRight = maxRight > height[i+1] ? maxRight : height[i+1];
        rightMaxArray.unshift(maxRight);
    }
    
    for(let i=0;i<height.length; i++){
        let minHeight = Math.min(leftMaxArray[i], rightMaxArray[i]);
        if(minHeight > height[i])
            result = result + minHeight - height[i];
    }
    
    return result;
};