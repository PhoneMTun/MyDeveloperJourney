#  given a list of numbers , return a new list with just the even numbers
old_list = [3,6,8,9,2,5,6,0,1]
new_list = []

for i in range(len(old_list)):
    if old_list[i]%2==0:
        new_list.append(old_list[i])

print(new_list)