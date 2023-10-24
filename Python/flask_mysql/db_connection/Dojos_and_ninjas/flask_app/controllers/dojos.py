from flask import render_template,request,redirect
from flask_app import app
from flask_app.models.dojo import Dojo
from flask_app.models.ninja import Ninja

@app.route('/')
@app.route('/dojos')
def create():
    all_dojos=Dojo.get_all()
    return render_template('dojo.html', dojos=all_dojos)

@app.route('/dojos/create', methods=['POST'])
def add():
    print(request.form)
    Dojo.save(request.form)
    return redirect('/dojos')

@app.route('/ninjas')
def ninja(): 
    return render_template('new_ninja.html', dojos=Dojo.get_all())


@app.route('/ninjas/create', methods=['POST'])
def add_ninja():
    print(request.form)
    Ninja.save(request.form)
    return redirect('/dojos')

@app.route('/dojos/<int:id>')
def show(id):
    data={
        'id':id,
    }
    return render_template("dojo_show.html", dojo=Dojo.dojo_ninja(data))

@app.route('/ninjas/edit/<ninja_id>')
def edit_page(ninja_id):
    ninja = Ninja.get_one_by_id(ninja_id)
    return render_template('edit_ninja.html', ninja=ninja)

@app.route('/ninjas/destroy/<ninja_id>/<dojo_id>')
def destroy_ninja(ninja_id,dojo_id):
    Ninja.destroy(ninja_id)
    return redirect(f'/dojos/{dojo_id}')


@app.route('/ninjas/update', methods=['POST'])
def update_ninaja():
    Ninja.update(request.form)
    return redirect(f'/dojos/{request.form["dojo_id"]}')




