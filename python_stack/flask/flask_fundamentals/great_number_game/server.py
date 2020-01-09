from flask import Flask, render_template, session, redirect,request
app = Flask(__name__)
app.secret_key = 'keep it secret'
import random 

@app.route('/')
def index():
    if 'random_num' in session:
        pass
    else:
        session['random_num'] = random.randint(1, 100)
        session['guess'] = 'none'

    return render_template('index.html', guess = session['guess'], number = session['random_num'])

@app.route('/process', methods = ['POST'])
def process():
    guess = int(request.form['number'])
    if guess == session['random_num']:
        session['guess'] = 'You got it'
    elif guess > session['random_num']:
        session['guess'] = 'Too high'
    elif guess < session['random_num']:
        session['guess'] = 'Too low'
    return redirect("/")

@app.route('/destroy')
def destroy():
    session.clear()
    return redirect('/')

app.run(debug = True)