## Bit Manipulation

For SET ith bit
```
N = N | (1 << i)

```

For toggle ith bit

```
N = N ^ (i <<i)

```

For unset ith bit
```
N & (1 << i) > 0 , bit is set

then 
N = N ^ (1 << i)
```

ith bit SET or UNSET
```
N &  (1 << i)

```