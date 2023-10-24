import random
from flask import Flask, render_template,session, redirect, request
app = Flask(__name__)
app.secret_key = 'Hello'
@app.route('/')
def index():
    if "num" not in session:
        session["num"] =random.randint(1,100)
        print("rand: " + str(session["num"]))
    return render_template('guess.html')

@app.route('/guess', methods=['Post'])
def guess():
    session["guess"] = int(request.form['guess'])
    print("guess: " + str(session["guess"]))
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)



