class Product:
    id_count=0;
    def __init__(self,name, price, category):
        self.id=Product.id_count
        Product.id_count+=1;
        self.name = name
        self.price = price
        self.category = category


    def update_price(self, percent_change, is_increased):
        if is_increased:
            self.price += self.price * (percent_change/100)
        else:
            self.price -= self.price * (percent_change/100)

    def print_info(self):
        print(f"Product name: {self.name},Category: {self.category}, Price: {self.price})")
