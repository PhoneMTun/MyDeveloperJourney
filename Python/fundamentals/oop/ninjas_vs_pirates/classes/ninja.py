from classes.pirate import Pirate
class Ninja(Pirate):
    def __init__(self, name):
        super().__init__(name)

    @classmethod
    def celebrate(cls, name):
        print(f"Legendary {name} wins!")

# ninja = Ninja('Naruto')

# # Calling the show_stats method
# print(ninja.show_class_stats())