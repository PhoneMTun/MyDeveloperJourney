from pet import Pet

class Ninja(Pet):
    def __init__(self,first_name, last_name,  treats, pet_food, pet,):
        super().__init__(pet.name, pet.type, pet.tricks, pet.noise)
        self.first_name = first_name
        self.last_name = last_name
        self.pet = pet
        self.treats = treats
        self.pet_food = pet_food

    def walk(self):
        self.pet.play()
        return self
    
    def feed(self):
        self.pet.eat()
        self.pet.health+=50
        print(f"Feeding {self.pet.name}!")
        return self
    
    def bathe(self):
        self.pet.noise()
        
treats = ['Banana', 'Chips', 'egg']
pet_food =['Orange', 'Apple' ,'Grapes']

nibbles = Pet("ChuChu","Monkey",['nibbles on things','is invisible'],"Hey Hey")
Round1=Ninja("Phone", "Tun", treats, pet_food, nibbles)


Round1.feed()