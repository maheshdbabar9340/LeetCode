// Approach1:Using ArrayList[T.C:O(n),S.C:O(n)]
// Explanation:Store all the digits in arraylist and then traverse the list backward and keep adding the element in your answer after multilying it by suitable power of 2.

class Solution {
    public int getDecimalValue(ListNode head) {

        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int p = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int pow = (1 << p); // Finding 2 to the power p
            res += (pow * list.get(i));
            p++;
        }

        return res;
    }
}

// Similar Way

class Solution {
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int count = arr.size();
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 1) {
                ans += Math.pow(2, count - 1);
            }
            count--;
        }
        return ans;
    }
}

// Approach2:Using String[T.C:O(n),S.C:O(n)]
// Explanation: Strore all the digits in a String and then convert it into
// decimal.

class Solution {
    public int getDecimalValue(ListNode head) {
        String s = "";
        while (head != null) {
            s = s + Integer.toString(head.val);
            head = head.next;
        }

        return Integer.parseInt(s, 2); // we can pass the radix also in which the number has to be converted
    }
}

// Approach3: One Pass Solution Using Maths[T.C: O(n), S.C: O(1)]
// Explanation: To explain binary number..let first understand the decimal
// number.
// So if you have given digits 1,2,3 and you have to make the number then you
// will do - 1 * 100 + 2 * 10 + 1 = 123. But in starting we don't know whether
// to multiply the current digit with 10 or 100 or 1000 etc., so what we do is
// just take the first digit in answer and then if we encounter next digit then
// multiply the previous answer by 10 and then add the current number.
// Example:

// Lets the digits are 1,2,3,4 and let the ans is 0.
// Iteration1 : ans = 1 (keep the first digit as it

// is or (0*10+1=1))
// Iteration2 : ans * 10 + 2 = 1*10 + 2 = 12
// Iteration3 : ans * 10 + 3 = 12*10 + 3 = 123
// Iteration4 : ans * 10 + 4 = 123*10 + 4 = 1234
// So each time when we encountered a digit, we multiplied the previous ans by
// 10 and then add the current digit.
// Similar is the case with binary conversion. Here we were mutliplying the prev
// ans by 10 but in binary we have multiply it by 2.
// For example :

// Lets the digits are 1,0,1,1 and let ans is 0
// Iteration1 : ans = 1 (keep the first digit as it

// is or (0*2+1=1))
// Iteration2 : ans * 2 + 0 = 1*2 + 0 = 2
// Iteration3 : ans * 2 + 1 = 2*2 + 1 = 5
// Iteration4 : ans * 2 + 1 = 5*2 + 1 = 11

class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }

        return res;
    }
}

// Approach4: Bit Manipulation
// Explanation: Logic Exactly same as Approach3...just the arithmetical
// operations are done using bit manipulation.
// As left shift of the number by 1 gives 2 times the number.
// 3<<1 = 6

class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = res << 1 | head.val; // res = res*2 + head.val;
            head = head.next;
        }

        return res;
    }
}