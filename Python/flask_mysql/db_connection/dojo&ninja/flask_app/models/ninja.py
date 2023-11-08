from flask_app.config.mysqlconnetions import connectToMySQL
from flask_app.models import dojo

class Ninja:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at'] 
        self.dojo_id=data['dojo_id']

    @classmethod
    def get_one_by_id(cls,ninja_id):
        query = '''select * from ninjas where id= %(id)s;'''
        data = {'id': ninja_id}
        results= connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        return cls(results[0])
    
    @classmethod
    def add_ninja(cls, data):
        query="insert into ninjas(first_name, last_name, age, dojo_id ) values (%(first_name)s, %(last_name)s, %(age)s, %(dojo_id)s);"
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
    
    @classmethod
    def edit_ninja(cls,data):
        query="""UPDATE ninjas 
            SET first_name=%(first_name)s, last_name=%(last_name)s, age=%(age)s 
            WHERE id=%(id)s;"""
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
    
    @ classmethod
    def destroy(cls,ninja_id):
        query= "Delete from ninjas where id=%(id)s;"
        data={
            "id": ninja_id
        }
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
    
    @classmethod
    def update_ninaja(cls, data):
        query = """UPDATE ninjas 
               SET first_name=%(first_name)s, last_name=%(last_name)s, age=%(age)s 
               WHERE id=%(id)s;"""
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)