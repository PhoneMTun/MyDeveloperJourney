from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re
# model the class after the friend table from our database
class User:
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    #Read All
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL('user_schema').query_db(query)
        users = []
        for user in results:
            users.append(cls(user))
        return users
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO users(first_name, last_name, email) values (%(first_name)s, %(last_name)s, %(email)s);"
        results = connectToMySQL('user_schema').query_db(query,data)
        return results
    
    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM users where id = %(id)s;"
        results = connectToMySQL('user_schema').query_db(query,data)
        return cls(results[0])
    
    @classmethod
    def update(cls,data):
        query = """UPDATE users 
                set first_name=%(first_name)s,last_name=%(last_name)s,email=%(email)s,updated_at=NOW()
                WHERE id = %(id)s;"""
        return connectToMySQL('user_schema').query_db(query,data)
    
    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM users where id=%(id)s;"
        return connectToMySQL('user_schema').query_db(query,data)
    
    @classmethod
    def email_exists(cls, email):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        data = {'email': email}
        results = connectToMySQL('user_schema').query_db(query, data)
        return results

    @staticmethod
    def validate_user(user):
        is_valid=True
        if len(user['first_name'])<1:
            flash("First Name is required")
            is_valid=False
        if len(user['last_name'])<1:
            flash("Last Name is required")
            is_valid=False
        if len(user['email'])<1:
            flash("Email is required")
            is_valid=False
        if User.email_exists(user['email']):
            flash("Email already exists")
            is_valid=False
        elif not re.match(r"[^@]+@[^@]+\.[^@]+", user['email']):
            flash("Invalid email format")
            is_valid = False
        return is_valid
        