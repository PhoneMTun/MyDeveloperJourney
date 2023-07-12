def countdown (num):
    list=[]
    for i in range(num,-1,-1):
        list.append(i)
        print (list)
countdown(5)

def print_and_return(list):
    print (list[0])
    return list[1]

print_and_return([1,2])

def sum (list):
    return list[0]+len(list)

print(sum([1,2,3,4,5]))

def greaterthansecond(list):
    if list[2]<len(list):
        return False
    newlist=[]
    for i in range(0,len(list)):
        if list[i]>list[1]:
            newlist.append(list[i])
    print (len(newlist))
    return newlist

    
print(greaterthansecond([5,2,3,2,1,4]))

def lengthandvalue(list1, list2):
    list=[]
    for i in range(0,list2):
        list.append(list1)
    print (list)

lengthandvalue(4,7)
