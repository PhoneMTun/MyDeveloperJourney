from flask import Flask, render_template,request,redirect,session
from flask_app import app
from flask_app.models.user import User

@app.route('/')
def create():
    # calling the get_all method from the friends.py
    all_users=User.get_all()
    # passing all friends to our template so we can display them there
    return render_template("create.html", users=all_users)


@app.route('/user/new')
def connect():
    # calling the get_all method from the friends.py
    # passing all friends to our template so we can display them there
    return render_template("Read(all).html")

@app.route('/user/old')
def Home():
    # calling the get_all method from the friends.py
    # passing all friends to our template so we can display them there
    return redirect("/")

@app.route('/user/create', methods=['POST'])
def add():

    session['first_name'] = request.form['first_name']
    session['last_name'] = request.form['last_name']
    session['email'] = request.form['email']


    if not User.validate_user(request.form):
        print('fail')
        return redirect("/user/new")
    else:

        User.save(request.form)
        return redirect("/")

@app.route('/user/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("Edit.html",user=User.get_one(data))

@app.route('/user/update', methods=['POST'])
def update():
    User.update(request.form)
    return redirect("/")

@app.route('/user/destroy/<int:id>')
def destroy(id):
    data ={ 
        "id":id
    }
    User.destroy(data)
    return redirect("/")

@app.route('/user/show/<int:id>')
def show(id):
    data ={ 
        "id":id
    }
    return render_template("show.html",user=User.get_one(data))

