def fibonnaci(num):
    if num<=1:
        return num
    else:
        return(fibonnaci(num-1)+fibonnaci(num-2))
nterms= int(input("how many Fibonnaci numbers to generate"))
if nterms <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
for i in range(nterms):
    print(fibonnaci(i))
