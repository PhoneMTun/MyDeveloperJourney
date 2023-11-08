from flask_app.config.mysqlconnetions import connectToMySQL
from flask_app import app
from flask import flash
from flask_app.models.user import User

DB="recipes_schema"
class Recipe:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_mode= data['date_mode']
        self.under_30= data['under_30']
        self.user=  data['user']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']


    @classmethod
    def save(cls, data):
        query = "INSERT INTO recipes(name, description, instructions, date_mode, under_30, user_id) values (%(name)s, %(description)s, %(instructions)s,%(date_mode)s, %(under_30)s, %(user_id)s);"
        results = connectToMySQL(DB).query_db(query,data)
        print (results)
        return results
    
    @classmethod
    def delete (cls, recipe_id):
        query='''DELETE FROM recipes WHERE id = %(id)s;'''
        return connectToMySQL(DB).query_db(query, {"id": recipe_id})
    
    @classmethod
    def update(cls, recipe_id):
        query='''UPDATE recipes 
                set name=%(name)s,description=%(description)s,instructions=%(instructions)s,date_mode=%(date_mode)s,under_30=%(under_30)s
                WHERE id = %(id)s  '''
        return connectToMySQL(DB).query_db(query,recipe_id)
    
    @classmethod
    def get_all(cls):
        query='''select * from recipes
        join users on recipes.user_id=users.id'''
        print("in get all method")
        results=connectToMySQL(DB).query_db(query)
        # print(">>>>>>>>>" , results)
        all_results=[]
        for result in results:
            posting_user=User({
                "id": result["users.id"],
                "first_name": result["first_name"],
                "last_name": result["last_name"],
                "email": result["email"],
                "password": result["password"],
                "created_at": result["users.created_at"],
                "updated_at": result["users.updated_at"]
            })
            new_recipe= Recipe({
                "id": result["id"],
                "name": result["name"],
                "description": result["description"],
                "instructions": result["instructions"],
                "date_mode": result["date_mode"],
                "under_30": result["under_30"],
                "user": posting_user,
                "created_at": result["created_at"],
                "updated_at": result["updated_at"]
                })
            all_results.append(new_recipe)
            print(new_recipe.user.first_name)
        return all_results
    
    @classmethod
    def get_one(cls,recipe_id):
        query='''select * from recipes join users on recipes.user_id=users.id
        WHERE recipes.id = %(id)s'''
        data={'id':recipe_id}
        results=connectToMySQL(DB).query_db(query,data)
        recipe_dict=results[0]
        # print("xxxxxxxxxxxxxxxxxxxxxxx", recipe_dict)

        # recipe_obj=Recipe(recipe_dict)
        posting_user=User({
                "id": recipe_dict["users.id"],
                "first_name": recipe_dict["first_name"],
                "last_name": recipe_dict["last_name"],
                "email": recipe_dict["email"],
                "password": recipe_dict["password"],
                "created_at": recipe_dict["users.created_at"],
                "updated_at": recipe_dict["users.updated_at"]
            })
        new_recipe= Recipe({
                "id": recipe_dict["id"],
                "name": recipe_dict["name"],
                "description": recipe_dict["description"],
                "instructions": recipe_dict["instructions"],
                "date_mode": recipe_dict["date_mode"],
                "under_30": recipe_dict["under_30"],
                "user": posting_user,
                "created_at": recipe_dict["created_at"],
                "updated_at": recipe_dict["updated_at"]
                })

        

        print(">>>>>>>>>" , new_recipe)

        return new_recipe
    
    @staticmethod
    def validate_recipe(recipe):
        isvalid = True
        if len(recipe['name'])<3:
            flash("name must be at least 3 characters","create")
            isvalid = False
        if len(recipe['description'])<3:
            flash("description must be at least 3 characters","create")
            isvalid = False
        if len(recipe['instructions'])<3:
            flash("instructions must be at least 3 characters","create")
            isvalid = False
        if len(recipe['date_mode'])<=0:
            flash("Pick a date","create")
            isvalid = False
        if 'under_30' not in recipe or recipe['under_30'] not in ["0", "1"]:
            flash("Pick yes or no","create")
            isvalid = False
        return isvalid
        
    