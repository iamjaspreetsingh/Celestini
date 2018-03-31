Our Approach
Let num be the number to be searched in the array
1) Start with top right element of the array
2) Loop: compare this element e with num
    i) if they are equal then return true
    ii) e < num then move it to down (if out of bound of matrix then return false) 
    iii) e > x then move it to left (if out of bound of matrix then return false)
3) repeat the steps  i), ii) and iii) till you find element or returned false
