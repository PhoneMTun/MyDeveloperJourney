from flask import render_template,request, redirect
from flask_app import app
from flask_app.models import ninja
from flask_app.models import dojo

@app.route('/ninjas')
def ninjas_page():
    return render_template('ninjas.html', dojos=dojo.Dojo.get_all_dojos())

@app.route('/ninjas/add', methods=['POST'])
def add_ninjas():
    print(request.form)
    ninja.Ninja.add_ninja(request.form)
    return redirect('/dojos')

@app.route('/ninjas/edit/<ninja_edit_id>')
def edit_page(ninja_edit_id):
    print(f"+++++++++++++ {ninja_edit_id}")
    oneninja=ninja.Ninja.get_one_by_id(ninja_edit_id)
    return render_template('edit_ninja.html', ninja=oneninja)

@app.route('/ninjas/update', methods=['POST'])
def update_ninaja():
    ninja.Ninja.update_ninaja(request.form)
    return redirect(f'/dojos/{request.form["dojo_id"]}')

@app.route('/ninjas/destroy/<ninja_id>/<dojo_id>')
def delete(ninja_id,dojo_id):
    print(f'--------------------{ninja_id,dojo_id}')
    ninja.Ninja.destroy(ninja_id)
    return redirect('/')