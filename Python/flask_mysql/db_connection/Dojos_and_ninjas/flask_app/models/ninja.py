from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import dojo

class Ninja:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at'] 


    @classmethod
    def save(cls,data):
        query = "Insert into  ninjas (first_name, last_name, age, dojo_id, created_at,updated_at) values(%(first_name)s, %(last_name)s, %(age)s, %(dojo_id)s, NOW(),NOW() );"
        results = connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        return results
    
    @classmethod
    def get_one_by_id(cls, ninja_id):
        query=f'''Select * from ninjas 
        where id={ninja_id};'''
        data={
            "ninja_id": ninja_id,
        }
        print (ninja_id)
        result_list= connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        ninja=result_list
        return ninja
    
    
    @ classmethod
    def destroy(cls,ninja_id):
        query= "Delete from ninjas where id=%(ninja_id)s;"
        data={
            "ninja_id": ninja_id
        }
        connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        return ninja_id
    
    @classmethod
    def update(cls, data):
        query = """UPDATE ninjas 
               SET first_name=%(first_name)s, last_name=%(last_name)s, age=%(age)s 
               WHERE id=%(id)s;"""
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)


    
    
        
        
        
        