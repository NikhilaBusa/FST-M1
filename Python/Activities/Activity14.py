def fib(n):
    if n==0:
        return n+1
    elif n<=1:
        return n
    else:
        return (fib(n-1)+fib(n-2))


n=int(input("How many numbers do we want in fibonacci series? "))

if n <= 0:
    print("Please enter a positive number")
else:
    for i in range(n):
        print(fib(i))
