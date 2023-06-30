def reqSum(n):
    if n:
        return n+reqSum(n-1)
    else:
        return 0
print("Sum is:",reqSum(10))