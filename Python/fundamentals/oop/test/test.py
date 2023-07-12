import random
print("Running")
guess = random.randint(0, 8)
print(f"this is the answer: {guess}")
def guess_number():
    count = 0
    is_playing = True
    while is_playing:
        response = int(input("\nEnter your number: "))
        if guess == response:
            count += 1
            print("Correct answer!")
            print("Total guess:", count)
            is_playing = False
        elif guess < response:
            count += 1
            print("So close!!! too high!!")
            print("Total guess:", count)
            if count == 3:
                print("you lost!!")
                is_playing = False
        else: 
            count += 1
            print("Try again too low")
            print("Total guess:", count)
            if count == 3:
                print("you lost!!")
                is_playing = False

guess_number()