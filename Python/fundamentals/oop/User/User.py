class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_reward_member=False
        self.gold_card_poits=0

    # def display_info(self):
    def display_info(self):
        print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
        print(f"Name: {self.first_name}")
        print(f"Last Name: {self.last_name}")
        print(f"Email: {self.email}")
        print(f"Age: {self.age}")
        print(f"Is Reward Member: {self.is_reward_member}")
        print(f"gold_card_poits: {self.gold_card_poits}")
        print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
        

    def enroll(self):
        # print(f"Name: {self.first_name}")
        # print(f"Last Name: {self.last_name}")
        # print(f"Email: {self.email}")
        # print(f"Age: {self.age}")
        if self.is_reward_member:
            print("User already a member")
            return False
        self.is_reward_member=True
        self.gold_card_poits=0+200

    def spend_points(self, amount):
        if (self.gold_card_poits)<amount:
            print("No more points")
            return
        self.gold_card_poits-=amount



    
User1_test = User("Phone", "Tun", "hanminseo10@gmail.com", 23)
User2_test = User("Chris", "Tun", "hanminseo10@gmail.com", 23)
User1_test.display_info()
User1_test.enroll()
User1_test.spend_points(50)
User1_test.display_info()

User2_test.enroll()
User2_test.spend_points(80)
User2_test.display_info()