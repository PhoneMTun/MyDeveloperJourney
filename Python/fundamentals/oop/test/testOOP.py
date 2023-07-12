# - Simple game character class: Character
#             - attributes
#                 - name
#                 - energy
#                 - weapons

#             - methods
#                 - eat(food_name)
#                     - print "Fred at pizza"
#                     - increase energy by 5
#                     - return energy level

#                 - walk
#                     - decrease energy by 1
#                     - return energy level

#                 - add_weapon(weapon_name)
#                     - add to weapons
#                     - return list of weapons

class Character:
    def __init__(self, name, energy, weapons):
        self.name = name
        self.energy = energy
        self.weapons = [weapons]

    def eat(self, food_name):
        print(f"Fred at {food_name}")
        self.energy+=5
        return self.energy
    
    def walk(self):
        self.energy-=1
        return self.energy
    
    def add_weapon(self, weapon_name):
        self.weapons.append(weapon_name)
        return self 
    
game1= Character("Phone", 100, "Pistol")
game1.eat('Sausage')
print(game1.walk())
print(game1.add_weapon('Pistol').add_weapon('Orange').weapons)

