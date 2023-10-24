# from ninja import Ninja
import random
class Pirate():

    def __init__( self , name ):
        self.name = name
        self.strength = 15
        self.speed = 3
        self.health = 100
        self.stamina = 6

    def show_stats( self ):
        print(f"Name: {self.name}\nStrength: {self.strength}\nSpeed: {self.speed}\nHealth: {self.health}\nStamina: {self.stamina}")

    def attack( self , pirate ):
        pirate.health -= self.strength
        return self
    
    def critical_attack( self , pirate ):
        pirate.health -= self.strength+self.speed*50/100
        return self
    
    def doge( self ):
        print("You missed your attack Pirate!!!")
        self.health += 5
        return self
    
    def combo_attack( self, pirate):
        if self.health <= 10:
            pirate.health -= (self.strength+self.speed)*random.randint(1,4)
        return self
    
    def use_weapon(self,pirate):
        self.critical_attack(pirate)
        self.critical_attack(pirate)
        return self
    
    def rest(self):
        self.stamina += 2
        return self
    
    @classmethod
    def celebrate(cls, name):
        print(f"Legendary {name} wins!")

