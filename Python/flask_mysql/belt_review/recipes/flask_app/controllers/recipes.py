from flask import render_template,redirect,session,request, flash
from flask_app import app
from flask_app.models.recipe import Recipe
from flask_app.models.user import User


@app.route('/recipes/add')
def add_page():
    user_id = session.get('user_id')
    return render_template('create.html', user_id=user_id )

@app.route('/recipes/<recipe_id>')
def view_recipe(recipe_id):
    print(">>>>>>>>>>>>>>>>>>>>>"+recipe_id)
    user_id = session.get('user_id')
    print(user_id)
    return render_template('view_recipe.html', each_recipe=Recipe.get_one(recipe_id), first_name=session.get('first_name'))


@app.route('/recipes/edit/<recipe_id>')
def edit_recipe_page(recipe_id):
    return render_template('edit.html', each_recipe=Recipe.get_one(recipe_id))

@app.route('/recipes/update', methods=['POST'])
def edit_recipe():
    if not Recipe.validate_recipe(request.form):
        print ("fail")
        return redirect (f"/recipes/edit/{request.form['id']}")
    print(request.form)
    Recipe.update(request.form)
    return redirect('/welcome')

@app.route('/recipes/new', methods=['POST'])
def add_order():
    if not Recipe.validate_recipe(request.form):
        print ("fail")
        return redirect("/recipes/add")
    print(request.form)
    Recipe.save(request.form)
    return redirect('/welcome')

@app.route ('/recipes/delete/<recipe_id>')
def delete_post(recipe_id):
    print("Deleting post-", recipe_id)
    Recipe.delete(recipe_id)
    return redirect ("/welcome")   

