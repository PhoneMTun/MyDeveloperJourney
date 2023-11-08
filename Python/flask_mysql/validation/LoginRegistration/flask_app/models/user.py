from flask_app.config.mysqlconnetions import connectToMySQL
from flask import flash
import re


class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def save(cls,data):
        query = "insert into users (first_name, last_name, email, password) values(%(first_name)s, %(last_name)s,%(email)s, %(password)s);"
        results= connectToMySQL('loginregistration').query_db(query,data)
        return results
    
    @classmethod
    def get_all(cls):
        query = "select * from users;"
        results = connectToMySQL('loginregistration').query_db(query)
        users=[]
        for user in results:
            users.append(cls(user))
        return users
    
    @classmethod
    def get_by_email(cls,data):
        query="""Select * from users where email = %(email)s;"""
        results= connectToMySQL('loginregistration').query_db(query,data)
        print(results)
        if len(results) <1:
            return False
        return cls(results[0])
    
    @classmethod
    def get_by_id(cls,data):
        query="""Select * from users where id = %(id)s;"""
        results= connectToMySQL('loginregistration').query_db(query,data)
        print(results)
        return cls(results[0])
    

    @classmethod
    def email_exists(cls, email):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        data = {'email': email}
        results = connectToMySQL('loginregistration').query_db(query, data)
        return results


    @staticmethod
    def validate_user(user):
        is_valid = True
        query="""Select * from users where email = %(email)s;"""
        results= connectToMySQL('loginregistration').query_db(query,user)
        if len(user['first_name'])<2:
            flash("First Name should be at least 2 characters","register")
            is_valid = False
        if len(user['last_name'])<2:
            flash("Last Name should be at least 2 characters","register")
            is_valid = False
        if len(user['password'])<8:
            flash("Password should be at least 8 characters","register")
            is_valid = False
        if not re.search(r'(?=.*\d)(?=.*[A-Z])', user['password']):
            flash("Password should contain at least 1 digit and 1 uppercase letter", "register")
            is_valid = False
        if user['password'] != user.get('Rpassword'):
            flash("Passwords do not match!","register")
            is_valid = False
        if User.email_exists(user['email']):
            flash("Email already exists","register")
            is_valid=False
        elif not re.match(r"[^@]+@[^@]+\.[^@]+", user['email']):
            flash("Invalid email format", "register")
            is_valid = False
            
        return is_valid


