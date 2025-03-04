
## Sieve of Eratosthenes

### Find all prime
```java
  public static List<Integer> findAllPrimes(int n) {
         // Initialize with 1 (assuming all
         // numbers are prime initially)
        List<Integer> prime = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            prime.add(1);
        }
        
        // 0 and 1 are not prime
        prime.set(0, 0);
        prime.set(1, 0);
        
        // Apply Sieve of Eratosthenes
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (prime.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    // Mark multiples of prime
                    // numbers as not prime
                    prime.set(j, 0);
                }
            }
        }
```

### Find all prime factors

```

        for(int i = 2; i <= A; i++) {
            if(sieve[i] == 0) {
                for(int j = i;  j <= A; j = j+i) {
                    sieve[j] = sieve[j] + 1;
                }
            }
        }
        return sieve;
```
