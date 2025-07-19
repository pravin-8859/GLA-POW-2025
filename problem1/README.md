My Solution 1: Binary Search (Fast Way)
How It Works
I used binary search because we need O(log N) time. The idea is to find the point where the array rotates, as that’s where the smallest element is. Here’s what I did:

Take two pointers: low starts at the beginning (0), high at the end (N-1).

While low is less than high:

Find the middle: mid = low + (high - low) / 2 (this avoids overflow).

If the middle element is bigger than the last element (arr[mid] > arr[high]), the smallest number must be in the right half, so move low to mid + 1.

Otherwise, the smallest number is in the left half (including mid), so move high to mid.

At the end, low points to the smallest element.

Complexity
Time: O(log N) because we cut the search space in half each step.

Space: O(1) since we only use a few variables.

Code: problem1/MinRotatedArrayBinary.java

My Solution 2: Linear Search (Simple Way)
How It Works
I also tried a simpler approach by checking every element in the array to find the smallest one. It’s not as fast, but it’s easy to understand:

Start with the first element as the minimum.

Loop through the array and update the minimum if you find a smaller number.

Return the minimum at the end.

Complexity
Time: O(N) because we check every element.

Space: O(1) since we only store one variable for the minimum.

Code: problem1/MinRotatedArrayLinear.java

Why I Chose Binary Search
The binary search is way faster for big arrays (up to 10^5 elements), which is what the problem asks for. The linear search is okay for small arrays but too slow for large ones. I included both to show I can solve it in different ways, but binary search is the real deal for placements.