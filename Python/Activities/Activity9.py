firstlist=[1,2,3,4]
secondlist=[2,3,4,5]
thirdlist=[]
for num in firstlist:
    if (num % 2 != 0):
        thirdlist.append(num)

for num in secondlist:
    if (num % 2 == 0):
        thirdlist.append(num)

        print("result list")
        print(thirdlist)
