// class Solution {
//     public int countPrimes(int n) {
//        int count = 0;
//        for (int i = 1; i < n; i++) {
//           if (isPrime(i)) count++;
//        }
//        return count;
//     }

//     private boolean isPrime(int num) {
//        if (num <= 1) return false;
//        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
//        // to avoid repeatedly calling an expensive function sqrt().
//        for (int i = 2; i * i <= num; i++) {
//           if (num % i == 0) return false;
//        }
//        return true;
//     }
// }

// class Solution {
//     public int countPrimes(int n) {
//         // set default prime to true
//         boolean isPrime[] = new boolean[n];
//         Arrays.fill(isPrime, true);
        
//         // sieve of eratosthenes
//         for (int num = 2; num * num < n; num++) {
//             if (!isPrime[num]) {
//                 continue;
//             }
            
//             for (int mul = num * num; mul < n; mul += num) {
//                 // System.out.println(mul);
//                 isPrime[mul] = false;
//             }
//         }
        
//         // count all the prime numbers
//         int count = 0;
//         for (int num = 2; num < n; num++) {
//             if (isPrime[num]) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
// }

class Solution {
    public int countPrimes(int n) {
        if(n<=1)return 0;
        boolean[] sieve=new boolean[n];
        for(int i=0;i<n;i++)
        {
            sieve[i]=true;
        }
        for(int i=2;i*i<n;i++)
        {
            if(sieve[i]==true)
            {
                for(int j=i*i;j<n;j+=i)
                {
                    sieve[j]=false;
                }
            }
        }
        int ctr=0;
        for(int i=2;i<n;i++)
        {
            if(sieve[i])
                ctr++;
        }
        return ctr;
    }
}


// Intuition behind solution: Initially consider all numbers as prime. Continuously iterate through numbers 2 - n and if the current number is prime, iterate through all numbers from the current number, i, up to i * i marking multiples of that numbers as not prime. Once the outer loop terminates, count the number of remaining true values in the array as though are the number of prime numbers.