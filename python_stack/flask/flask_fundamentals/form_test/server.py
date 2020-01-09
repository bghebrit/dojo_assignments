from flask import Flask, render_template , request ,redirect,session
app = Flask(__name__)
app.secret_key = 'keep it secret'
# our index route will handle rendering our form
            
@app.route('/')
def index():
    return render_template("index.html")


@app.route('/users', methods=['POST'])
def create_user():
    print("Got Post Info")
    session['username'] = request.form['name']
    session['useremail'] = request.form['email']
    return redirect('/show')
#render_template("index.html", name = name, email = email)

@app.route('/show')
def show_method () :
    return render_template('/index.html')

if __name__ == "__main__":
    app.run(debug=True)