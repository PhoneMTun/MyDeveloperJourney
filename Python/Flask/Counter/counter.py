from flask import Flask,render_template, session, redirect, request
app = Flask(__name__)
app.secret_key = 'Hello'
@app.route('/')
def index():
    if "count" not in session:
        session["count"]=0
    else:
        session["count"]+=1
    return render_template('index.html')

@app.route('/add1')
def add():
    session["count"]+=1
    return redirect('/')


@app.route('/reset')
def add_vistis():
    session.clear()
    return redirect ('/')

@app.route('/add2')
def add2():
    session["count"]+=1
    return redirect('/')

@app.route('/custom',methods=['Post'])
def custom():
    num=int(request.form['optional'])-1
    session["count"]+=num

    print(request.form)
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)