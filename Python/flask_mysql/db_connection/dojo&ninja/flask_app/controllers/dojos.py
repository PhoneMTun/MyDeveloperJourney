from flask import render_template,request,redirect
from flask_app import app
from flask_app.models import ninja
from flask_app.models import dojo


@app.route('/')
@app.route('/dojos')
def index():
    return render_template('dojos.html',dojos=dojo.Dojo.get_all_dojos())



@app.route('/dojos/<int:id>')
def show(id):
    data={
        'id': id,
    }
    return render_template('dojo_show.html',dojo= dojo.Dojo.dojos_and_ninjas(data))

@app.route('/dojos/add', methods=['Post'])
def add_dojos():
    print(request.form)
    dojo.Dojo.add_dojo(request.form)
    return redirect('/dojos')