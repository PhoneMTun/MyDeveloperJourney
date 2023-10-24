from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    first_name=request.form['first_name']
    last_name=request.form['last_name']
    student_id=request.form['student_id']
    selected_apple=request.form['apple']
    selected_raspberry=request.form['raspberry']
    selected_strawberry=request.form['strawberry']

    print(request.form)
    print(f'Charging {first_name} {last_name} for {int(selected_apple)+int(selected_raspberry)+ int(selected_strawberry)}')
    return render_template("checkout.html", first_name=first_name, last_name=last_name, student_id=student_id, selected_apple=selected_apple, selected_raspberry=selected_raspberry,selected_strawberry=selected_strawberry)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    