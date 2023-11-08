from flask_app.config.mysqlconnetions import connectToMySQL
from flask_app.models import ninja

class Dojo:
    def __init__(self, data):
        self.id=data['id']
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        self.ninjas = []

    @classmethod
    def get_all_dojos(cls):
        query="select * from dojos;"
        results=connectToMySQL('dojos_and_ninjas_schema').query_db(query)
        print(results)
        dojos=[]
        for dojo in results:
            dojos.append(cls(dojo))
        return dojos
    
    @classmethod
    def dojos_and_ninjas(cls, data):
        query="select * from dojos left join ninjas on ninjas.dojo_id=dojos.id where dojos.id=%(id)s;"
        results= connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        print(results)
        if results:
            dojo=cls(results[0])
            for row_from_db in results:
                ninjasdata={
                    "id": row_from_db["ninjas.id"],
                    "first_name": row_from_db["first_name"],
                    "last_name": row_from_db["last_name"],
                    "age": row_from_db["age"],
                    "created_at": row_from_db["ninjas.created_at"],
                    "updated_at": row_from_db["ninjas.updated_at"],
                    "dojo_id": row_from_db["dojo_id"]
                }
                dojo.ninjas.append(ninja.Ninja(ninjasdata))
                
            return dojo
        
    @classmethod
    def add_dojo(cls, data):
        query="insert into dojos(name) values (%(name)s);"
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)

