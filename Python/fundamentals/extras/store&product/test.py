from Product import Product
from Store import Store
if __name__ == "__main__":
    # Create store instance
    store = Store("Tech Store")

    # Create product instances
    product1 = Product("Laptop", 1000, "Electronics")
    product2 = Product("Headphones", 200, "Electronics")
    product3 = Product("Shirt", 30, "Clothing")

    # Add products to the store
    store.add_product(product1)
    store.add_product(product2)
    store.add_product(product3)

    # Test methods
    product1.print_info()
    store.sell_product(product1.id)
    store.inflation(5)
    store.set_clearance("Clothing", 10)
    product3.print_info()
