nums=list(input("enter a sequence of numbers").split(","))
firstelement=nums[0]
lastelement=nums[-1]
if(firstelement==lastelement):
    print(True)
else:
    print(False)