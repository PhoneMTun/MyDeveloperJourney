from flask_app.config.mysqlconnetions import connectToMySQL
from flask import flash

class Cookie_order:
    def __init__(self, data):
        self.id=data['id']
        self.customer_name=data['customer_name']
        self.cookie_type=data['cookie_type']
        self.no_of_boxes=data['no_of_boxes']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM cookie_orders;"
        results = connectToMySQL('cookie_orders').query_db(query)
        cookie_orders = []
        for cookie_order in results:
            cookie_orders.append(cls(cookie_order))
        return cookie_orders
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO cookie_orders(customer_name, cookie_type, no_of_boxes) values (%(customer_name)s, %(cookie_type)s, %(no_of_boxes)s);"
        results = connectToMySQL('cookie_orders').query_db(query,data)
        return results
    
    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM cookie_orders where id = %(id)s;"
        results = connectToMySQL('cookie_orders').query_db(query,data)
        return cls(results[0])
    
    @classmethod
    def update(cls,data):
        query = """UPDATE cookie_orders 
                set customer_name=%(customer_name)s,cookie_type=%(cookie_type)s,no_of_boxes=%(no_of_boxes)s,updated_at=NOW()
                WHERE id = %(id)s;"""
        return connectToMySQL('cookie_orders').query_db(query,data)
    
    @staticmethod
    def validate_CookieOrder(cookie_order):
        isvalid = True
        if len(cookie_order['customer_name'])<2:
            flash("Invalid name input")
            isvalid = False
        if len(cookie_order['cookie_type'])<2:
            flash("Invalid cookie_type input")
            isvalid = False
        if int(cookie_order['no_of_boxes'])<0:
            flash("Please enter a valid number")
            isvalid = False
        return isvalid