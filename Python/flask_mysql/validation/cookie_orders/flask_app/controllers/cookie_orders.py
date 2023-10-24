from flask import render_template,redirect,request
from flask_app import app
from flask_app.models.cookie_order import Cookie_order

@app.route('/')
@app.route('/cookies')
def cookie_order():
    return render_template("cookie_order.html", cookie_orders=Cookie_order.get_all())

@app.route('/cookies/new')
def log_order():
    return render_template('new_order.html')

@app.route('/cookies/new/add', methods=['POST'])
def add_order():
    if not Cookie_order.validate_CookieOrder(request.form):
        print ("fail")
        return redirect("/cookies/new")
    else:
        Cookie_order.save(request.form)
        return redirect('/')

@app.route('/cookies/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("change.order.html",cookie_order=Cookie_order.get_one(data))

@app.route('/cookies/update/<int:id>', methods=['POST'])
def update(id):
    if not Cookie_order.validate_CookieOrder(request.form):
        print ("fail")
        return redirect(f"/cookies/edit/{id}")
    else:

        Cookie_order.update(request.form)
        return redirect('/cookies')