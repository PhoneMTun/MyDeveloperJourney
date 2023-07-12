class Pet:
    def __init__(self,name, type, tricks,noise):
        self.name = name
        self.type = type
        self. tricks = tricks
        self.health = 100
        self.eneregy = 50
        self.noise=noise
        

    def sleep(self):
        self.eneregy+= 25
        return self

    def eat(self):
        self.eneregy+=5
        self.health+=10
        return self


    def play(self):
        self.health+=5
        self.eneregy-=15
        return self


    def noise(self):
        print(self.noise)
        return self