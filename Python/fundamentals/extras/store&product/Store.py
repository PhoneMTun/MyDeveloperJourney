from Product import Product
class Store:
    def __init__(self, name):
        self.name = name;
        self.products= [];


    def add_product(self, new_product):
        if new_product:
            self.products.append(new_product)
    
    def sell_product(self, id):
        for i in range(len(self.products)):
            if i==id:
                product=self.products.pop(i);
                product.print_info()
                break

    def inflation(self, percent_increase):
        for product in self.products:
            Product.update_price(product, percent_increase, True)

    def set_clearance(self, category, percent_discount):
        for product in self.products:
            if product.category == category:
                Product.update_price(product, percent_discount, False)
