def calculateSum(numbers):
    sum=0
    for num in numbers:
        sum=sum+num
    return sum
listofnumbers=[1,2,3,4,5,6]
result=calculateSum(listofnumbers)
print("the sum of all elements:"+str(result))