from flask import Flask, render_template, request, redirect 
app = Flask(__name__)
            

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/users', methods=['POST'])
def create_user():
    print(request.form)
    name= request.form['name'].capitalize()
    payment = request.form['payment'].capitalize()
    comment = request.form['comment']
    gender = request.form['gender']
    return render_template("results.html", name=name, payment=payment,comment=comment, gender=gender )


if __name__ == "__main__":
    app.run(debug=True)