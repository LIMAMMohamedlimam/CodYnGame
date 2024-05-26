import random

def generate_data():
    number1 = random.randint(1, 100)
    number2 = random.randint(1, 100)
    return {'number1': number1, 'number2': number2}



def verifysolution(data, func):
    try:
        result = func(data)
        correct_product = data['number1'] * data['number2']
        correct_sum = data['number1'] + data['number2']
        if result['product'] == correct_product and result['sum'] == correct_sum:
            print("ok")
        else:
            print("no")
    except Exception as e:
        print("no")


